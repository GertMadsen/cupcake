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
        output = new User(userID, userName, password, email, balance);
        
        return output;
    }
    
    public static void main(String[] args) throws SQLException {
    
        User myuser = new UserMapper().getUserByID(1);
        System.out.println(myuser);
        
    }
}
