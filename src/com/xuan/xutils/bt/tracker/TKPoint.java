package com.xuan.xutils.bt.tracker;

/**
 * ��־������
 * <p>
 * Created by xuan on 17/7/29.
 */
public class TKPoint {
    /**
     * ·��������
     */
    private String name;
    /**
     * ��ע˵��
     */
    private String remark;
    /**
     * �����ϴμ��ʱ��,��λ:����
     */
    private Long interval;
    /**
     * ��ǰʱ���
     */
    private Long timestamp;

    public TKPoint(String name) {
        this.name = name;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * ��ȡ��¼�ĵ�һ��
     *
     * @param name
     * @return
     */
    public static TKPoint buildStart(String name) {
        TKPoint tkPoint = new TKPoint(name);
        tkPoint.setInterval(0L);
        return tkPoint;
    }

    /**
     * �м�ĵ�
     *
     * @param pre
     * @param name
     * @return
     */
    public static TKPoint buildOn(TKPoint pre, String name) {
        TKPoint tkPoint = new TKPoint(name);
        if (null != pre && null != pre.getTimestamp()) {
            tkPoint.setInterval(tkPoint.getTimestamp().longValue() - pre.getTimestamp().longValue());
        }
        return tkPoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        this.interval = interval;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name=" + name);
        sb.append("remark=" + remark);
        sb.append("interval=" + interval);
        sb.append("timestamp=" + timestamp);
        return sb.toString();
    }
}
