/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;

/**
 *
 * @author Strom
 */
public class Order {

    int order_id;
    User user;
    List<Orderline> orderlines;

    public Order(int order_id, User user, List orderlines, int total_price) {
        this.order_id = order_id;
        this.user = user;
        this.orderlines = orderlines;
        this.total_price = total_price;

    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setOrderlines(List<Orderline> orderlines) {
        this.orderlines = orderlines;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public int getOrder_id() {
        return order_id;
    }

    public User getUser() {
        return user;
    }

    public List<Orderline> getOrderlines() {
        return orderlines;
    }

    public int getTotal_price() {
        return total_price;
    }
    int total_price;

}