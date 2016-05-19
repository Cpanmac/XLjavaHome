package com.xl.database.Oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class �����з���ֵ�Ĺ���_�б����� {
    public static void main(String[] args) {
        Connection ct = null;
        CallableStatement cs = null;
        try {
            // 1.��������
            Class.forName("oracle.jdbc.driver.OracleDriver");
            ct = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "q123");
            System.out.println("���سɹ�");
            // 2.����CallableStatement,�м�������Ҳ�����ʺ�
            cs = ct.prepareCall("{call sp_pro9(?,?)}");
            // ����һ������ֵ������10�Ų���
            cs.setInt(1, 10);
            // ���ڶ�������ֵ�����ǽ���
            cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
            // ִ��
            cs.execute();
            // ȡ������ֵ,Ҫע�⣿��˳��
            String name = cs.getString(2);
            // �õ������
            ResultSet rs = (ResultSet) cs.getObject(2);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                cs.close();
                ct.close();
                System.out.println("�رճɹ���");
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }
}
