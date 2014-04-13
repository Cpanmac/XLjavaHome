package com.xl.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//体验JDBC开发的过程
public class Demo4 {
	public static void main(String[] args) throws Exception {
		
		//注册数据库的驱动
		//DriverManager.registerDriver(new Driver());
		
		//利用反射机制间接加载数据库驱劝
		Class.forName("com.mysql.jdbc.Driver");
		
		//取得与MySQL数据库连接的桥梁
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/mydb2","root","root");
		
		//创建封装SQL命令的对象
		String sql = "select * from user";
		Statement stmt = conn.createStatement();
		
		//执行SQL命令，并返回符合条件的记录集合
		ResultSet rs = stmt.executeQuery(sql);
		
		//处理结果集合
		while(rs.next()){
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			float salary = rs.getFloat("salary");
			System.out.println(id+":"+name+":"+gender+":"+salary);
		}
		
		//依次关闭所用过的连接对象
		rs.close();
		stmt.close();
		conn.close();
	}
}
