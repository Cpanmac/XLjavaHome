package com.xl.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.jdbc.Driver;

public class Demo1 {
	String url = "jdbc:mysql://127.0.0.1:3306/test"; // 访问xl数据库
	String user = "root";
	String password = "123";

	private void register() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	}

	@Test
	public void test1() throws SQLException, ClassNotFoundException {
		// 方法1：直接注册数据库驱动, com.mysql.jdbc.Driver是Driver类得实现类
		// register();
		// 方法2：利用反射机制间接加载数据库驱动。不需要导包
		Class.forName("com.mysql.jdbc.Driver");

		// 取得与Mysql数据库连接的桥梁
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn);
		String sql = "select * from user";
		Statement stmt = conn.createStatement();
		boolean is = stmt.execute(sql);
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Object o = rs.getObject(1);
			String s1 = rs.getString(2);
			String s2 = rs.getString(3);
			System.out.println(o + "\t" + s1 + "\t" + s2);
		}
	}

	@Test
	public void test2() throws SQLException {
		// 注册数据库驱动, com.mysql.jdbc.Driver是Driver类得实现类
		Driver driver = new com.mysql.jdbc.Driver();
		register();
		// 取得与Mysql数据库连接的桥梁
		Connection conn = DriverManager.getConnection(url, user, password);
		boolean b = driver.acceptsURL(url);
		System.out.println(b);
	}
}
