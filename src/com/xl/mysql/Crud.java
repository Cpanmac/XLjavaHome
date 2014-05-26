package com.xl.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

//����JDBC��CURD����
//exceute(sql);����select��������true֮�⣬��������������false��
//Statementû�а�ȫ�Լ�⡣s
public class Crud {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	@Test
	public void create() {
						
		String sql = "insert into user(name,gender,salary) values('˿˿','Ů',3000)";
		try {
			conn = JdbcUtil.getMySqlConnection();
			stmt = conn.createStatement();
			int i = stmt.executeUpdate(sql);
			System.out.println(i);
			System.out.println(i > 0 ? "�ɹ�" : "ʧ��");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(conn);
		}
	}

	@Test
	public void read() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from user where gender='male'";
		try {
			conn = JdbcUtil.getMySqlConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				System.out.println(name + ":" + gender);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(conn);
		}
	}

	@Test
	public void update() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "update user set gender='female' where id = 8";
		try {
			conn = JdbcUtil.getMySqlConnection();
			stmt = conn.createStatement();
			int i = stmt.executeUpdate(sql);
			System.out.println(i > 0 ? "�ɹ�" : "ʧ��");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(conn);
		}
	}

	@Test
	public void delete() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "delete from user where name = '˿˿'";
		try {
			conn = JdbcUtil.getMySqlConnection();
			stmt = conn.createStatement();
			int i = stmt.executeUpdate(sql);
			System.out.println(i > 0 ? "�ɹ�" : "ʧ��");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(conn);
		}
	}

	public void read(String name) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from user where name='" + name + "'";
		System.out.println("sql=" + sql);
		try {
			conn = JdbcUtil.getMySqlConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// while(rs!=null)
				name = rs.getString("name");
				String gender = rs.getString("gender");
				System.out.println(name + ":" + gender);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(conn);
		}
	}

	@Test
	public void createTable() {
		String tableName = "xl";
		String sql = "create table if not exists " + tableName
				+ "(id varchar(40) primary key)";
		try {
			conn = JdbcUtil.getMySqlConnection();
			stmt = conn.createStatement();
			System.out.println(sql);

			// int i= stmt.executeUpdate(sql); //��������û��Ӱ��������i��ֵ��0
			boolean i = stmt.equals(sql);
			System.out.println(i); // false
			System.out.println("�����ɹ���");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(conn);
		}

	}

	@Test
	public void dropTable() {
		String tableName = "xl";
		String sql = "drop table if exists " + "xl";
		try {
			conn = JdbcUtil.getMySqlConnection();
			stmt = conn.createStatement();
			boolean b = stmt.execute(sql);
			System.out.println(b); // false
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// public static void main(String[] args) {
	// Crud crud = new Crud();
	// // crud.read(" 'or true or' ");
	// crud.createTable("system");
	// crud.dropTable("system");
	// }
}