package com.xuan.xutils.cache;

import java.io.Serializable;

/**
 * ���ڰ�װ������������
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����10:38:42 $
 */
public class CacheObject implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * ����ʱ��ʱ���,��λ:����
     */
    private volatile long creationTime;
    /**
     * �����ȡʱ��,��λ:����
     */
    private volatile long expiryTime;
    /**
     * �������
     */
    private Object value;

    public CacheObject() {
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public long getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(long expiryTime) {
        this.expiryTime = expiryTime;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * �жϻ����Ƿ����
     *
     * @return
     */
    public boolean isExpired() {
        long time = creationTime + expiryTime;
        long now = System.currentTimeMillis();
        return time > 0 && time <= now;
    }
}
