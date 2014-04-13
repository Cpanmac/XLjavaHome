package com.xl.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//����JDBC�����Ĺ���
public class Demo4 {
	public static void main(String[] args) throws Exception {
		
		//ע�����ݿ������
		//DriverManager.registerDriver(new Driver());
		
		//���÷�����Ƽ�Ӽ������ݿ���Ȱ
		Class.forName("com.mysql.jdbc.Driver");
		
		//ȡ����MySQL���ݿ����ӵ�����
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/mydb2","root","root");
		
		//������װSQL����Ķ���
		String sql = "select * from user";
		Statement stmt = conn.createStatement();
		
		//ִ��SQL��������ط��������ļ�¼����
		ResultSet rs = stmt.executeQuery(sql);
		
		//����������
		while(rs.next()){
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			float salary = rs.getFloat("salary");
			System.out.println(id+":"+name+":"+gender+":"+salary);
		}
		
		//���ιر����ù������Ӷ���
		rs.close();
		stmt.close();
		conn.close();
	}
}
