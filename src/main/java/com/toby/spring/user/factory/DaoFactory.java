package com.toby.spring.user.factory;

import com.toby.spring.user.config.ConnectionMaker;
import com.toby.spring.user.config.DConnectionMaker;
import com.toby.spring.user.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao(){
        // 생성자 메소드
        return new UserDao(connectionMaker());

//         수정자 메소드
//        UserDao userDao = new UserDao();
//        userDao.setConnectionMaker(connectionMaker());
//        return userDao;
    }
    @Bean
    public ConnectionMaker connectionMaker(){
        return new DConnectionMaker();
    }
}
