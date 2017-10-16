package com.xuan.xutils.concurrent.schedule;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * һ���������ɴ����Զ���ǰ׺�߳������̹߳���<br />
 * ���磺 �߳���Ϊxuan-thread-5��xuanΪ�Զ���ǰ׺,5��ʾ�������ĵ�5���߳�
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����10:31:32 $
 */
public class NamedThreadFactory implements ThreadFactory {
    private static AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;

    /**
     * ���췽��
     *
     * @param namePrefix �Զ���ǰ׺
     */
    public NamedThreadFactory(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    /**
     * ��дThreadFactory�е�newThread
     */
    @Override
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, namePrefix + "-thread-" + threadNumber.getAndIncrement());
    }
}
