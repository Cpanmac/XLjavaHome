package com.xl.a;

import com.xl.util.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 徐立
 * Date: 2017/8/28
 * Time: 9:59
 * To change this template use File | Settings | File Templates.
 */
public class StringDemo {
    /**
     * 转换为join字符串
     */
    @Test
    public void joinTest() {
        List<String> result = new ArrayList<String>();
        result.add("aaa");
        result.add("bbb");
        result.add("ccc");
        result.add("ddd");
        String s = StringUtil.join(result, ",");
        System.out.println(s);
    }

    @Test
    public void spiltTest() {
        String s = "测试";
        System.out.println(Arrays.toString(s.split(",")));
    }
}
