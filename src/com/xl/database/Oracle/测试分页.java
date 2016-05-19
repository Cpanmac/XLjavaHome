package com.xl.database.Oracle;

import com.xl.entity.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * ���������⣺
 * 1.�ڷ�ҳ��ʱ�򰴹��ʴӵ͵��ߵ�ʱ����oracle��select���û�д�ո񣬵����쳣
 */
public class ���Է�ҳ {
    public static void main(String[] args) {
        try {
            User user = new User();
            String name = user.getName();
            String password = user.getPassWord();
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection ct = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", name, password);
            String sql = "{call fenye(?,?,?,?,?,?)}";
            CallableStatement cs = ct.prepareCall(sql);
            cs.setString(1, "emp");
            // ��ҳ��ʾ5����¼
            cs.setInt(2, 5);
            // ��ʾ�ڼ�ҳ
            cs.setInt(3, 1);
            // ע���ܼ�¼��
            cs.registerOutParameter(4, oracle.jdbc.OracleTypes.INTEGER);
            // ע����ҳ��
            cs.registerOutParameter(5, oracle.jdbc.OracleTypes.INTEGER);
            // ע�᷵�صĽ����
            cs.registerOutParameter(6, oracle.jdbc.OracleTypes.CURSOR);
            // ִ��
            cs.execute();
            // ȡ���ܼ�¼������Ҫע��getInt��ȡ���ڼ�������
            int rowNum = cs.getInt(4);
            int pageCount = cs.getInt(5);
            ResultSet rs = (ResultSet) cs.getObject(6);
            System.out.println("rowNum=" + rowNum);
            System.out.println("��ҳ����" + pageCount);
            while (rs.next()) {
                // emp��������ֶ�������number����getInt
                System.out.println("��ţ�" + rs.getInt(1) + "  ���֣�" + rs.getString(2) + "  ���ʣ�" + rs.getFloat(6));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
