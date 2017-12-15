package com.xl.a;

import com.xl.util.Print;
import com.xl.util.StringUtil;
import org.junit.After;
import org.junit.Before;
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
public class StringTest {
    StringBuffer sql = new StringBuffer();

    @Before
    public void before() {
        sql.append("12e13,3232,aa");
    }

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
        Print.info(s);
    }

    @Test
    public void spiltTest() {
        String s = "测试";
        Print.info(Arrays.toString(s.split(",")));
    }

    @Test
    public void bufferAndBuilderTest() {
        StringBuilder sb = new StringBuilder();
        StringBuffer sb2 = new StringBuffer();
    }

    @Test
    public void deleteTest() {
        Print.info(sql);
        sql.delete(sql.length() - 2, sql.length());
        Print.info(sql);
    }

    @Test
    public void insertTest() {
        sql.insert(0, "测试插入");
    }

    @After
    public void after() {
        Print.info(sql);
    }
}
