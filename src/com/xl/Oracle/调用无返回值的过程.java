package com.xl.Oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class �����޷���ֵ�Ĺ��� {
	public static void main(String[] args) {
		Connection ct = null;
		CallableStatement cs = null;
		try {
			// 1.��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			ct = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "q123");
			System.out.println("���سɹ�");
			// 2.����CallableStatement,�м�������Ҳ�����ʺ�
			cs = ct.prepareCall("{call sp_pro7(?,?,?)}");
			cs.setInt(1, 10);
			String s1 = "Ц������", s2 = "�廪������";
			cs.setString(2, s1);
			cs.setString(3, s2);
			// ִ��
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
				System.out.println("�رճɹ���");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
