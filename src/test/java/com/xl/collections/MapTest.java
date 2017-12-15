package com.xl.collections;

import com.xl.util.Print;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 徐立
 * Date: 2017-11-20
 * Time: 16:14
 * To change this template use File | Settings | File Templates.
 */
public class MapTest {
    HashMap<String, String> map = new HashMap<String, String>(0);
    Map<Integer, String> sortMap = new HashMap<Integer, String>();

    @Before
    public void before() {
        map.put("02", "zhangsan2");
        map.put("03", "zhangsan3");
        map.put("01", "zhangsan1");
        map.put("04", "zhangsan4");
        sortMap.put(3, "测试3");
        sortMap.put(1, "测试1");
        sortMap.put(2, "测试2");
    }

    @Test
    public void mapTest() {
        // 获取map集合的所有键的Set集合,keySet();
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        // 有了Set集合。就可以获取其迭代器 迭代器和Set里面一致
        Iterator<Map.Entry<String, String>> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> me = it.next();
            String key = me.getKey();
            String value = me.getValue();
            Print.info("key:" + key + ",value:" + value);
        }
    }

    @Test
    public void emptyTest() {
        Map map = new HashMap(2);
        //空
        Print.info(map.get("1") == null);
        //KEY可以为空
        Print.info(map.get(null));
    }

    @Test
    public void sortTest() {
        Print.info(sortMap);
    }
}
