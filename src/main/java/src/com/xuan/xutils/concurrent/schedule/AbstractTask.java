package com.xuan.xutils.concurrent.schedule;

import java.util.Date;

/**
 * ����ĳ��ϵͳ����ĳ������.
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����10:26:19 $
 */
public abstract class AbstractTask {
    /**
     * ��������
     */
    private final String name;
    /**
     * ִ��ʱ���
     */
    private final Date timestamp;
    /**
     * �Ƿ�����ִ��
     */
    protected volatile boolean isWorking = true;

    public AbstractTask(String name) {
        this.name = name;
        this.timestamp = new Date();
    }

    public String getName() {
        return name;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean isWorking) {
        this.isWorking = isWorking;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append("[");
        sb.append("name=").append(name).append(",");
        sb.append("isWorking=").append(isWorking).append(",");
        sb.append("timestamp=").append(timestamp).append("]");
        return sb.toString();
    }
}
