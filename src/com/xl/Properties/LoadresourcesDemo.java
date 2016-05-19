package com.xl.Properties;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadresourcesDemo {
    /**
     * Ĭ�ϻ�ȥ��ǰ���classpath·����ȥ����Դ
     *
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        Properties p = new Properties();
        String name = "obj.properties";
        // Ĭ�ϻ�ȥ��ǰ���classpath·����ȥ����Դ,��һ�β�����أ������ڶ��γɹ���,�����ļ��ڱ����¡�
        BufferedInputStream in = (BufferedInputStream) LoadresourcesDemo.class.getResourceAsStream(name); // Class��ķ���
        System.out.println(in);
        p.load(in);
        System.out.println(p);
    }

    /**
     * Ĭ��ȥclasspath�ĸ�·��ȥ��
     *
     * @throws IOException
     */
    @Test
    public void testClassLoader() throws IOException {
        Properties p = new Properties();
        String name = "obj.properties";
        // ����õö࣬��Ϊ���Ǹ�·��(bin/) Hibernate���������ַ�ʽ
        InputStream in = LoadresourcesDemo.class.getClassLoader().getResourceAsStream("Properties/" + name); // ClassLoader��ķ�����
        // Ĭ��ȥclasspathd�ĸ�·��ȥ����Դ,����srcĿ¼
        System.out.println(in);
        p.load(in);
        System.out.println(p);
    }

    @Test
    public void test3() throws IOException {
        Properties p = new Properties();
        String name = "obj.properties";
        // ����3��Thread��Ҳ��ȥ��·��ȥ����Դ
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
        System.out.println(in);
        p.load(in);
        System.out.println(p);
    }
}
