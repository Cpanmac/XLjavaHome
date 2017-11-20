package com.xl.properties;

import com.xl.util.Print;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadresourcesDemo {
    /**
     * 默认回去当前类的classpath路径下去找资源
     *
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        Properties p = new Properties();
        String name = "obj.properties";
        // 默认回去当前类的classpath路径下去找资源,第一次不会加载，报错，第二次成功！,配置文件在本包下。
        BufferedInputStream in = (BufferedInputStream) LoadresourcesDemo.class.getResourceAsStream(name); // Class类的方法
        Print.println(in);
        p.load(in);
        Print.println(p);
    }

    /**
     * 默认去classpath的根路径去找
     *
     * @throws IOException
     */
    @Test
    public void testClassLoader() throws IOException {
        Properties p = new Properties();
        String name = "obj.properties";
        // 这个用得多，因为都是根路径(bin/) Hibernate用上面那种方式
        InputStream in = LoadresourcesDemo.class.getClassLoader().getResourceAsStream("properties/" + name); // ClassLoader类的方法。
        // 默认去classpathd的根路径去找资源,放在src目录
        Print.println(in);
        p.load(in);
        Print.println(p);
    }

    @Test
    public void test3() throws IOException {
        Properties p = new Properties();
        String name = "obj.properties";
        // 方法3：thread，也是去根路径去找资源
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
        Print.println(in);
        p.load(in);
        Print.println(p);
    }
}
