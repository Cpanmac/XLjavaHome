package com.xl.集合;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemo {
    List<String> list = new ArrayList<String>();

    /**
     * 将集合转换为数组
     */
    @org.junit.Test
    public void test() {
        list.add("张三");
        list.add("李四");
        System.out.println(Arrays.toString(list.toArray()));
        String[] str = new String[list.size()];
        list.toArray(str);
        for (String s : str) {
            System.out.println(s);
        }
    }
}
