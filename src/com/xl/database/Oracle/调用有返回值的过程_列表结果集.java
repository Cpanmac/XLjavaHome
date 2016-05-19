package com.xl.database.Oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class 调用有返回值的过程_列表结果集 {
    public static void main(String[] args) {
        Connection ct = null;
        CallableStatement cs = null;
        try {
            // 1.加载驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");
            ct = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "q123");
            System.out.println("加载成功");
            // 2.创建CallableStatement,有几个参数也几个问号
            cs = ct.prepareCall("{call sp_pro9(?,?)}");
            // 给第一个？赋值，查阅10号部门
            cs.setInt(1, 10);
            // 给第二个？赋值，这是接收
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
