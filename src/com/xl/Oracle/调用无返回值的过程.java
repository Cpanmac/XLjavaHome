package com.xl.Oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class 调用无返回值的过程 {
	public static void main(String[] args) {
		Connection ct = null;
		CallableStatement cs = null;
		try {
			// 1.加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			ct = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "q123");
			System.out.println("加载成功");
			// 2.创建CallableStatement,有几个参数也几个问号
			cs = ct.prepareCall("{call sp_pro7(?,?,?)}");
			cs.setInt(1, 10);
			String s1 = "笑傲江湖", s2 = "清华出版社";
			cs.setString(2, s1);
			cs.setString(3, s2);
			// 执行
			cs.execute();
			System.out.println("hello");
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
