package com.xl.database.Oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
    //4�� ��̬����
    private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final static String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private final static String USERNAME = "xl";

    //���ӷ���
    public Connection getConnection() {
        Connection conn = null;
        //��������
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, "xl");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
