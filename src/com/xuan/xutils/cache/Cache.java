package com.xuan.xutils.cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * ���ݻ���ӿڡ�
 *
 * @param <K> �����������
 * @param <V> ����ֵ������
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����10:37:29 $
 */
public interface Cache<K, V> {
    /**
     * ����ָ���Ļ��������ȡ����ֵ��
     *
     * @param key �����
     * @return ����ֵ
     */
    V get(K key);

    /**
     * ����������ӵ������С������ͬ key �Ļ����Ѿ����ڵĻ��������滻ԭ��,ֱ�ӷ���true.
     *
     * @param key   �����
     * @param value ����ֵ
     * @return �����ͬ key �Ļ����Ѿ����ڻ᷵�� <code>false</code>�����򷵻� <code>true</code>��
     */
    boolean add(K key, V value);

    /**
     * ����������ӵ������У������ù��ڵ�ʱ��㡣�����ͬ key �Ļ����Ѿ����ڵĻ��������滻ԭ��,ֱ�ӷ���true.
     *
     * @param key    �����
     * @param value  ����ֵ
     * @param expiry ������ڵ�ʱ���
     * @return �����ͬ key �Ļ����Ѿ����ڻ᷵�� <code>false</code>�����򷵻� <code>true</code>��
     */
    boolean add(K key, V value, Date expiry);

    /**
     * ����������ӵ������У������ó�ʱʱ�䡣�����ͬ key �Ļ����Ѿ����ڵĻ��������滻ԭ��,ֱ�ӷ���true.
     *
     * @param key    �����
     * @param value  ����ֵ
     * @param expiry ������ڵ�ʱ��
     * @param unit   ʱ�䵥λ
     * @return �����ͬ key �Ļ����Ѿ����ڻ᷵�� <code>false</code>�����򷵻� <code>true</code>��
     */
    boolean add(K key, V value, long expiry, TimeUnit unit);

    /**
     * �����ݷ��뻺�档�����ͬ key �Ļ����Ѿ����ڵĻ���ԭ���Ļ������ݽ����滻��
     *
     * @param key   �����
     * @param value ����ֵ
     */
    void put(K key, V value);

    /**
     * �����ݷ��뻺�棬�����ù��ڵ�ʱ��㡣�����ͬ key �Ļ����Ѿ����ڵĻ���ԭ���Ļ������ݽ����滻��
     *
     * @param key    �����
     * @param value  ����ֵ
     * @param expiry ������ڵ�ʱ���
     */
    void put(K key, V value, Date expiry);

    /**
     * �����ݷ��뻺�棬�����ó�ʱʱ�䡣�����ͬ key �Ļ����Ѿ����ڵĻ���ԭ���Ļ������ݽ����滻��
     *
     * @param key    �����
     * @param value  ����ֵ
     * @param expiry ������ڵ�ʱ��
     * @param unit   ʱ�䵥λ
     */
    void put(K key, V value, long expiry, TimeUnit unit);

    /**
     * ���ݻ������ɾ������ֵ��
     *
     * @param key �����
     */
    void remove(K key);

    /**
     * ��ĳ������������ <b>�Ӳ���</b> �ķ�����������Ĭ�ϳ�ʼ��ֵΪ 0��
     *
     * @param key   ��������Ӧ�� key
     * @param delta �����
     * @return �Ӳ���֮���������ֵ
     */
    long incr(K key, long delta);

    /**
     * ��ĳ������������ <b>�Ӳ���</b> �ķ�����������Ĭ�ϳ�ʼֵΪ <code>initValue</code>��
     *
     * @param key       ��������Ӧ�� key
     * @param delta     �����
     * @param initValue �������ĳ�ʼֵ
     * @return �Ӳ���֮���������ֵ
     */
    long incr(K key, long delta, long initValue);

    /**
     * ��ĳ������������ <b>������</b> �ķ����� ����������в����ڣ��򷵻� 0��
     *
     * @param key   ��������Ӧ�� key
     * @param delta �����
     * @return ������֮���������ֵ
     */
    long decr(K key, long delta);

    /**
     * ��ĳ������������ <b>������</b> �ķ�����������Ĭ�ϳ�ʼֵΪ <code>initValue</code>��
     *
     * @param key       ��������Ӧ�� key
     * @param delta     �����
     * @param initValue �������ĳ�ʼֵ
     * @return ������֮���������ֵ
     */
    long decr(K key, long delta, long initValue);

    /**
     * ������л��档
     */
    void flushAll();

    /**
     * �������л��档<br>
     * ���ô˷������ٻ���֮�󣬴˻��������޷�ʹ�ã������� <code>flushAll()</code> ������û�д����ơ�
     */
    void destroy();
}
