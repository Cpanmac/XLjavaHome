package com.xuan.xutils.http;

/**
 * HTT����ͨ�ýӿ�
 *
 * @author xuan
 */
public interface HttpClient {
    /**
     * POST����Json�ŵ�����������
     *
     * @param bpRequest
     * @return
     */
    HttpResponse postJson(HttpRequest bpRequest);

    /**
     * POST������ͨ�����ķ�ʽ�ύ
     *
     * @param bpRequest
     * @return
     */
    HttpResponse post(HttpRequest bpRequest);

    /**
     * GET����
     *
     * @param bpRequest
     * @return
     */
    HttpResponse get(HttpRequest bpRequest);

    /**
     * ���أ��õ���GET����
     *
     * @param bpRequest
     * @return
     */
    HttpResponse getDowload(HttpRequest bpRequest);

    /**
     * ���أ��õ���POST����
     *
     * @param bpRequest
     * @return
     */
    HttpResponse postDowload(HttpRequest bpRequest);

    /**
     * ģ����ϴ��ļ�
     *
     * @param bpRequest
     * @return
     */
    HttpResponse upload(HttpRequest bpRequest);
}
