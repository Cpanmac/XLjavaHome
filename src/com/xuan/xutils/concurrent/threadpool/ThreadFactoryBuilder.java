package com.xuan.xutils.concurrent.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/**
 * ����ThreadFactory������(����guava)
 * <p>
 * Created by xuan on 17/8/14.
 */
public class ThreadFactoryBuilder {
    /**
     * ���Ƹ�ʽ����
     */
    private String nameFormat = null;
    /**
     * �Ƿ����ػ��߳�
     */
    private Boolean daemon = null;
    /**
     * �߳����ȼ�
     */
    private Integer priority = null;
    /**
     * �̷߳����쳣��,δ��������ʱ,��ص�����쳣������
     */
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;
    /**
     * �̹߳���
     */
    private ThreadFactory backingThreadFactory = null;

    public ThreadFactoryBuilder() {
    }

    /**
     * �ڲ�����
     *
     * @param builder
     * @return
     */
    private static ThreadFactory build(ThreadFactoryBuilder builder) {
        final String nameFormat = builder.nameFormat;
        final Boolean daemon = builder.daemon;
        final Integer priority = builder.priority;
        final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = builder.uncaughtExceptionHandler;
        final ThreadFactory backingThreadFactory = (builder.backingThreadFactory != null) ? builder.backingThreadFactory : Executors.defaultThreadFactory();
        final AtomicLong count = (nameFormat != null) ? new AtomicLong(0) : null;
        return new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                Thread thread = backingThreadFactory.newThread(runnable);
                if (nameFormat != null) {
                    thread.setName(String.format(nameFormat, count.getAndIncrement()));
                }
                if (daemon != null) {
                    thread.setDaemon(daemon);
                }
                if (priority != null) {
                    thread.setPriority(priority);
                }
                if (uncaughtExceptionHandler != null) {
                    thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
                }
                return thread;
            }
        };
    }

    /**
     * ���߳���������,֧��format
     *
     * @param nameFormat
     * @return
     */
    public ThreadFactoryBuilder setNameFormat(String nameFormat) {
        String.format(nameFormat, 0);//���nameFormat��null����format��ʽ����,���������ش���
        this.nameFormat = nameFormat;
        return this;
    }

    /**
     * �����Ƿ��ػ�
     *
     * @param daemon
     * @return
     */
    public ThreadFactoryBuilder setDaemon(boolean daemon) {
        this.daemon = daemon;
        return this;
    }

    /**
     * �������ȼ�
     *
     * @param priority
     * @return
     */
    public ThreadFactoryBuilder setPriority(int priority) {
        //��Ȼ��Thread#setPriority()ʱ��У�����޼�����Ч��.����������ǰУ��һ��,��ʾЧ������,�������Ч������ǰУ�����
        checkArgument(priority >= Thread.MIN_PRIORITY, "Thread priority (%s) must be >= %s", priority, Thread.MIN_PRIORITY);
        checkArgument(priority <= Thread.MAX_PRIORITY, "Thread priority (%s) must be <= %s", priority, Thread.MAX_PRIORITY);
        this.priority = priority;
        return this;
    }

    /**
     * ����δ��׽�쳣������
     *
     * @param uncaughtExceptionHandler
     * @return
     */
    public ThreadFactoryBuilder setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.uncaughtExceptionHandler = checkNotNull(uncaughtExceptionHandler);
        return this;
    }

    /**
     * ����ThreadFactory
     *
     * @param backingThreadFactory
     * @return
     */
    public ThreadFactoryBuilder setThreadFactory(ThreadFactory backingThreadFactory) {
        this.backingThreadFactory = checkNotNull(backingThreadFactory);
        return this;
    }

    /**
     * ���ݲ�����ʼ����
     *
     * @return
     */
    public ThreadFactory build() {
        return build(this);
    }

    /**
     * expressionУ��
     *
     * @param expression
     * @param errorMessageTemplate
     * @param errorMessageArgs
     */
    private void checkArgument(boolean expression, String errorMessageTemplate, Object... errorMessageArgs) {
        if (!expression) {
            throw new IllegalArgumentException(format(errorMessageTemplate, errorMessageArgs));
        }
    }

    /**
     * %s��ʶ�����滻����ʵֵ
     *
     * @param template
     * @param args
     * @return
     */
    private String format(String template, Object... args) {
        template = String.valueOf(template); // null -> "null"
        // start substituting the arguments into the '%s' placeholders
        StringBuilder builder = new StringBuilder(template.length() + 16 * args.length);
        int templateStart = 0;
        int i = 0;
        while (i < args.length) {
            int placeholderStart = template.indexOf("%s", templateStart);
            if (placeholderStart == -1) {
                break;
            }
            builder.append(template.substring(templateStart, placeholderStart));
            builder.append(args[i++]);
            templateStart = placeholderStart + 2;
        }
        builder.append(template.substring(templateStart));
        // if we run out of placeholders, append the extra args in square braces
        if (i < args.length) {
            builder.append(" [");
            builder.append(args[i++]);
            while (i < args.length) {
                builder.append(", ");
                builder.append(args[i++]);
            }
            builder.append(']');
        }
        return builder.toString();
    }

    /**
     * �п�
     *
     * @param reference
     * @param <T>
     * @return
     */
    private <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }
}
