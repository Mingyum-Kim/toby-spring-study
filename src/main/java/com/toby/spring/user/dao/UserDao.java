package com.toby.spring.user.dao;

import com.toby.spring.user.User;
import com.toby.spring.user.config.ConnectionMaker;

import java.sql.*;

public class UserDao {

    private ConnectionMaker connectionMaker;

    // 생성자를 이용한 의존관계 주입
    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }
    
    // 수정자 메소드를 이용한 의존관계 주입
    public void setConnectionMaker(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker; 
    }

    // 사용자 생성
    public void add(User user) throws ClassNotFoundException, SQLException{

        Connection c = connectionMaker.makeConnection();

        // SQL을 담은 Statement를 실행
        PreparedStatement ps = c.prepareStatement("insert into users (id, name, password) values (?, ?, ?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    // 사용자 조회
    public User get(String id) throws ClassNotFoundException, SQLException {

        Connection c = connectionMaker.makeConnection();

        // SQL을 담은 Statement를 실행
        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

}
