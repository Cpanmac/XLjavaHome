package com.xl.database.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {
    Connection conn = MysqlJdbcUtil.getMySqlConnection();

    @Override
    public void save(T entity) {
        String sql = "update  * from user";
        try {
            Statement stmt = conn.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
    }

    @Override
    public void update(T entity) {
        // TODO Auto-generated method stub
    }

    @Override
    public T getById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> getByIds(Long[] ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> findAll() {
        // TODO Auto-generated method stub
        return null;
    }
}
