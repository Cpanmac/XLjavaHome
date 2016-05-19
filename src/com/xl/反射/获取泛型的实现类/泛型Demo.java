package com.xl.反射.获取泛型的实现类;

import com.xl.entity.Person;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;

public class 泛型Demo extends A<Person, String> {
    /**
     * 有些无法new的对象是会出异常的
     */
    @Test
    public void test() {
        new 泛型Demo().run();
    }
}

class A<T, E> {
    T entity;
    E domain;

    @SuppressWarnings("unchecked")
    public A() {
        java.lang.reflect.Type t = this.getClass().getGenericSuperclass();
        boolean b = ParameterizedType.class.isInstance(t);
        System.out.println("是否是这个类型的" + b);
        ParameterizedType pt = (ParameterizedType) t;
        pt.getRawType();
        pt.getOwnerType();
        java.lang.reflect.Type[] clazzs = pt.getActualTypeArguments();
        try {
            entity = (T) ((Class<?>) clazzs[0]).newInstance();
            domain = (E) ((Class<?>) clazzs[1]).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    void run() {
        System.out.println(entity.getClass().getName());
        System.out.println(domain.getClass().getName());
    }
}
