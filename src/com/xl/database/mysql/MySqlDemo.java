package com.xl.database.mysql;

import org.junit.Test;

import java.sql.Connection;

/**
 * Created with IntelliJ IDEA.
 * User: –Ï¡¢
 * Date: 2017/9/6
 * Time: 17:17
 * To change this template use File | Settings | File Templates.
 */
public class MySqlDemo {
    @Test
    public void getConnectTest() {
       Connection c= MysqlJdbcUtil.getMySqlConnection();
        System.out.println(c);
    }
}
