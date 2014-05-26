package com.xl.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//�ع�JDBC�����Ĺ���
public class Demo3 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from user";
		try {
			 conn= JdbcUtil.getMySqlConnection();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery(sql);
			 while(rs.next()){
				 String name = rs.getString("name");
				 System.out.println(name);
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(conn);
		}
	}
}