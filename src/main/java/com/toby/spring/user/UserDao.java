package com.toby.spring.user;

import java.sql.*;

public class UserDao {

    // 사용자 생성
    public void add(User user) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");

        // DB 연결을 위한 Connection 객체
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");

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
        Class.forName("com.mysql.jdbc.Driver");

        // DB 연결을 위한 Connection 객체
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");

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
