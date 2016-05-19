package com.xl.database.Oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class �����з���ֵ�Ĺ��� {
    public static void main(String[] args) {
        Connection ct = null;
        CallableStatement cs = null;
        try {
            // 1.��������
            Class.forName("oracle.jdbc.driver.OracleDriver");
            ct = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "q123");
            System.out.println("���سɹ�");
            // 2.����CallableStatement,�м�������Ҳ�����ʺ�
            cs = ct.prepareCall("{call sp_pro8(?,?,?,?)}");
            //����һ������ֵ
            cs.setInt(1, 7788);
            //���ڶ�������ֵ�����ǽ���,������α�Ļ�OracleTypes.CURSOR
            cs.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
            cs.registerOutParameter(3, oracle.jdbc.OracleTypes.DOUBLE);
            cs.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
            // ִ��
            cs.execute();
            //			ȡ������ֵ,Ҫע�⣿��˳��
            String name = cs.getString(2);
            double sal = cs.getDouble(3);
            String job = cs.getString(4);
            System.out.println("�����ǣ�" + name + "нˮ�ǣ�" + sal + "Ԫ�������ǣ�" + job);
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
