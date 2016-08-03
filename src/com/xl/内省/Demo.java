package com.xl.��ʡ;

import com.xl.entity.Person;
import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * ����javaBean������
 */
// ʹ����ʡapi����bean������
public class Demo {
    /**
     * ÿҳ��С
     */
    int pageSize;
    /**
     * �ܼ�¼��
     */
    int recordCount;
    /**
     * ��ҳ��
     */
    int pageCount;

    public static void main(String[] args) {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("���ݳɹ�");
            }
        }, 1000, 5000);
    }

    @Test
    public void ���Է�ҳ() {
        pageSize = 10;
        recordCount = 20;
        pageCount = recordCount / pageSize + (recordCount % pageSize > 0 ? 1 : 0);
        pageCount = recordCount % pageSize == 0 ? recordCount / pageSize : recordCount / pageSize + 1;
        pageCount = (recordCount + pageSize - 1) / pageSize;
        System.out.println(pageCount);
    }

    @Test
    public void ��������() {
        Scanner sr = new Scanner(System.in);
        System.out.println("����������");
        String s = "23r0u@qq.com.cn";
        s = sr.nextLine();
        String reg = ".+?@\\w+\\..+";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group());
        }
    }

    @Test
    public void ����ʱ��() {
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    @Test
    public void test1() throws Exception {
        /*
         * �õ�bean����������
		 */
        BeanInfo info = Introspector.getBeanInfo(Person.class);
        PropertyDescriptor[] pds = info.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            System.out.println(pd.getName()); // ����Person�е�get��set���ԡ�
        }
        /*
         * ֻ��ȡ�Լ�������
		 */
        info = Introspector.getBeanInfo(Person.class, Object.class); // ȥ���˼̳�Object��bean����getClass
        PropertyDescriptor[] pds_2 = info.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds_2) {
            System.out.println(pd.getName()); // ����Person�е�get��set���ԡ�
        }
    }

    /*
     * ��������
     */
    @Test
    public void test2() throws IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Person p = new Person();
        PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
        // �õ����Ե�д����
        Method method = pd.getWriteMethod(); // �õ�setAge
        method.invoke(p, 45);
        // System.out.println(p.getAge());
        // ������Ե�ֵ
        method = pd.getReadMethod();
        System.out.println(method.invoke(p, null));
    }

    /*
     * �߼������ݣ���ȡ��ǰ���������Ե�����
     */
    @Test
    public void test3() throws IntrospectionException {
        Person p = new Person();
        PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
        System.out.println(pd.getPropertyType()); // ���int
    }
}
