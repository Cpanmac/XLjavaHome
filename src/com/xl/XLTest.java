package com.xl;

import com.xl.collections.CaseInsensitiveMap;
import org.junit.Test;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: –Ï¡¢
 * Date: 2017/9/28
 * Time: 17:53
 * To change this template use File | Settings | File Templates.
 */
public class XLTest {
    @Test
    public void mapTest() {
        Map map = new CaseInsensitiveMap();
        map.put("aaa", 11);
        map.put("aAA", 22);
        map.put("aAA", "≤‚ ‘");
        map.put("aA1A", "≤‚ ‘");
        map.put("aA1A", "≤‚ ‘2");
        System.out.println(map);
    }
}
