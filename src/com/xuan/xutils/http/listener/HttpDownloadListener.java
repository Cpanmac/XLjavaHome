package com.xuan.xutils.http.listener;

/**
 * ���ؼ���
 *
 * @author xuan
 */
public interface HttpDownloadListener {
    /**
     * ������ʱ�ص�
     *
     * @param count    �����ֽ�
     * @param current  ��ǰ�����ֽ�
     * @param isFinish �Ƿ������
     */
    void callBack(long count, long current, boolean isFinish);
}
