package com.xl.a;

import org.junit.Test;

public class ��ȡ��ǰ���·�� {
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
