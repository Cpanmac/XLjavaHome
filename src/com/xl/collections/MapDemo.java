package com.xl.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("02", "zhangsan2");
        map.put("03", "zhangsan3");
        map.put("01", "zhangsan1");
        map.put("04", "zhangsan4");
        // ��ȡmap���ϵ����м���Set����,keySet();
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        // ����Set���ϡ��Ϳ��Ի�ȡ�������
        Iterator<Map.Entry<String, String>> it = entrySet.iterator(); // ��������Set����һ��
        while (it.hasNext()) {
            Map.Entry<String, String> me = it.next(); // ��ҲҪд
            String key = me.getKey();
            String value = me.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }
    }
}
