package com.xl.reflect;

import com.xl.entity.Person;
import com.xl.util.Print;
import org.junit.Test;

import java.lang.reflect.Field;

public class GetField {
    private String className = "reflect.Person";

    /*
     * 获取公有字段
     */
    @Test
    public void test1() throws ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException {
        Person p = new Person();
        Class clazz = Class.forName(className);
        Field field = clazz.getField("name"); // 传属性名
        String name = (String) field.get(p);
        Print.info(name);
        //得到属性的值
        //Print.print(f.get(f));
        /*
         * 如果不知道字段类型
		 */
        Class type = field.getType();
        Print.info(type); // class java.lang.String
        Object value = field.get(p);
        Object obj = field.get(p);
        if (type.equals(String.class)) {
            String svalue = (String) value;
            Print.info(svalue);
        }

		/*
         * 设置字段的值
		 */
        field.set(p, "xxx");
        Print.info(p.name);
    }

    /*
     * 获取私有的字段
     */
    @Test
    public void test2() throws Exception {
        Person p = new Person();
        Class clazz = Class.forName(className);
        Field f = clazz.getDeclaredField("password");
        f.setAccessible(true);
        Print.info(f.get(p));
    }
    /*
     * 获取静态的字段:和上面一样，不能省略对象。
	 */
}
