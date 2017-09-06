package com.xl.database.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//重构JDBC开发的过程
public class Demo3 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select * from user";
        try {
            conn = MysqlJdbcUtil.getMySqlConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MysqlJdbcUtil.close(rs);
            MysqlJdbcUtil.close(stmt);
            MysqlJdbcUtil.close(conn);
        }
    }
}
