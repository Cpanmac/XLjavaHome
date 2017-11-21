package com.xl.collections;

import com.xl.util.ListUtil;
import com.xl.util.Print;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 徐立
 * Date: 2017-11-20
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
public class ListTest {
    List<String> list = new ArrayList<String>();

    @Before
    public void init() {
        list.add("张三");
        list.add("张三");
        list.add("李四");
    }

    /**
     * 去重
     */
    @Test
    public void distinctTest() {
        Print.info(ListUtil.distinct(list));
    }

    /**
     * 转化为数组
     */
    @Test
    public void arrayTest() {
        Print.info(Arrays.toString(list.toArray()));
    }
}
