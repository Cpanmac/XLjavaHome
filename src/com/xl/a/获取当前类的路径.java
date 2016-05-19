package com.xl.a;

import org.junit.Test;

public class 获取当前类的路径 {
    @Test
    public void Test1() {
        try {
            Class clazz = Class.forName("comm.Person");
            String path = clazz.getClass().getResource("/").getPath();
            System.out.println(path);
            path = clazz.getResource("/").getPath();
            System.out.println(path);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
