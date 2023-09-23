package com.toby.spring.user.dao;
import com.toby.spring.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.annotation.DirtiesContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@DirtiesContext
public class UserDaoTest {

    @Autowired
    private ApplicationContext context;

    public void setUp(){
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
        UserDao dao = context.getBean("userDao", UserDao.class);
    }

    public void add(final User user) throws SQLException {
        class AddStatement implements StatementStrategy { // add() 메소드 내부에 선언된 로컬 클래스
            @Override
            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values (?, ?, ?)");
                ps.setString(1, user.getId());
                ps.setString(2, user.getName());
                ps.setString(3, user.getPassword());

                return ps;
            }
        }

        StatementStrategy st = new AddStatement();
        jdbcContextWithStatementStrategy(st);
    }

    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setId("user");
        user.setName("백기선");
        user.setPassword("married");
    }

    public void deleteAll() throws SQLException {
        StatementStrategy st = new DeleteAllStatement(); // 전략 클래스의 오브젝트 생성
        jdbcContextWithStatementStrategy(st); // 컨텍스트 호출
    }

    public void jdbcContextWithStatementStrategy(StatementStrategy stmt) throws SQLException{
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = dataSource.getConnection();

            ps = stmt.makePreparedStatement(c);
            ps.executeUpdate();
        } catch (SQLException e){
            throw e;
        } finally {
            if (ps != null) { try {ps.close();} catch (SQLException e) {} }
            if (c != null) { try {c.close();} catch (SQLException e) {} }
        }
    }

    public static void main(String[] args) {

    }
}