package com.xl.base;

import com.xl.entity.Person;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitDemo {
    // ʹ��Junit���Լ�@Test�Ϳ��� Ҫֱ�Ӳ������еķ����͵��������Ȼ��run as
    private Person p;

    // ���Ҫ��Before�����ȼ��أ�����ص�ʱ������
    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    @AfterClass
    public static void aflterClass() {
        System.out.println("AfterClass");
    }

    // Before���ڲ���֮ǰ�ض����У����Կ��԰ѳ�ʼ��Person����Before
    // �ص㣺ÿ�����Է���������
    @Before
    public void before() {
        System.out.println("before");
        p = new Person();
    }

    @Test
    public void testRun() {
        // Person p = new Person();
        // ����.����ܶ෽��
        // һ������ֵ��һ������ֵ
        // Assert.assertEquals("2",p.run());
        // �������ص�������1��1. ʵ�ʵķ��ص�������1��2
        Assert.assertArrayEquals(new int[]{1, 1}, new int[]{1, 2});
    }

    // After���������ر���Դ
    @After
    public void after() {
        // System.out.println("after");
        p = null;
    }
}
