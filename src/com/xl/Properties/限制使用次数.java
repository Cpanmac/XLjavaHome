package com.xl.Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class 限制使用次数 { // 可以写进系统文件里面，被别人删不了
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        File file = new File("count.properties"); // 防止异常，先封装成对象，可以进行判断，流做不了
        if (!file.exists()) // 如果文件不存在就创建
            file.createNewFile();
        FileInputStream fis = new FileInputStream(file); // 扩展名就是配置信息
        prop.load(fis);
        int count = 0;// 计数器
        String value = prop.getProperty("time");
        if (value != null) { // 如果不为空，则自增
            count = Integer.parseInt(value);
            if (count >= 2) {
                System.out.println("您好，使用次数已到，拿钱！如果不注册的话，您的机器会冒烟");
                return;
            }
        }
        count++; // 如果为空，就把0++
        prop.setProperty("time", count + "");
        FileOutputStream fos = new FileOutputStream(file);
        prop.store(fos, "");
        fos.close();
        fis.close();
    }
}
/*
 * 描述10个人XML有利于区分 <Person> <person> id="001"> <name>zhangsan</name>
 * <age>30</age> <address>bj</address> <person>id=="002"> ....
 * 
 * </Person>
 * 
 * Document类，可以取出这些数据，不过相当麻烦，后来就有了工具dom4j dom for java (4与four谐音)
 */

