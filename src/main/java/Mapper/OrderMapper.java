/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import Data.Connector;
import entities.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * 
 * Instantiated from:
 *
 * Presentation Layer: 
 *
 * Data Layer: 
 *
 * @author Christian
 */
public class OrderMapper {

    public static OrderMapper createOrderMapper() {
        OrderMapper om = new OrderMapper();
        return om;
    }

    public List<Order> getOrdersByUserId(User user) {
        List<Order> output = new ArrayList<Order>();
        try {
            Order order = null;
            String sql = "SELECT order_id, date, users_user_id "
                    + "FROM cupcake.orders where users_user_id ="
                    + user.getUser_id();
            PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            int orderId = 0;
            String date = "";
            while (rs.next()) {
                orderId = rs.getInt("order_id");
                date = rs.getString("date");
                order = Order.createOrder(user);
                order.setDate(date);
                order.setOrder_id(orderId);
                order.setOrderlines(this.getOrderlinesByOrderId(order));
                output.add(order);
            }
        } catch (Exception e) {
            return null;
        }
        return output;
    }

    public List<Order> getAllOrders() {
        List<Order> output = new ArrayList<Order>();
        UserMapper um = UserMapper.createUserMapper();
        try {
            Order order = null;
            String sql = "SELECT * FROM cupcake.orders ";
            PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            int orderId = 0;
            String date = "";
            int userId = 0;

            while (rs.next()) {
                orderId = rs.getInt("order_id");
                date = rs.getString("date");
                userId = rs.getInt("users_user_id");
                User user = um.getUserByID(userId);
                order = Order.createOrder(user);
                order.setDate(date);
                order.setOrder_id(orderId);
                order.setOrderlines(this.getOrderlinesByOrderId(order));
                output.add(order);
            }
        } catch (Exception e) {
            return null;
        }
        return output;
    }

    public Order getOrderById(int id) {
        Order order = null;
        try {

            String sql = "SELECT date, users_user_id "
                    + "FROM cupcake.orders where order_id ="
                    + id;
            PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int user_id = 0;
            String date = "";
            UserMapper um = UserMapper.createUserMapper();
            while (rs.next()) {
                user_id = rs.getInt("users_user_id");
                date = rs.getString("date");
                order = Order.createOrder(um.getUserByID(user_id));
                order.setDate(date);
                order.setOrder_id(id);
                List<Orderline> ol = this.getOrderlinesByOrderId(order);
                order.setOrderlines(ol);
            }
        } catch (Exception e) {
            return null;
        }
        return order;
    }

    public List<Orderline> getOrderlinesByOrderId(Order order) {
        List<Orderline> output = new ArrayList<Orderline>();
        try {
            CupcakeMapper cm = CupcakeMapper.createCupcakeMapper();

            Orderline oLine = null;
            String sql = "SELECT "
                    + "orderline_id, "
                    + "bottoms_bottom_id, "
                    + "toppings_topping_id, "
                    + "price, "
                    + "quantity "
                    + "FROM cupcake.vieworderlinedetails where orders_order_id = "
                    + order.getOrder_id();
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

                Bottom bot = Bottom.createBottom(bottomId);
                bot = cm.getBottomByBottomId(bot);

                Topping top = Topping.createTopping(toppingId);
                top = cm.getToppingByToppingId(top);

                oLine = Orderline.createOrderline(bot, top, quantity, price);
                oLine.setId(orderlineId);
                output.add(oLine);
            }
        } catch (Exception e) {
            return null;
        }
        return output;
    }

    public Order getInitOrderById(int id) {
        Order order = null;
        try {

            String sql = "SELECT date, users_user_id "
                    + "FROM cupcake.orders where order_id ="
                    + id;
            PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int user_id = 0;
            String date = "";
            UserMapper um = UserMapper.createUserMapper();
            while (rs.next()) {
                user_id = rs.getInt("users_user_id");
                date = rs.getString("date");
                order = Order.createOrder(um.getUserByID(user_id));
                order.setDate(date);
                order.setOrder_id(id);
            }
        } catch (Exception e) {
            return null;
        }
        return order;
    }

    public void putToOrderdetailsTable(int orderId, int orderlineId, int quantity) throws SQLException {
        Connection conn = Connector.getConnection();
        String insertUser = "INSERT INTO cupcake.orderdetails ("
                + "orders_order_id, "
                + "orderlines_orderline_id,"
                + "quantity) "
                + "VALUES (?, ?, ?);";
        PreparedStatement recipePstmt = conn.prepareStatement(insertUser);
        try {
            conn.setAutoCommit(false);
            recipePstmt.setInt(1, orderId);
            recipePstmt.setInt(2, orderlineId);
            recipePstmt.setInt(3, quantity);
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

    public int putToOrderTable(Order order) throws SQLException {
        int output = 0;
        ResultSet rs = null;
        int userId = order.getUser().getUser_id();

        //String name, String password, double balance, String email
        Connection conn = Connector.getConnection();
        String insertUser = "INSERT INTO cupcake.orders ("
                + "users_user_id)"
                + "VALUES (?);";
        PreparedStatement recipePstmt = conn.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS);
        try {
            conn.setAutoCommit(false);
            recipePstmt.setInt(1, userId);
            recipePstmt.executeUpdate();
            rs = recipePstmt.getGeneratedKeys();
            rs.next();
            output = rs.getInt(1);
            conn.commit();
        } catch (SQLException ex) {
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            conn.setAutoCommit(true);
        }
        return output;

    }

    // public Orderline(Bottom bottom, Topping topping, int quantity, double price) {
    public int putToOrderLineTable(Orderline oLine) throws SQLException {
        int output = 0;
        ResultSet rs = null;
        Bottom bot = oLine.getBottom();
        Topping top = oLine.getTopping();
        double price = oLine.getPrice();

        Connection conn = Connector.getConnection();
        String insertOrderline = "INSERT INTO cupcake.orderlines ("
                + "price, bottoms_bottom_id, toppings_topping_id)"
                + "VALUES (?, ?, ?);";
        PreparedStatement recipePstmt = conn.prepareStatement(insertOrderline, Statement.RETURN_GENERATED_KEYS);
        try {
            conn.setAutoCommit(false);
            recipePstmt.setDouble(1, price);
            recipePstmt.setInt(2, bot.getId());
            recipePstmt.setInt(3, top.getId());
            recipePstmt.executeUpdate();
            rs = recipePstmt.getGeneratedKeys();
            rs.next();
            output = rs.getInt(1);
            conn.commit();
        } catch (SQLException ex) {
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            conn.setAutoCommit(true);
        }
        return output;

    }

}
