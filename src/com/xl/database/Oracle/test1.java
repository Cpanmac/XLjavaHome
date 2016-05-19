package com.xl.database.Oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test1 {
    public static void main(String[] args) {
        // Ôö
        BaseDao bd = new BaseDao();
        Connection conn = bd.getConnection();
        // ResultSet rs = null;
        PreparedStatement ps = null;
        int flag = 0;
        conn = bd.getConnection();
        try {
            ps = conn.prepareStatement("insert into msg values (?,?,?)");
            ps.setInt(1, 1007);
            ps.setString(2, "sf");
            ps.setString(3, "sd");
            flag = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (flag > 0) {
            System.out.println("succes");
        } else {
            System.out.println("fault");
        }
        try {
            ps.close();
            // rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
