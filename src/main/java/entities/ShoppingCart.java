/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;

public class ShoppingCart {
    
    ArrayList<Orderline> Orderlines;
    double total_price;

    public ShoppingCart() {
        this.Orderlines = new ArrayList();
        this.total_price = 0;
    }    
    
    public static ShoppingCart createShoppingCart() {
        ShoppingCart newCart = new ShoppingCart();
        return newCart;
    }
    
    
    public ArrayList<Orderline> getOrderlines() {
        return Orderlines;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
    
    public void addToOrderlines(Orderline orderline) {
        this.Orderlines.add(orderline);
    }
    
    public boolean isEmpty() {
        return Orderlines.isEmpty();
    }
    
}
