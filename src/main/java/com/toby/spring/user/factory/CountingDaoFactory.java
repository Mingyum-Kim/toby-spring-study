package com.toby.spring.user.factory;

import com.toby.spring.config.connection.ConnectionMaker;
import com.toby.spring.config.connection.CountingConnectionMaker;
import com.toby.spring.config.connection.DConnectionMaker;
import com.toby.spring.user.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountingDaoFactory {
    @Bean
    public UserDao userDao(){
        return new UserDao(connectionMaker());
    }
    @Bean
    public ConnectionMaker connectionMaker(){
        return new CountingConnectionMaker(realConnectionMaker());
    }
    @Bean
    public ConnectionMaker realConnectionMaker(){
        return new DConnectionMaker();
    }
}
