package com.xl;

import com.xl.collections.CaseInsensitiveMap;
import org.junit.Test;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: å¾ç«‹
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
        map.put("aAA", "²âÊÔ");
        map.put("aA1A", "²âÊÔ");
        map.put("aA1A", "²âÊÔ2");
        System.out.println(map);
    }
}
