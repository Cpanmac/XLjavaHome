package com.xuan.xutils.concurrent.threadpool;

import com.xuan.xutils.utils.StringUtils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ͨ������ʵ��(���д���һ������)
 * <p>
 * Created by xuan on 17/8/14.
 */
public class XThreadPoolImpl implements XThreadPool {
    /**
     * �̳߳�����
     */
    private String name;
    /**
     * �ڲ�����ִ�з���
     */
    private ExecutorService executor;
    /**
     * ���ر��̳߳�ʱ�Ƿ�ر�����
     */
    private boolean waitForTasksToCompleteOnShutdown = false;
    /**
     * �������г���
     */
    private int queueCapacity = 1024;
    /**
     * �����߳���������ǿ϶��������߳���
     */
    private int corePoolSize = 10;
    /**
     * ����߳�����ʵ�����ܷ�ﵽ��ȡ���ڶ�����queueCapacity�Ƿ�����
     */
    private int maxPoolSize = 20;
    /**
     * �����̵߳Ĵ��ʱ�䣬Ϊ0��ʾһֱ���Դ��
     */
    private int keepAliveSeconds = 300;
    /**
     * �жϳ�ʱʱ�䣬Ĭ��5��
     */
    private int shutdownTimeout = 5000;
    /**
     * Ĭ�ϵľܾ�����
     */
    private RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.AbortPolicy();

    /**
     * �����̳߳�����
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ��������˵ȴ����������ô��ʹ��shutdown, ֹͣ���������񲢳�����������Ѵ�������.����ֱ�ӵ���shutdownNow ȡ������workQueue��Pending�����񣬲��ж���������������
     *
     * @throws Exception
     */
    public void destroy() throws Exception {
        if (this.waitForTasksToCompleteOnShutdown) {
            this.executor.shutdown();
        } else {
            this.executor.shutdownNow();
        }
        awaitTerminationIfNecessary();
    }

    /**
     * �ȴ��ر�
     */
    private void awaitTerminationIfNecessary() {
        if (this.shutdownTimeout > 0) {
            try {
                if (!this.executor.awaitTermination(this.shutdownTimeout, TimeUnit.SECONDS)) {
                    System.out.println("Timed out while waiting for executor" + (this.name != null ? " '" + this.name + "'" : "") + " to terminate");
                }
            } catch (InterruptedException ex) {
                System.out.println("Interrupted while waiting for executor" + (this.name != null ? " '" + this.name + "'" : "") + " to terminate");
                // (Re-)Cancel if current thread also interrupted
                this.executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * ��ʼ��
     *
     * @throws Exception
     */
    public void init() throws Exception {
        if (StringUtils.isBlank(name)) {
            name = this.getClass().getName();
        }

        /*
         * �ܶ���Thread name��ThreadFactory �ǳ���Ҫ��ʹ�ô������߳����Լ������ֶ�����Ĭ�ϵ�"pool-x-thread-y"��
         * ����threaddump�鿴�߳�ʱ�ر����á� ��ʽ��: "X-Thread-xxx-%d"
         */
        String threadNameFormat = "X-Thread-" + name + "-%d";
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat(threadNameFormat).build();
        this.executor = initializeExecutor(threadFactory, rejectedExecutionHandler);
    }

    /**
     * ��ʼ���̳߳�
     *
     * @param threadFactory
     * @param rejectedExecutionHandler
     * @return
     */
    protected ExecutorService initializeExecutor(ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        BlockingQueue<Runnable> queue = createQueue(this.queueCapacity);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(this.corePoolSize, this.maxPoolSize, this.keepAliveSeconds, TimeUnit.SECONDS, queue, threadFactory, rejectedExecutionHandler);
        return executor;
    }

    /**
     * ����һ���н����
     *
     * @param queueCapacity
     * @return
     */
    protected BlockingQueue<Runnable> createQueue(int queueCapacity) {
        if (queueCapacity > 0) {
            return new LinkedBlockingQueue<Runnable>(queueCapacity);
        } else {
            //һ��û�����ݻ���Ķ���,������Ҫget,����ȴ�������put,��֮��Ȼ
            return new SynchronousQueue<Runnable>();
        }
    }

    @Override
    public void execute(Runnable task) {
        ExecutorService executor = getExecutor();
        try {
            executor.execute(new WrapExceptionRunnable(task));
        } catch (RejectedExecutionException e) {
            throw new RejectedExecutionException("Executor [" + executor + "] did not accept task: " + task, e);
        }
    }

    @Override
    public Future<?> submit(Runnable task) {
        ExecutorService executor = getExecutor();
        try {
            return executor.submit(new WrapExceptionRunnable(task));
        } catch (RejectedExecutionException ex) {
            throw new RejectedExecutionException("Executor [" + executor + "] did not accept task: " + task, ex);
        }
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        ExecutorService executor = getExecutor();
        try {
            return executor.submit(new WrapExceptionCallable(task));
        } catch (RejectedExecutionException ex) {
            throw new RejectedExecutionException("Executor [" + executor + "] did not accept task: " + task, ex);
        }
    }

    /**
     * �����Ƿ�ȴ���������Źر�
     *
     * @param waitForTasksToCompleteOnShutdown
     */
    public void setWaitForTasksToCompleteOnShutdown(boolean waitForTasksToCompleteOnShutdown) {
        this.waitForTasksToCompleteOnShutdown = waitForTasksToCompleteOnShutdown;
    }

    /**
     * ���ùرճ�ʱ
     *
     * @param shutdownTimeout
     */
    public void setShutdownTimeout(int shutdownTimeout) {
        this.shutdownTimeout = shutdownTimeout;
    }
    //====================set and get====================

    /**
     * Ĭ���Ǿܾ�����
     *
     * @param rejectedExecutionHandler
     */
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        this.rejectedExecutionHandler = (rejectedExecutionHandler != null ? rejectedExecutionHandler : new ThreadPoolExecutor.AbortPolicy());
    }

    /**
     * ���ö�������
     *
     * @param queueCapacity
     */
    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    /**
     * ���ú����߳���
     *
     * @param corePoolSize
     */
    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    /**
     * ��������߳���
     *
     * @param maxPoolSize
     */
    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    /**
     * �����̱߳�����
     *
     * @param keepAliveSeconds
     */
    public void setKeepAliveSeconds(int keepAliveSeconds) {
        this.keepAliveSeconds = keepAliveSeconds;
    }

    /**
     * ��ȡִ����
     *
     * @return
     */
    public ExecutorService getExecutor() {
        if (this.executor != null) {
            throw new RuntimeException("executor not initialized");
        }
        return executor;
    }

    /**
     * ��֤������Exception�׳����̳߳ص�Runnable����ֹ�û�û�в�׽�쳣�����ж����̳߳��е��̡߳�
     */
    public static class WrapExceptionRunnable implements Runnable {
        private Runnable runnable;

        public WrapExceptionRunnable(Runnable runnable) {
            //�������Ϊnull ��¼������־��������һ�������������̳߳ؿ��Կ��ٽ���
            if (runnable == null) {
                System.out.println("[WrapExceptionRunnable-WrapExceptionRunnable]error, runnable cann't be null");
                this.runnable = new Runnable() {
                    @Override
                    public void run() {
                    }
                };
            } else {
                this.runnable = runnable;
            }
        }

        @Override
        public void run() {
            try {
                runnable.run();
            } catch (Throwable e) {
                // catch any exception, because the scheduled thread will break if the exception thrown outside.
                System.out.println("[WrapExceptionRunnable-run] Unexpected error occurred in task" + e.getMessage());
            }
        }
    }

    /**
     * ��֤������Exception�׳����̳߳ص�Runnable����ֹ�û�û�в�׽�쳣�����ж����̳߳��е��̡߳�
     */
    public static class WrapExceptionCallable<T> implements Callable<T> {
        private Callable<T> callable;

        public WrapExceptionCallable(Callable<T> callable) {
            //�������Ϊnull ��¼������־��������һ�������������̳߳ؿ��Կ��ٽ���
            if (callable == null) {
                System.out.println("[WrapExceptionCallable-WrapExceptionCallable]error, callable cann't be null");
                this.callable = new Callable<T>() {
                    @Override
                    public T call() throws Exception {
                        return null;
                    }
                };
            } else {
                this.callable = callable;
            }
        }

        @Override
        public T call() throws Exception {
            try {
                return callable.call();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("[WrapExceptionCallable-call] Unexpected error occurred in task" + e.getMessage());
                return null;
            }
        }
    }
}
