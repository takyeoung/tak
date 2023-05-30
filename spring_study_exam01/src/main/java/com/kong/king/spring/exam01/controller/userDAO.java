package com.kong.king.spring.exam01.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class userDAO {
    final String JDBC_DRIVER = "org.mariadb.Driver";
    final String JDBC_URL = "jdbc:mariadb:tcp://localhost/~/spring_web";
    


    public Connection open() {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(JDBC_URL, "root", "1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public List<user> getAll() throws Exception {
        List<user> userList = new ArrayList<>();
        String sql = "SELECT user_c, user_n, user_id, user_pw, user_e, user_address FROM user";
        
        try (Connection conn = open();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                user u = new user();
                u.setUser_c(rs.getInt("user_c"));
                u.setUser_n(rs.getString("user_n"));
                u.setUser_id(rs.getString("user_id"));
                u.setUser_pw(rs.getString("user_pw"));
                u.setUser_e(rs.getString("user_e"));
                u.setUser_adress(rs.getString("user_address"));
                userList.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return userList;
    }

    public void adduser(user u) throws Exception {
        Connection conn = open();

        String sql = "insert into user(user_n,user_id,user_pw,user_e,user_adress)"
                + " values(?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        try (conn; pstmt) {
            pstmt.setString(1, u.getUser_n());
            pstmt.setString(2, u.getUser_id());
            pstmt.setString(3, u.getUser_pw());
            pstmt.setString(4, u.getUser_e());
            pstmt.setString(5, u.getUser_adress());

            pstmt.executeUpdate(); // SQL 쿼리 실행
        }
    }
}
