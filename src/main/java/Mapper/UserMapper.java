/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import Data.Connector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        while (rs.next()) {
            int userID = id;//rs.getInt("user_id");
            String userName = rs.getString("username");
            String password = rs.getString("password");
            double balance = rs.getDouble("balance");
            String email = rs.getString("email");
        }
        output = new User(userID, );
        
        return output;
    }
}
