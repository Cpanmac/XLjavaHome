package com.xl.database.Oracle;

import com.xl.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        // 查
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
            System.out.println("编号" + "\t\t" + "用户名" + " \t" + "密码");
            for (User e : list) {
                System.out.println(e.getId() + " \t" + " \t\t" + e.getPassWord());
            }
            // Scanner input = new Scanner(System.in);
            // System.out.println("输入用户名：");
            // String name = input.next();
            // System.out.println("输入密码");
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
            // System.out.println("登录成功！");
            // } else {
            // System.out.println("登录失败！");
            // }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        // if(conn!=null){
        // System.out.println("连接成功");
        // }else{
        // System.out.println("连接失败");
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
