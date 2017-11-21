package com.xl.properties;

import com.xl.util.FileTool;
import com.xl.util.Print;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public class LoadresourcesTest {
    private String name;

    @Before
    public void before() {
        name = "properties\\obj.properties";
    }
    /**
     * 默认回去当前类的classpath路径下去找资源
     *
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        Properties p = new Properties();
        // 默认回去当前类的classpath路径下去找资源,第一次不会加载，报错，第二次成功！,配置文件在本包下。
        BufferedInputStream in = (BufferedInputStream) FileTool.getResourceInputStream(name); // Class类的方法
        Print.info(in);
        p.load(in);
        Print.info(p);
    }

    /**
     * 默认去classpath的根路径去找
     *
     * @throws IOException
     */
    @Test
    public void testClassLoader() throws IOException {
        Properties p = new Properties();
        // 这个用得多，因为都是根路径(bin/) Hibernate用上面那种方式
        InputStream in = LoadresourcesTest.class.getClassLoader().getResourceAsStream(name); // ClassLoader类的方法。
        // 默认去classpathd的根路径去找资源,放在src目录
        Print.info(in);
        p.load(in);
        Print.info(p);
    }

    @Test
    public void test3() throws IOException {
        Properties p = new Properties();
        // 方法3：thread，也是去根路径去找资源
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
        Print.info(in);
        p.load(in);
        Print.info(p);
    }

    @Test
    public void demoTest() {
        ResourceBundle rb = ResourceBundle.getBundle(name.substring(0, name.lastIndexOf(".")));
        Enumeration<String> keys = rb.getKeys();
        while (keys.hasMoreElements()) {
            Print.info(keys.nextElement());
        }
    }
}
