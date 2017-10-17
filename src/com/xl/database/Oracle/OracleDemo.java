package com.xl.database.Oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleDemo {
    private static String className = "oracle.jdbc.driver.OracleDriver";
    private static String name = "xl";
    private static String password = "xl";

    public static void main(String[] args) {
        try {
            Class.forName(className);
            Connection ct = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", name, password);
            Statement sm = ct.createStatement();
            ResultSet rs = sm.executeQuery("select * from emp");
            while (rs.next()) {
                System.out.println("???????" + rs.getString(2));
            }
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
            // 1.????????
            Class.forName("oracle.jdbc.driver.OracleDriver");
            ct = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "q123");
            System.out.println("??????");
            // 2.????CallableStatement,?м???????????????
            cs = ct.prepareCall("{call sp_pro8(?,?,?,?)}");
            //?????????setProperty
            cs.setInt(1, 7788);
            //?????????setProperty?????????,??????α???OracleTypes.CURSOR
            cs.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
            cs.registerOutParameter(3, oracle.jdbc.OracleTypes.DOUBLE);
            cs.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
            // ???
            cs.execute();
            //			????????,?????????
            String name = cs.getString(2);
            double sal = cs.getDouble(3);
            String job = cs.getString(4);
            System.out.println("???????" + name + "н????" + sal + "??????????" + job);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                cs.close();
                ct.close();
                System.out.println("???????");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void callstored2(String[] args) {
        Connection ct = null;
        CallableStatement cs = null;
        try {
            // 1.????????
            Class.forName("oracle.jdbc.driver.OracleDriver");
            ct = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "xl", "xl");
            System.out.println("??????");
            // 2.????CallableStatement,?м???????????????
            cs = ct.prepareCall("{call sp_pro9(?,?)}");
            // ?????????setProperty??????10?????
            cs.setInt(1, 10);
            // ?????????setProperty?????????
            cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
            // ???
            cs.execute();
            // ????????,?????????
            String name = cs.getString(2);
            // ????????
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
                System.out.println("???????");
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }
}
