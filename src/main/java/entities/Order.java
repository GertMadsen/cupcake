/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;

/**
 *  This class is an entity which contains details of a User entity so that it can attach orders with the user.
 *  It's methods are pretty standard set/get methods.
 * 
 * @author Strom
 */
public class Order {

    private int order_id;
    private User user;
    private String date;
    private List<Orderline> orderlines;
    private double total_price;
    

    public Order(User user) {
        this.user = user;
       

    }

    public static Order createOrder(User user) {
        Order order = new Order(user);
        return order;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Orderline> getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(List<Orderline> orderlines) {
        this.orderlines = orderlines;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "Order{" + "order_id=" + order_id + ", user=" + user + ", date=" + date + ", orderlines=" + orderlines + ", total_price=" + total_price + '}';
    }
    

}
