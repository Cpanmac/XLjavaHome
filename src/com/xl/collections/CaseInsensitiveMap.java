package com.xl.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * ���Դ�Сд��Map<br>
 * ��KEY���Դ�Сд��get("Value")��get("value")��õ�ֵ��ͬ��put�����ֵҲ�ᱻ����
 *
 * @param <K> ������
 * @param <V> ֵ����
 * @author Looly
 * @since 3.0.2
 */
public class CaseInsensitiveMap<K, V> extends HashMap<K, V> {
    private static final long serialVersionUID = 4043263744224569870L;

    /**
     * ����
     */
    public CaseInsensitiveMap() {
        super();
    }

    /**
     * ����
     *
     * @param initialCapacity ��ʼ��С
     * @param loadFactor      ��������
     */
    public CaseInsensitiveMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    /**
     * ����
     *
     * @param initialCapacity ��ʼ��С
     */
    public CaseInsensitiveMap(int initialCapacity) {
        this(initialCapacity, 0.75f);
    }

    /**
     * ����
     *
     * @param m Map
     */
    public CaseInsensitiveMap(Map<? extends K, ? extends V> m) {
        super((int) (m.size() / 0.75));
        putAll(m);
    }

    /**
     * ��KeyתΪСд
     *
     * @param key KEY
     * @return СдKEy
     */
    private static Object lowerCaseKey(Object key) {
        if (key instanceof CharSequence) {
            key = key.toString().toLowerCase();
        }
        return key;
    }

    @Override
    public V get(Object key) {
        return super.get(lowerCaseKey(key));
    }

    @SuppressWarnings("unchecked")
    @Override
    public V put(K key, V value) {
        return super.put((K) lowerCaseKey(key), value);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public boolean containsKey(Object key) {
        return super.containsKey(lowerCaseKey(key));
    }
}
