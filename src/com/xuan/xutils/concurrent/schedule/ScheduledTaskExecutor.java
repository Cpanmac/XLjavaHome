package com.xuan.xutils.concurrent.schedule;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * ��ʱ����ִ������һЩ�ȽϺ�ʱ���������ͨ���ύ���������첽ִ�С�
 * <p>
 * <p>
 * ���ڲ�ʵ����ʹ����һ���̶����ȵ��̳߳غ�һ���޽�����������ִ���ύ������
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����10:32:42 $
 */
public class ScheduledTaskExecutor extends ScheduledThreadPoolExecutor {
    /**
     * ����ִ�е������б�
     */
    private final List<AbstractTask> activeTasks = new CopyOnWriteArrayList<AbstractTask>();
    /**
     * �����ύ�������б�
     */
    private final List<AbstractTask> allTasks = new CopyOnWriteArrayList<AbstractTask>();

    /**
     * ʹ�ø����ĺ��ĳش�С����һ���µ� ScheduledTaskExecutor��
     *
     * @param corePoolSize �̳߳������������߳��������������̣߳�
     * @throws IllegalArgumentException ��� <tt>corePoolSize &lt; 0</tt>
     */
    public ScheduledTaskExecutor(int corePoolSize) {
        super(corePoolSize);
    }

    /**
     * ʹ�ø����ĺ��ĳش�С����һ���µ� ScheduledTaskExecutor��
     *
     * @param corePoolSize  �̳߳������������߳��������������̣߳�
     * @param threadFactory ִ�г��򴴽����߳�ʱʹ�õĹ���
     * @throws IllegalArgumentException ��� <tt>corePoolSize &lt; 0</tt>
     * @throws NullPointerException     ��� threadFactory Ϊnull
     */
    public ScheduledTaskExecutor(int corePoolSize, ThreadFactory threadFactory) {
        super(corePoolSize, threadFactory);
    }

    /**
     * ʹ�ø����ĺ��ĳش�С����һ���µ� ScheduledTaskExecutor��
     *
     * @param corePoolSize �̳߳������������߳��������������̣߳�
     * @param handler      ���ڳ����̷߳�Χ�Ͷ���������ʹִ�б�����ʱ��ʹ�õĴ������
     * @throws IllegalArgumentException ��� <tt>corePoolSize &lt; 0</tt>
     * @throws NullPointerException     ��� handler Ϊnull
     */
    public ScheduledTaskExecutor(int corePoolSize, RejectedExecutionHandler handler) {
        super(corePoolSize, handler);
    }

    /**
     * ʹ�ø����ĺ��ĳش�С����һ���µ� ScheduledTaskExecutor��
     *
     * @param corePoolSize  �̳߳������������߳��������������̣߳�
     * @param threadFactory ִ�г��򴴽����߳�ʱʹ�õĹ���
     * @param handler       ���ڳ����̷߳�Χ�Ͷ���������ʹִ�б�����ʱ��ʹ�õĴ������
     * @throws IllegalArgumentException ��� <tt>corePoolSize &lt; 0</tt>
     * @throws NullPointerException     ��� threadFactory ���� handler Ϊnull
     */
    public ScheduledTaskExecutor(int corePoolSize, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, threadFactory, handler);
    }

    /**
     * ʹ����Ҫ������ӳ�ִ���������Ч���ϵ�ͬ�ڵ��� schedule(task, 0, anyUnit)��
     *
     * @param task Ҫִ�е�����
     */
    public void execute(AbstractRunnableTask task) {
        super.execute(task);
        addTask(task);
    }

    /**
     * �ύһ����ִ�н��������.
     *
     * @param <T>  ����������
     * @param task Ҫִ�е�����
     * @return �����ִ�н��
     */
    public <T> Future<T> submit(AbstractCallableTask<T> task) {
        Future<T> future = null;
        try {
            future = super.submit(task);
            addTask(task);
        } catch (RuntimeException e) {
            throw e;
        }
        return future;
    }

    /**
     * ������ִ���ڸ����ӳ�ʱ������õ�һ��������
     *
     * @param task  Ҫִ�е�����
     * @param delay �����ڿ�ʼ�ӳ�ִ�е�ʱ��
     * @param unit  �ӳٲ�����ʱ�䵥λ
     * @return ��ʾ����������ɵ� ScheduledFuture�������� get() ��������ɺ󽫷��� null��
     */
    public ScheduledFuture<?> schedule(AbstractRunnableTask task, long delay, TimeUnit unit) {
        ScheduledFuture<?> future = null;
        try {
            future = super.schedule(task, delay, unit);
            addTask(task);
        } catch (RuntimeException e) {
            throw e;
        }
        return future;
    }

    /**
     * ������ִ��һ���ڸ�����ʼ�ӳٺ��״����õĶ��ڲ����������������и��������ڣ�<br>
     * Ҳ���ǽ��� initialDelay ��ʼִ�У�Ȼ���� initialDelay + period ��ִ�У������� initialDelay + 2 * period ��ִ�У��������ơ�<br>
     * ����������һִ�������쳣������ȡ������ִ�С�����ֻ��ͨ��ִ�г����ȡ������ֹ��������ֹ������
     *
     * @param task         Ҫִ�е�����
     * @param initialDelay �״�ִ�е��ӳ�ʱ��
     * @param period       ����ִ��֮�������
     * @param unit         initialDelay �� period ������ʱ�䵥λ
     * @return ��ʾ����������ɵ� Future�������� get() ������ȡ�����׳��쳣��
     * @throws RejectedExecutionException ����޷�����ִ�и�����
     * @throws NullPointerException       ��� command Ϊ null
     * @throws IllegalArgumentException   ��� period С�ڻ���� 0
     */
    public ScheduledFuture<?> scheduleAtFixedRate(AbstractRunnableTask task, long initialDelay, long period, TimeUnit unit) {
        ScheduledFuture<?> future = null;
        try {
            future = super.scheduleAtFixedRate(task, initialDelay, period, unit);
            addTask(task);
        } catch (RuntimeException e) {
            throw e;
        }
        return future;
    }

    /**
     * ������ִ��һ���ڸ�����ʼ�ӳٺ��״����õĶ��ڲ����������ÿһ��ִ����ֹ����һ��ִ�п�ʼ֮�䶼���ڸ������ӳ١�<br>
     * ����������һִ�������쳣���ͻ�ȡ������ִ�С�����ֻ��ͨ��ִ�г����ȡ������ֹ��������ֹ������
     *
     * @param task         Ҫִ�е�����
     * @param initialDelay �״�ִ�е��ӳ�ʱ��
     * @param delay        һ��ִ����ֹ����һ��ִ�п�ʼ֮����ӳ�
     * @param unit         initialDelay �� delay ������ʱ�䵥λ
     * @return ��ʾ����������ɵ� Future�������� get() ������ȡ�����׳��쳣��
     * @throws RejectedExecutionException ����޷�����ִ�и�����
     * @throws NullPointerException       ��� command Ϊ null
     * @throws IllegalArgumentException   ��� delay С�ڻ���� 0
     */
    public ScheduledFuture<?> scheduleWithFixedDelay(AbstractRunnableTask task, long initialDelay, long delay, TimeUnit unit) {
        ScheduledFuture<?> future = null;
        try {
            future = super.scheduleWithFixedDelay(task, initialDelay, delay, unit);
            addTask(task);
        } catch (RuntimeException e) {
            throw e;
        }
        return future;
    }

    /**
     * ��ȡ�������ύ������.
     *
     * @return �������ύ�������б�
     */
    public List<AbstractTask> getAllTasks() {
        return Collections.unmodifiableList(allTasks);
    }

    /**
     * ��ȡ����ִ�е�����.
     *
     * @return ����ִ�е������б�
     */
    public List<AbstractTask> getActiveTasks() {
        return Collections.unmodifiableList(activeTasks);
    }

    /**
     * ����ǰ���ύ�����ִ���з���һ������Ĺرգ����ǲ�����������<br>
     * ����ѽ� ExecuteExistingDelayedTasksAfterShutdownPolicy ����Ϊ false����ȡ����δ�������ӳٵ������ӳ�����<br>
     * ���ҳ����ѽ� ContinueExistingPeriodicTasksAfterShutdownPolicy ����Ϊ true������ȡ�����ж�������ĺ���ִ�С�
     */
    @Override
    public void shutdown() {
        clearTasks();
        super.shutdown();
    }

    /**
     * ����ֹͣ��������ִ�е�������ͣ�ȴ�����Ĵ��������صȴ�ִ�е������б�<br>
     * ��Ȼ�����Ŭ������������֤����ֹͣ��������ִ�е�����<br>
     * ��ʵ��ͨ�� Thread.interrupt() ȡ�����������κ��޷���Ӧ�жϵ����񶼿�����Զ�޷���ֹ��
     */
    @Override
    public List<Runnable> shutdownNow() {
        clearTasks();
        return super.shutdownNow();
    }

    @Override
    protected void terminated() {
        super.terminated();
    }

    /**
     * �޸Ļ��滻����ִ�� runnable �����񡣴˷�������д���ڹ����ڲ�����ľ����ࡣĬ��ʵ��ֻ���ظ�������<br>
     * <b>ע�⣺���ڶ��ڷ���ִ�е�����JDK6.0��һ��������ִ��һ��֮�󷵻صĸ�������Ͳ��ᾭ���˷�����װ��bug��</b>
     *
     * @param r    ���ύ�� Runnable
     * @param task ִ�� runnable ������������
     * @return ����ִ�� runnable ������
     */
    @Override
    protected <V> RunnableScheduledFuture<V> decorateTask(Runnable r, RunnableScheduledFuture<V> task) {
        return new NamedScheduledFuture<V>((AbstractRunnableTask) r, task);
    }

    /**
     * �޸Ļ��滻����ִ�� callable �����񡣴˷�������д���ڹ����ڲ�����ľ����ࡣĬ��ʵ��ֻ���ظ�������<br>
     * <b>ע�⣺���ڶ��ڷ���ִ�е�����JDK6.0��һ��������ִ��һ��֮�󷵻صĸ�������Ͳ��ᾭ���˷�����װ��bug��</b>
     *
     * @param c    ���ύ�� Callable
     * @param task ִ�� callable ������������
     * @return ����ִ�� callable ������
     */
    @Override
    protected <V> RunnableScheduledFuture<V> decorateTask(Callable<V> c, RunnableScheduledFuture<V> task) {
        return new NamedScheduledFuture<V>((AbstractCallableTask<V>) c, task);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        if (!(r instanceof NamedScheduledFuture<?>)) {
            return;
        }
        AbstractTask task = ((NamedScheduledFuture<?>) r).getTask();
        activeTasks.add(task);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        try {
            if (r instanceof NamedScheduledFuture<?>) {
                AbstractTask task = ((NamedScheduledFuture<?>) r).getTask();
                activeTasks.remove(task);
                allTasks.remove(task);
            }
        } finally {
            super.afterExecute(r, t);
        }
    }

    /**
     * ���һ���������������б�
     *
     * @param task
     */
    private void addTask(AbstractTask task) {
        allTasks.add(task);
    }

    /**
     * �����������ͻ�Ծ�����б�
     */
    private void clearTasks() {
        activeTasks.clear();
        allTasks.clear();
    }
}
