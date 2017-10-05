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


/**
 * This class is used to get an user from the DB or update an user or to put a new user down in the DB.
 * 
 * 
 * This class is used from OrderMapper, GenerateOrder, Login_registration.
 * 
 * @author Christian
 */

public class UserMapper { 

    public static UserMapper createUserMapper() {
        UserMapper um = new UserMapper();
        return um;
    }
    
    public User getUserByName(String name) {
        User output = null;
        try {
            String sql = "SELECT user_id,username, password,balance, email, administrator FROM cupcake.users where username='" + name+"'";
            PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            int userID = 0;
            String userName = "";
            String password = "";
            double balance = 0;
            String email = "";
            boolean admin = false;
            while (rs.next()) {
                userID = rs.getInt("user_id");
                userName = name; //rs.getString("username");
                password = rs.getString("password");
                balance = rs.getDouble("balance");
                email = rs.getString("email");
                admin = rs.getBoolean("administrator");
                
            }
            output = User.createUser(userName, password, balance, email, admin);
            output.setUser_id(userID);
        }catch (SQLException ex) {
            return null;
        }
        return output;
    } 
    
    public void updateUserBalanceById(User user, double newbalance) throws SQLException {
        //User output = user;
                
        Connection conn = Connector.getConnection();
        String sql = "UPDATE cupcake.users SET balance="+
                newbalance +" WHERE user_id="+user.getUser_id();
        PreparedStatement recipePstmt = conn.prepareStatement(sql);
        
        try {
            conn.setAutoCommit(false);
            recipePstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            if (conn != null) {
                conn.rollback();
            }
//            return null;
        } finally {
            conn.setAutoCommit(true);
        }
        user.setBalance(newbalance);
//        output.setBalance(newbalance);
//        return output;
    }
    
    public User getUserByID(int id) {
        User output = null;
        try{
            String sql = "SELECT user_id,username, password,balance, email, administrator FROM cupcake.users where user_id=" + id;
            PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int userID = 0;
            String userName = "";
            String password = "";
            double balance = 0;
            String email = "";
            boolean admin = false;
            while (rs.next()) {
                userID = id;//rs.getInt("user_id");
                userName = rs.getString("username");
                password = rs.getString("password");
                balance = rs.getDouble("balance");
                email = rs.getString("email");
                admin = rs.getBoolean("administrator");
            }
            output = User.createUser(userName, password, balance, email, admin);
            output.setUser_id(id);
        }catch (Exception e) {
            return null;
        }
        return output;
    }
    
    public void putUser(User user) throws SQLException {
        String name = user.getName();
        String password = user.getPassword();
        double balance = user.getBalance();
        String email = user.getEmail();
        boolean admin = user.isAdmin();
        //String name, String password, double balance, String email
        Connection conn = Connector.getConnection();
        String insertUser = "INSERT INTO cupcake.users ("
                + "username, password, balance, email, administrator)"
                + "VALUES (?, ?, ?, ?, ?);";
        PreparedStatement recipePstmt = conn.prepareStatement(insertUser);
        try {
            conn.setAutoCommit(false);
            recipePstmt.setString(1, name);
            recipePstmt.setString(2, password);
            recipePstmt.setDouble(3, balance);
            recipePstmt.setString(4, email);
            recipePstmt.setBoolean(5, admin);
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
    
}
