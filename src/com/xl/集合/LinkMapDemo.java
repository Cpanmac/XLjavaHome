package com.xl.

����;
        import org.apache.commons.collections.map.LinkedMap;
        import org.junit.Test;
        import java.util.LinkedHashMap;
        import java.util.Map;

/**
 * Created by �� on 5/19 0019.
 */
public class LinkMapDemo {
    @Test
    public void test() {
        Map map = new LinkedHashMap();
        map.put("a", 1);
        map.put("a", 2);
        System.out.println(map);
    }
}
