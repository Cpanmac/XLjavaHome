package com.xl.����;

import com.xl.entity.Person;
import org.junit.Test;

import java.lang.reflect.Field;

public class ��ȡ�ֶ� {
    private String className = "reflect.Person";

    /*
     * ��ȡ�����ֶ�
     */
    @Test
    public void test1() throws ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException {
        Person p = new Person();
        Class clazz = Class.forName(className);
        Field field = clazz.getField("name"); // ��������
        String name = (String) field.get(p);
        System.out.println(name);
        //�õ����Ե�ֵ
        //System.out.println(f.get(f));
        /*
         * �����֪���ֶ�����
		 */
        Class type = field.getType();
        System.out.println(type); // class java.lang.String
        Object value = field.get(p);
        Object obj = field.get(p);
        if (type.equals(String.class)) {
            String svalue = (String) value;
            System.out.println(svalue);
        }

		/*
         * �����ֶε�ֵ
		 */
        field.set(p, "xxx");
        System.out.println(p.name);
    }

    /*
     * ��ȡ˽�е��ֶ�
     */
    @Test
    public void test2() throws Exception {
        Person p = new Person();
        Class clazz = Class.forName(className);
        Field f = clazz.getDeclaredField("password");
        f.setAccessible(true);
        System.out.println(f.get(p));
    }
    /*
     * ��ȡ��̬���ֶ�:������һ��������ʡ�Զ���
	 */
}
