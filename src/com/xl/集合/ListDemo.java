package com.xl.����;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemo {
    List<String> list = new ArrayList<String>();

    /**
     * ������ת��Ϊ����
     */
    @org.junit.Test
    public void test() {
        list.add("����");
        list.add("����");
        System.out.println(Arrays.toString(list.toArray()));
        String[] str = new String[list.size()];
        list.toArray(str);
        for (String s : str) {
            System.out.println(s);
        }
    }
}
