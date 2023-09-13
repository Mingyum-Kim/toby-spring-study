package com.toby.spring.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DUserDao extends UserDao{
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        // N사의 DB Connection Code
        return null;
    }
}
