package com.xuan.xutils.concurrent.forkjoin.listtask.config;

/**
 * ִ��ʱ�����ò�����������һЩ�߼��û�����һЩ������Ӱ��������ķֽ��
 * <p>
 * Created by xuan on 17/8/26.
 */
public class ListTaskConfig {
    /**
     * Ĭ����1��ԭ���ݲ�ֳ�һ��������
     */
    private final static int DEFAULT_SUB_ORIGIN_LIST_SIZE = 1;
    /**
     * ��ʱĬ�ϣ�5��
     */
    private final static int DEFAULT_TIMEOUT_SECOND = 5;
    /**
     * �ڲ��������ʱ���Զ��ٸ�ԭ����Ϊ��λ��Ĭ�ϣ�1
     */
    private int subOriginListSize = DEFAULT_SUB_ORIGIN_LIST_SIZE;
    /**
     * ����ִ�г�ʱʱ�䣬��λ����
     */
    private long timeoutSecond = DEFAULT_TIMEOUT_SECOND;

    public int getSubOriginListSize() {
        return subOriginListSize;
    }

    public void setSubOriginListSize(int subOriginListSize) {
        this.subOriginListSize = subOriginListSize;
    }

    public long getTimeoutSecond() {
        return timeoutSecond;
    }

    public void setTimeoutSecond(long timeoutSecond) {
        this.timeoutSecond = timeoutSecond;
    }
}
