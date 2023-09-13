package com.toby.spring.user.factory;

import com.toby.spring.user.config.ConnectionMaker;
import com.toby.spring.user.config.DConnectionMaker;
import com.toby.spring.user.dao.UserDao;

public class DaoFactory {
    public UserDao userDao(){
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }
}
