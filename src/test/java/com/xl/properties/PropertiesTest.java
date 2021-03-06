package com.xl.properties;

import com.xl.util.Print;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 徐立
 * Date: 2017-11-21
 * Time: 13:34
 * To change this template use File | Settings | File Templates.
 */
public class PropertiesTest {

    public static void loadDemo() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("info.txt");
        InputStreamReader isr = new InputStreamReader(fis); // 没有这的话，文字将是乱码
        prop.load(isr);
        // Print.print(prop);
        // 修改了下属性
        prop.setProperty("wangwu", "39");
        prop.list(System.out); // 列出集合目录
        // store 方法存储到文件
        FileOutputStream fos = new FileOutputStream("info1.txt");
        prop.store(fos, "haha");
        prop.list(System.out);
        isr.close();
        fos.close();
        fis.close();
    }

    /*
     * 演示，如何将流中的数据存储到集合中。 想要将info.txt中键值数据存储到集合中进行操作。 1.用一个流和info.txt文件关联
     * 2.读取一行数据，将改行数据用“=”进行切割。 3.等号左边作为键，右边作为值，存储到Properties集合中
     */
    // 设置和获取元素。
    public static void method_1() throws IOException {
        Properties prop = new Properties();
        BufferedReader br = new BufferedReader(new FileReader("info.txt"));
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] arr = line.split("=");
            prop.setProperty(arr[0], arr[1]); // 将数据存储到Properties数据
            // Print.print(line);
        }
        br.close();
        Print.info(prop);
    }

    public static void setAndGet() {
        Properties prop = new Properties();
        prop.setProperty("张三", "30");
        prop.setProperty("lisi", "39");
        Print.info(prop); // {张三=30, lisi=39}
        String value = prop.getProperty("lisi"); // 获取值
        Print.info(value);
        // 打印键
        Set<String> names = prop.stringPropertyNames();
        for (String s : names) {
            Print.info(s + ":" + prop.getProperty(s));
        }
    }
}
