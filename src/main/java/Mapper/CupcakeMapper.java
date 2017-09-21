/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import Data.Connector;
import entities.Bottom;
import entities.Topping;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Christian
 */
public class CupcakeMapper {
    
    public Topping getToppingByToppingId(Topping topping) throws SQLException {
        Topping output = topping;
        String sql = "SELECT name, price "
                + "FROM cupcake.toppings where topping_id =" + 
                topping.getId();
        PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        String name = "";
        double price = 0;
        while (rs.next()) {
            name = rs.getString("name");
            price = rs.getDouble("price");
        }
        output.setName(name);
        output.setPrice(price);
        
        return output;
    }
    
    public Bottom getBottomByBottomId(Bottom bottom) throws SQLException {
        Bottom output = bottom;
        String sql = "SELECT name, price "
                + "FROM cupcake.bottoms where bottom_id =" + 
                bottom.getId();
        PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        String name = "";
        double price = 0;
        while (rs.next()) {
            name = rs.getString("name");
            price = rs.getDouble("price");
        }
        output.setName(name);
        output.setPrice(price);
        
        return output;
    }
    
    public static void main(String[] args) throws SQLException {
        Topping top = new Topping(1);
        Bottom bot = new Bottom(2);
        top = new CupcakeMapper().getToppingByToppingId(top);
        bot = new CupcakeMapper().getBottomByBottomId(bot);
        System.out.println(top);
        System.out.println(bot);    
    }
}

/*

*/