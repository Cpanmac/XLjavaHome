package com.xl.database.Oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//使用jdbc连接oracl7e
public class jdbc连接oracle {
    private static String url = "oracle.jdbc.driver.OracleDriver";
    private static String name = "";
    private static String password = "123";

    public static void main(String[] args) {
        try {
            // 1.加载驱动
            Class.forName(url);
            // 2.得到连接 数据库的url,用户名，密码 前面的url通过java
            // buildpath导入oracle驱动jar包（名字叫classes12.jar)
            Connection ct = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", name, password);
            // 从下面开始和sql server一模一样
            Statement sm = ct.createStatement();
            ResultSet rs = sm.executeQuery("select * from emp");
            while (rs.next()) {
                // 用户名,先看姓名是哪个字段,是第二个，所以getString(2),从1开始的
                System.out.println("用户名：" + rs.getString(2));
            }
            // 关闭打开的资源
            rs.close();
            sm.close();
            ct.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
