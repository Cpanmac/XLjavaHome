package com.xl.reflect;

import com.xl.entity.Person;
import com.xl.util.Print;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/*
 * 我出现的问题：在Person中构造方法是默认的时候,getConstructor没有获得其构造方法
 */
public class GetClassConstructed {
    private String s;

    @Before
    public void before() {
        // 加载的类
        s = "reflect.Person";
    }

    // 反射构造函数(空参数）：public Person()
    @Test
    public void createNewObject() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String name = "reflect.Person";
        Class clazz = Class.forName(name);
        // 该类中只有一个获取空参数的方法newInstance
        Object obj = clazz.newInstance(); // 调用了空参数的构造函数，
        Person p = (Person) obj;
        Print.info(p.name);
        // 异常：
        // 1.如果没有空参的构造函数会报一个java.lang.InstantiationException初始化异常
        // 2.如果构造函数被private修饰java.lang.IllegalAccessException无效访问异常
    }

    // 如果该类没有空参的构造函数,拿到所有公用的构造函数
    @Test
    public void createNewObject_2() throws Exception {
        Class<?> clazz = Class.forName("reflect.Person");
        // 1.拿到该类的所有公有的构造函数getConstructors()
        Constructor c = clazz.getConstructor(String.class);
        Person p = (Person) c.newInstance("xxx");
        Print.info(p.name);
    }

    // 私有的构造函数
    @Test
    public void test() throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> clazz = Class.forName(s);
        Constructor c = clazz.getDeclaredConstructor(List.class);
        c.setAccessible(true);
        Person p = (Person) c.newInstance(new ArrayList());
        Print.info(p.name);
    }
}
