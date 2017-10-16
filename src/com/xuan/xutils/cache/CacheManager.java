package com.xuan.xutils.cache;

import java.util.Set;

/**
 * ����Ի�����й���Ľӿ�
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����10:40:02 $
 */
public interface CacheManager<T extends Cache<?, ?>> {
    /**
     * ���ݻ���������ȡ���档
     *
     * @param cacheName ������
     * @return ���غͻ���������ƥ��Ļ��棬���û��ƥ�����򷵻� <code>null</code>��
     */
    T getCache(String cacheName);

    /**
     * ����µĻ��档
     *
     * @param cacheName ��Ҫ��ӵĻ�����
     * @param cache     ��Ҫ��ӵĻ���
     */
    void addCache(String cacheName, T cache);

    /**
     * ɾ���Ѿ���ӵĻ��档
     *
     * @param cacheName ��Ҫɾ���Ļ�����
     */
    void removeCache(String cacheName);

    /**
     * �������л������ļ��ϡ�
     *
     * @return �������ļ���
     */
    Set<String> getCacheNames();

    /**
     * ˢ��ĳ�����档
     *
     * @param cacheName ��Ҫˢ�µĻ�����
     */
    void flush(String cacheName);

    /**
     * ˢ�����л��档
     */
    void flushAll();

    /**
     * �رջ���������������еĻ���������ٴ���
     */
    void shutdown();

    /**
     * �жϻ���������Ƿ��Ѿ��رա�
     *
     * @return �������������Ѿ��ر��򷵻� <code>true</code>�����򷵻� <code>false</code>��
     */
    boolean isShutdown();
}
