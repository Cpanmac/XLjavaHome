package com.xl.database.Oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//ʹ��jdbc����oracl7e
public class jdbc����oracle {
    private static String url = "oracle.jdbc.driver.OracleDriver";
    private static String name = "";
    private static String password = "123";

    public static void main(String[] args) {
        try {
            // 1.��������
            Class.forName(url);
            // 2.�õ����� ���ݿ��url,�û��������� ǰ���urlͨ��java
            // buildpath����oracle����jar�������ֽ�classes12.jar)
            Connection ct = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", name, password);
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
}
