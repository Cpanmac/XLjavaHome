package com.xl.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: ����
 * Date: 2017/9/5
 * Time: 17:25
 * To change this template use File | Settings | File Templates.
 */
public class SpringDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        System.out.println("���Գɹ�");
        context.close();
    }
}
