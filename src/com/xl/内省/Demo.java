package com.xl.内省;

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
 * 操作javaBean的属性
 */
// 使用内省api操作bean的属性
public class Demo {
    /**
     * 每页大小
     */
    int pageSize;
    /**
     * 总记录数
     */
    int recordCount;
    /**
     * 总页数
     */
    int pageCount;

    public static void main(String[] args) {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("备份成功");
            }
        }, 1000, 5000);
    }

    @Test
    public void 测试分页() {
        pageSize = 10;
        recordCount = 20;
        pageCount = recordCount / pageSize + (recordCount % pageSize > 0 ? 1 : 0);
        pageCount = recordCount % pageSize == 0 ? recordCount / pageSize : recordCount / pageSize + 1;
        pageCount = (recordCount + pageSize - 1) / pageSize;
        System.out.println(pageCount);
    }

    @Test
    public void 测试邮箱() {
        Scanner sr = new Scanner(System.in);
        System.out.println("请输入邮箱");
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
    public void 测试时间() {
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    @Test
    public void test1() throws Exception {
        /*
         * 得到bean的所有属性
		 */
        BeanInfo info = Introspector.getBeanInfo(Person.class);
        PropertyDescriptor[] pds = info.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            System.out.println(pd.getName()); // 根据Person中的get、set属性。
        }
        /*
         * 只获取自己的属性
		 */
        info = Introspector.getBeanInfo(Person.class, Object.class); // 去掉了继承Object的bean属性getClass
        PropertyDescriptor[] pds_2 = info.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds_2) {
            System.out.println(pd.getName()); // 根据Person中的get、set属性。
        }
    }

    /*
     * 运行属性
     */
    @Test
    public void test2() throws IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Person p = new Person();
        PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
        // 得到属性的写方法
        Method method = pd.getWriteMethod(); // 得到setAge
        method.invoke(p, 45);
        // System.out.println(p.getAge());
        // 获得属性的值
        method = pd.getReadMethod();
        System.out.println(method.invoke(p, null));
    }

    /*
     * 高级点内容：获取当前操作的属性的类型
     */
    @Test
    public void test3() throws IntrospectionException {
        Person p = new Person();
        PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
        System.out.println(pd.getPropertyType()); // 输出int
    }
}
