package com.xl.database.Oracle;

import java.sql.*;

//使用jdbc连接oracl7e
public class OracleDemo {
    private static String url = "oracle.jdbc.driver.OracleDriver";
    private static String name = "xl";
    private static String password = "xl";

    public static void main(String[] args) {
        try {
            // 1.加载驱动
            Class.forName(url);
            System.out.println("开始连接oracle");
            // 2.得到连接 数据库的url,用户名，密码 前面的url通过java
            // buildpath导入oracle驱动jar包（名字叫classes12.jar)
            Connection ct = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:PLSExtProc", name, password);
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

    public static void callstored(String[] args) {
        Connection ct = null;
        CallableStatement cs = null;
        try {
            // 1.加载驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");
            ct = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "q123");
            System.out.println("加载成功");
            // 2.创建CallableStatement,有几个参数也几个问号
            cs = ct.prepareCall("{call sp_pro8(?,?,?,?)}");
            //给第一个？setProperty
            cs.setInt(1, 7788);
            //给第二个？setProperty，这是接收,如果是游标的话OracleTypes.CURSOR
            cs.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
            cs.registerOutParameter(3, oracle.jdbc.OracleTypes.DOUBLE);
            cs.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
            // 执行
            cs.execute();
            //			取出返回值,要注意？的顺序
            String name = cs.getString(2);
            double sal = cs.getDouble(3);
            String job = cs.getString(4);
            System.out.println("姓名是：" + name + "薪水是：" + sal + "元，工作是：" + job);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                cs.close();
                ct.close();
                System.out.println("关闭成功！");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void callstored2(String[] args) {
        Connection ct = null;
        CallableStatement cs = null;
        try {
            // 1.加载驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");
            ct = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "q123");
            System.out.println("加载成功");
            // 2.创建CallableStatement,有几个参数也几个问号
            cs = ct.prepareCall("{call sp_pro9(?,?)}");
            // 给第一个？setProperty，查阅10号部门
            cs.setInt(1, 10);
            // 给第二个？setProperty，这是接收
            cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
            // 执行
            cs.execute();
            // 取出返回值,要注意？的顺序
            String name = cs.getString(2);
            // 得到结果集
            ResultSet rs = (ResultSet) cs.getObject(2);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                cs.close();
                ct.close();
                System.out.println("关闭成功！");
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }
}
