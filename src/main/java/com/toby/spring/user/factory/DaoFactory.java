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
       return new UserDao(connectionMaker());
    }
    @Bean
    public ConnectionMaker connectionMaker(){
        return new DConnectionMaker();
    }
}
