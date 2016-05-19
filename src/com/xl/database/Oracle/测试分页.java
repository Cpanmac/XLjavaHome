package com.xl.database.Oracle;

import com.xl.entity.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * 遇到的问题：
 * 1.在分页的时候按工资从低到高的时候，在oracle中select语句没有打空格，导致异常
 */
public class 测试分页 {
    public static void main(String[] args) {
        try {
            User user = new User();
            String name = user.getName();
            String password = user.getPassWord();
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection ct = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", name, password);
            String sql = "{call fenye(?,?,?,?,?,?)}";
            CallableStatement cs = ct.prepareCall(sql);
            cs.setString(1, "emp");
            // 分页显示5条记录
            cs.setInt(2, 5);
            // 显示第几页
            cs.setInt(3, 1);
            // 注册总记录数
            cs.registerOutParameter(4, oracle.jdbc.OracleTypes.INTEGER);
            // 注册总页数
            cs.registerOutParameter(5, oracle.jdbc.OracleTypes.INTEGER);
            // 注册返回的结果集
            cs.registerOutParameter(6, oracle.jdbc.OracleTypes.CURSOR);
            // 执行
            cs.execute();
            // 取出总记录数，这要注意getInt是取出第几个参数
            int rowNum = cs.getInt(4);
            int pageCount = cs.getInt(5);
            ResultSet rs = (ResultSet) cs.getObject(6);
            System.out.println("rowNum=" + rowNum);
            System.out.println("总页数：" + pageCount);
            while (rs.next()) {
                // emp表里面的字段类型是number所以getInt
                System.out.println("编号：" + rs.getInt(1) + "  名字：" + rs.getString(2) + "  工资：" + rs.getFloat(6));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
