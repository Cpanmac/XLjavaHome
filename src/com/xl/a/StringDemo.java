package com.xl.a;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ÐìÁ¢
 * Date: 2017/8/28
 * Time: 9:59
 * To change this template use File | Settings | File Templates.
 */
public class StringDemo {
    /**
     * ×ª»»Îªjoin×Ö·û´®
     */
    @Test
    public void joinTest() {
        List<String> result = new ArrayList<String>();
        result.add("aaa");
        result.add("bbb");
        result.add("ccc");
        result.add("ddd");
        String s = org.apache.commons.lang.StringUtils.join(result.iterator(), "¡¢");
        System.out.println(s);
    }

    @Test
    public void spiltTest() {
        String s = "²âÊÔ";
        System.out.println(Arrays.toString(s.split(",")));
    }
}
