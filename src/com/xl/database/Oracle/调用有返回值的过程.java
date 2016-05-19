package com.xl.database.Oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class 调用有返回值的过程 {
    public static void main(String[] args) {
        Connection ct = null;
        CallableStatement cs = null;
        try {
            // 1.加载驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");
            ct = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "q123");
            System.out.println("加载成功");
            // 2.创建CallableStatement,有几个参数也几个问号
            cs = ct.prepareCall("{call sp_pro8(?,?,?,?)}");
            //给第一个？赋值
            cs.setInt(1, 7788);
            //给第二个？赋值，这是接收,如果是游标的话OracleTypes.CURSOR
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
}
