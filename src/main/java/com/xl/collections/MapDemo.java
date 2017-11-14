package com.xl.collections;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Log4j
public class MapDemo {
    @Test
    public void mapTest() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("02", "zhangsan2");
        map.put("03", "zhangsan3");
        map.put("01", "zhangsan1");
        map.put("04", "zhangsan4");
        // 获取map集合的所有键的Set集合,keySet();
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        // 有了Set集合。就可以获取其迭代器
        Iterator<Map.Entry<String, String>> it = entrySet.iterator(); // 迭代器和Set里面一致
        while (it.hasNext()) {
            Map.Entry<String, String> me = it.next(); // 这也要写
            String key = me.getKey();
            String value = me.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }
    }

    @Test
    public void emptyTest() {
        Map map = new HashMap();
        log.info(map.get("1") == null); //空
    }
}
