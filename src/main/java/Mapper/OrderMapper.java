/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import Data.Connector;
import entities.Order;
import entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Christian
 */
public class OrderMapper {
    
    public List<Order> getOrdersByUserId(User user) throws SQLException {
        List<Order> output = null;
        Order order = null;
        String sql = "SELECT order_id, date, users_user_id "
                + "FROM cupcake.orders where users_user_id =" + 
                user.getUser_id();
        PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        int orderId = 0;
        String date = "";
        while (rs.next()) {
            orderId = rs.getInt("order_id");
            date = rs.getString("date");
            order = new Order(orderId, user, date);
            output.add(order);
        }
        return output;
    }
    
    // to be created
    public Order addDetailsByOrderId( Order order) {
        Order output = order;
        return output;
    }
    
}
