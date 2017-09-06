package com.xl.database.mysql;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

//JDBC�����ࣺ�ر�����ȡ������
public final class MysqlJdbcUtil {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    // ��̬�飺�����ļ�
    static {
        Properties props = new Properties();
        // ��ù���Ŀ¼
        try {
            InputStream is = MysqlJdbcUtil.class.getResourceAsStream("/mysql/db.properties");
            props.load(is);
            driver = props.getProperty("driver");
            url = props.getProperty("url");
            user = props.getProperty("user");
            password = props.getProperty("password");
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // ȡ������
    public static Connection getMySqlConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    // �ر�����
    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}