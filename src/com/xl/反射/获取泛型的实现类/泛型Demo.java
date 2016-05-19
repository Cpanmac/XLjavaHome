package com.xl.����.��ȡ���͵�ʵ����;

import com.xl.entity.Person;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;

public class ����Demo extends A<Person, String> {
    /**
     * ��Щ�޷�new�Ķ����ǻ���쳣��
     */
    @Test
    public void test() {
        new ����Demo().run();
    }
}

class A<T, E> {
    T entity;
    E domain;

    @SuppressWarnings("unchecked")
    public A() {
        java.lang.reflect.Type t = this.getClass().getGenericSuperclass();
        boolean b = ParameterizedType.class.isInstance(t);
        System.out.println("�Ƿ���������͵�" + b);
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
