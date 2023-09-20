package com.toby.spring.user.dao;
import com.toby.spring.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.annotation.DirtiesContext;

import java.sql.SQLException;

@DirtiesContext
public class UserDaoTest {

    @Autowired
    private ApplicationContext context;

    public void setUp(){
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
        UserDao dao = context.getBean("userDao", UserDao.class);
    }

    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setId("user");
        user.setName("백기선");
        user.setPassword("married");
    }

    public static void main(String[] args) {

    }
}