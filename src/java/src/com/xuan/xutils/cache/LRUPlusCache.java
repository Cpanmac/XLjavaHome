package com.xuan.xutils.cache;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * ����ʵ�֣�����LRU�㷨���ܹ�ȡ�ñ���������Ķ���<br />
 * LRU��Least Recently Used����д�����������ʹ��ҳ���û��㷨
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����10:42:57 $
 */
public class LRUPlusCache implements Serializable {
    private static final long serialVersionUID = -4174256121921240092L;
    private final int capacity;
    private final LinkedList<String> list = new LinkedList<String>();
    private final HashMap<String, Object> map = new HashMap<String, Object>();

    /**
     * ���췽��
     *
     * @param capacity ���������
     */
    public LRUPlusCache(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LRUPlusCache cache = new LRUPlusCache(5);
        for (int i = 0; i < 6; i++) {
            System.out.println(cache.putInCache(i + "", i + "$"));
            System.out.println(cache);
        }
        System.out.println(cache.putInCache("1", "1$"));
        System.out.println(cache);
        System.out.println(cache.getFromCache("1"));
        System.out.println(cache);
        System.out.println(cache.getFromCache("4"));
        System.out.println(cache);
    }

    /**
     * �ŵ������У�����ڻ����еĵ�һ��λ��
     *
     * @param key   ��
     * @param value ֵ
     * @return �������Ķ������Ϊnull��˵��û�ж��󱻼���
     */
    public synchronized Object putInCache(String key, Object value) {
        Object oldValue = map.put(key, value);
        if (oldValue != null) {
            return null;
        }
        list.addFirst(key);
        if (list.size() <= capacity) {
            return null;
        }
        String removedKey = list.removeLast();
        return map.remove(removedKey);
    }

    /**
     * �ӻ����ж�ȡ������ȡ�Ķ����ŵ������еĵ�һ��λ��
     *
     * @param key
     * @return ����
     */
    public synchronized Object getFromCache(String key) {
        Object value = map.get(key);
        if (value != null) {
            list.remove(key);
            list.addFirst(key);
        }
        return value;
    }

    /**
     * ɾ�����������ж���
     *
     * @return ��ɾ�������ж���Map
     */
    public synchronized Map<String, Object> removeAll() {
        HashMap<String, Object> removedMap = new HashMap<String, Object>(map);
        list.clear();
        map.clear();
        return removedMap;
    }

    @Override
    public String toString() {
        StringBuilder StringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String key = list.get(i);
            if (i > 0) {
                StringBuilder.append(",");
            }
            StringBuilder.append(key);
            StringBuilder.append("[");
            StringBuilder.append(map.get(key));
            StringBuilder.append("]");
        }
        return StringBuilder.toString();
    }
}
