package com.xl.database.Oracle;

import com.xl.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        // ��
        BaseDao bd = new BaseDao();
        Connection conn = bd.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            String sql;
            sql = "select * from msg";
            rs = stmt.executeQuery(sql);
            List<User> list = new ArrayList<User>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setPassWord(rs.getString("password"));
                list.add(user);
            }
            System.out.println("���" + "\t\t" + "�û���" + " \t" + "����");
            for (User e : list) {
                System.out.println(e.getId() + " \t" + " \t\t" + e.getPassWord());
            }
            // Scanner input = new Scanner(System.in);
            // System.out.println("�����û�����");
            // String name = input.next();
            // System.out.println("��������");
            // String passw = input.next();
            // int isTrue = 0;
            // for (User e : list) {
            // if (name.equals(e.getUserName())
            // && passw.equals(e.getPassWord())) {
            // isTrue = 1;
            // }
            // }
            //
            // if (isTrue == 1) {
            // System.out.println("��¼�ɹ���");
            // } else {
            // System.out.println("��¼ʧ�ܣ�");
            // }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        // if(conn!=null){
        // System.out.println("���ӳɹ�");
        // }else{
        // System.out.println("����ʧ��");
        // }1
        //
        try {
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
