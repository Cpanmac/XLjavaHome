package com.xl.database.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//重构JDBC开发的过程
public class Demo2 {
    public static void main(String[] args) {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/xl";
        String user = "root";
        String password = "123";
        String sql = "select * from user";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                float salary = rs.getFloat("salary");
                System.out.println(id + ":" + name + ":" + gender + ":" + salary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {//轻量级，创建和销毁rs所需要的时间和资源较小
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //上面出了异常这个一样会执行
            if (stmt != null) {//轻量级，创建和销毁rs所需要的时间和资源较小
                try {
                    stmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {//重量级，创建和销毁rs所需要的时间和资源较小
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //如果还没关闭就交给JVM
        }
    }
}
