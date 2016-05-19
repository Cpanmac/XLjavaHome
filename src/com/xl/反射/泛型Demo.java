package com.xl.反射;

import org.junit.Test;

import java.lang.reflect.Type;

interface parent {
    void say();
}

public class 泛型Demo implements parent {
    @Test
    public void 得到泛型() throws InstantiationException, IllegalAccessException {
        // 得到泛型的真实信息
        Class<? extends 泛型Demo> clazz = this.getClass(); // 得到当前new的对象
        System.out.println(clazz.getName());
        Type[] parent = clazz.getGenericInterfaces();
        System.out.println(parent[0]);
        Class<?> inter = clazz.getInterfaces()[0];
        System.out.println(inter.getName());
        // ParameterizedType pt = (ParameterizedType)
        // clazz.getGenericSuperclass(); // 得到泛型的父类
        // System.out.println(pt);
        // clazz = (Class) pt.getActualTypeArguments()[0];
        // System.out.println(clazz);
    }

    @Override
    public void say() {
        // TODO Auto-generated method stub
    }
}