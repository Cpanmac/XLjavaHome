package com.xl.database.Oracle;

import java.sql.*;

//ʹ��jdbc����oracl7e
public class OracleDemo {
    private static String url = "oracle.jdbc.driver.OracleDriver";
    private static String name = "xl";
    private static String password = "xl";

    public static void main(String[] args) {
        try {
            // 1.��������
            Class.forName(url);
            System.out.println("��ʼ����oracle");
            // 2.�õ����� ���ݿ��url,�û��������� ǰ���urlͨ��java
            // buildpath����oracle����jar�������ֽ�classes12.jar)
            Connection ct = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:PLSExtProc", name, password);
            // �����濪ʼ��sql serverһģһ��
            Statement sm = ct.createStatement();
            ResultSet rs = sm.executeQuery("select * from emp");
            while (rs.next()) {
                // �û���,�ȿ��������ĸ��ֶ�,�ǵڶ���������getString(2),��1��ʼ��
                System.out.println("�û�����" + rs.getString(2));
            }
            // �رմ򿪵���Դ
            rs.close();
            sm.close();
            ct.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void callstored(String[] args) {
        Connection ct = null;
        CallableStatement cs = null;
        try {
            // 1.��������
            Class.forName("oracle.jdbc.driver.OracleDriver");
            ct = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "q123");
            System.out.println("���سɹ�");
            // 2.����CallableStatement,�м�������Ҳ�����ʺ�
            cs = ct.prepareCall("{call sp_pro8(?,?,?,?)}");
            //����һ����setProperty
            cs.setInt(1, 7788);
            //���ڶ�����setProperty�����ǽ���,������α�Ļ�OracleTypes.CURSOR
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

    public static void callstored2(String[] args) {
        Connection ct = null;
        CallableStatement cs = null;
        try {
            // 1.��������
            Class.forName("oracle.jdbc.driver.OracleDriver");
            ct = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "q123");
            System.out.println("���سɹ�");
            // 2.����CallableStatement,�м�������Ҳ�����ʺ�
            cs = ct.prepareCall("{call sp_pro9(?,?)}");
            // ����һ����setProperty������10�Ų���
            cs.setInt(1, 10);
            // ���ڶ�����setProperty�����ǽ���
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
