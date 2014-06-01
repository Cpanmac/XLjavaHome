package com.xl.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static final String url = "jdbc:mysql://localhost:3306/bookmanager";
	private static final String driverClass = "com.mysql.jdbc.Driver";
	private static final String username = "root";
	private static final String password = "123";
	private static Connection conn;
	private static java.sql.PreparedStatement statement;
	static {
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	public static void close(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (conn != null)
					try {
						conn.close();
					} catch (Exception e) {
						conn = null;
					}
			}
		}
	}
}
