package com.xl.reflect;

import com.xl.entity.Person;
import com.xl.util.Print;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetMethod {
    Person p = new Person();
    private String className = null;

    @Before
    public void before() {
        className = "reflect.Person";
    }

    /*
     * 获取指定Class中的公有方法。
     */
    @Test
    public void getMethodDemo() throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Class<?> clazz = Class.forName(className);
        Method[] methods = clazz.getMethods(); // 获取的都是公有的
        // 第一个参数是方法的名字，后面的参数是方法的参数类型
        // Method method = clazz.getMethod("aa1", String.class, int.class);
        // 运行这个方法
        // method.invoke(p, "sa", 36);
        for (Method amethods : methods) {
            // 打印公用的方法全名
            Print.println(amethods.getName());
        }
        // 只获取私有的方法
        methods = clazz.getDeclaredMethods();
        for (Method bmethods : methods) {
            Print.println(bmethods);
        }
    }

    // 无参的方法
    @Test
    public void getMethodDemo_2() throws Exception {
        Class<?> clazz = Class.forName("reflect.Person");
        Method method = clazz.getMethod("show", null); // 获取空参数的一般方法。
        // Object obj=clazz.newInstance(); //建立Person对象
        // method.invoke(obj,null); //直接运行了show方法，如果是私有的运行不了
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object obj = constructor.newInstance("小明", 30);
    }

    // 静态方法
    @Test
    public void getMethodDemo_3() throws Exception {
        Class<?> clazz = Class.forName(className);
        Method method = clazz.getMethod("aa1", int.class);// 方法名+参数列表
        // 因为是静态的所以不需要对象
        method.invoke(null, 23); // 运行
    }

    // main方法,抛出一个错误参数异常
    @Test
    public void test1() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException, ClassNotFoundException {
        Class<?> clazz = Class.forName(className);
        Method method = clazz.getMethod("callstored", String[].class);
        // 1.方法一：
        method.invoke(null, new Object[]{new String[]{"aa", "bb"}}); // jdk1.4没有String[],
        // 在这两个参数，升级过程不兼容导致,所以必须加Object
        // 2.方法二：不让他猜就行，这不是数组
        method.invoke(null, (Object) new String[]{"sasa", "sqd"});
    }
}
