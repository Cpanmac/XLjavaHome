package com.xuan.xutils.concurrent.schedule;

import java.util.concurrent.Callable;

/**
 * ����ĳ��ϵͳ����ĳ������.�� <code>AbstractRunnableTask</code> �������Ǵ��������ִ�еĽ��
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����10:29:22 $
 */
public abstract class AbstractCallableTask<V> extends AbstractTask implements Callable<V> {
    public AbstractCallableTask(String name) {
        super(name);
    }

    /**
     * ��������ִ�еķ���.
     *
     * @return ����ִ�н��
     * @throws Exception ִ���쳣ʱ�׳�
     */
    public abstract V processTask() throws Exception;

    /**
     * �����߳�ִ�еķ���, ֱ�ӵ�����������.
     */
    @Override
    public V call() {
        if (!isWorking) {
            return null;
        }
        V result = null;
        try {
            beforeProcessTask();
            long current = System.currentTimeMillis();
            result = processTask();
            long elapsed = System.currentTimeMillis() - current;
            afterProcessTask();
            System.out.println("Task[" + getName() + "] finished, elapsed " + elapsed + " ms");
        } catch (Exception e) {
            e.printStackTrace();
            ;
        }
        return result;
    }

    /**
     * ����ִ��ǰ����,��������Լ�Ҫ��ɸ�д
     */
    protected void beforeProcessTask() {
    }

    /**
     * ����ִ�к����,��������Լ�Ҫ��ɸ�д
     */
    protected void afterProcessTask() {
    }
}
