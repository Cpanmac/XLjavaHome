package com.xuan.xutils.concurrent.schedule;

/**
 * ����ĳ��ϵͳ����ĳ������
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����10:27:10 $
 */
public abstract class AbstractRunnableTask extends AbstractTask implements Runnable {
    public AbstractRunnableTask(String name) {
        super(name);
    }

    /**
     * ��������ִ�еķ���.
     *
     * @throws Exception ִ���쳣ʱ�׳�
     */
    public abstract void processTask() throws Exception;

    /**
     * �����߳�ִ�еķ���, ֱ�ӵ�����������.
     */
    @Override
    public void run() {
        if (!isWorking) {
            return;
        }
        try {
            beforeProcessTask();
            long current = System.currentTimeMillis();
            processTask();
            long elapsed = System.currentTimeMillis() - current;
            afterProcessTask();
            System.out.println("Task[" + getName() + "] finished, elapsed " + elapsed + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
