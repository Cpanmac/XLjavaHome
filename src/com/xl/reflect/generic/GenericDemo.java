package com.xl.reflect.generic;

import com.xl.entity.Person;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericDemo extends A<Person, String> {
    @Test
    public void getGeneric() throws InstantiationException, IllegalAccessException {
        // �õ����͵���ʵ��Ϣ
        Class<? extends GenericDemo> clazz = this.getClass(); // �õ���ǰnew�Ķ���
        System.out.println(clazz.getName());
        Type[] parent = clazz.getGenericInterfaces();
        System.out.println(parent[0]);
        Class<?> inter = clazz.getInterfaces()[0];
        System.out.println(inter.getName());
        // ParameterizedType pt = (ParameterizedType)
        // clazz.getGenericSuperclass(); // �õ����͵ĸ���
        // System.out.println(pt);
        // clazz = (Class) pt.getActualTypeArguments()[0];
        // System.out.println(clazz);
    }

    /**
     * ��Щ�޷�new�Ķ����ǻ���쳣��
     */
    @Test
    public void test() {
        new GenericDemo().run();
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
