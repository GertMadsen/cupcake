/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import Data.Connector;
import entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Christian
 */
public class UserMapper {
    public User getUserByID(int id) throws SQLException {
        User output = null;
        String sql = "SELECT user_id,username, password,balance, email FROM cupcake.users where user_id=" + id;
        PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        int userID = 0;
        String userName = "";
        String password = "";
        double balance = 0;
        String email = "";
        while (rs.next()) {
            userID = id;//rs.getInt("user_id");
            userName = rs.getString("username");
            password = rs.getString("password");
            balance = rs.getDouble("balance");
            email = rs.getString("email");
        }
        output = new User(userID, userName, password, balance, email);
        
        return output;
    }
    
    public void putUser(String name, String password, double balance, String email) throws SQLException {
        Connection conn = Connector.getConnection();
        String insertUser = "INSERT INTO cupcake.users ("
                + "username, password, balance, email)"
                + "VALUES (?, ?, ?, ?);";
        PreparedStatement recipePstmt = conn.prepareStatement(insertUser);
        try {
            conn.setAutoCommit(false);
            recipePstmt.setString(1, name);
            recipePstmt.setString(2, password);
            recipePstmt.setDouble(3, balance);
            recipePstmt.setString(4, email);
            recipePstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            conn.setAutoCommit(true);
        }
        
    }
    
    public static void main(String[] args) throws SQLException {
    
        User myuser = new UserMapper().getUserByID(1);
        System.out.println(myuser);
        
        //new UserMapper().putUser("Jens Hansen", "bondegaard", 100000, "eyaeyajo@farmer.dk");
        
        User myuser2 = new UserMapper().getUserByID(2);
        System.out.println(myuser2);
        
    }
    
    
    /*
    public void putUser(User user) throws SQLException {
        User userToFile = null;
        Connection conn = Connector.getConnection();
        String insertUser = "INSERT INTO cupcake.users ("
                + "username, password, balance, email)"
                + "VALUES (?, ?, ?, ?);";
        PreparedStatement recipePstmt = conn.prepareStatement(insertUser);
        try {
        conn.setAutoCommit(false);
        recipePstmt.setString(1, user.getName());
        recipePstmt.setString(2, user.getPassword());
        recipePstmt.setDouble(3, user.getBalance());
        recipePstmt.setString(4, user.getEmail());
        recipePstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            conn.setAutoCommit(true);
        }
    }
    */
}
