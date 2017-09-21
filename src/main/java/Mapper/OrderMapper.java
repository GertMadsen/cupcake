/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import Data.Connector;
import entities.Bottom;
import entities.Order;
import entities.Orderline;
import entities.Topping;
import entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class OrderMapper {
    
    public List<Order> getOrdersByUserId(User user) {
        List<Order> output = new ArrayList<Order>();
        try{
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
                order.setOrderlines(this.getOrderlinesByOrderId(order));
                output.add(order);
            }
        }catch (Exception e) {
            return null;
        }
        return output;
    }
    
    public List<Orderline> getOrderlinesByOrderId(Order order) {
        List<Orderline> output = new ArrayList<Orderline>();
        try{
            CupcakeMapper cm = new CupcakeMapper();

            Orderline oLine = null;
            String sql = "SELECT "
                    + "orderline_id, "
                    + "bottoms_bottom_id, "
                    + "toppings_topping_id, "
                    +"price, "
                    + "quantity "
                    + "FROM cupcake.vieworderlinedetails where orders_order_id = " + 
                    order.getOrder_id();
            PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            int orderlineId = 0;
            int bottomId = 0;
            int toppingId = 0;
            double price = 0;
            int quantity = 0;
            while (rs.next()) {
                orderlineId = rs.getInt("orderline_id");
                bottomId = rs.getInt("bottoms_bottom_id");
                toppingId = rs.getInt("toppings_topping_id");
                price = rs.getDouble("price");
                quantity = rs.getInt("quantity");

                Bottom bot = new Bottom(bottomId);
                bot = cm.getBottomByBottomId(bot);

                Topping top = new Topping(toppingId);
                top = cm.getToppingByToppingId(top);

                oLine = new Orderline(orderlineId, bot, top, quantity, price);
                output.add(oLine);
            }        
        }catch (Exception e) {
            return null;
        }
        return output;
    }
    
    
    public static void main(String[] args){
    
        
        User myuser = new UserMapper().getUserByID(1);
        
        //System.out.println(myuser);
        
        
        
        List<Order> myorder = new OrderMapper().getOrdersByUserId(myuser);
        System.out.println(myorder);
        
        for (Order o: myorder) {
            List<Orderline> myLine = new OrderMapper().getOrderlinesByOrderId(o);
            System.out.println("");
            System.out.println("next orderline list");
            System.out.println(myLine);
        }
        
        
        /*
        //new UserMapper().putUser("Jens Hansen", "bondegaard", 100000, "eyaeyajo@farmer.dk");
        
        User myuser2 = new UserMapper().getUserByID(2);
        System.out.println(myuser2);
        */
    }
    
}




