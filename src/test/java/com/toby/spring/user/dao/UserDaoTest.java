package com.toby.spring.user.dao;
import com.toby.spring.user.factory.DaoFactory;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       UserDao dao = new DaoFactory().userDao();

       // ...
    }
}