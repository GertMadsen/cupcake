/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *  This class is an entity of Orderline.
 *  The Orderline is used to create an order which is "filled" by orderlines
 *  It's methods are pretty standard set/get methods
 *  
 * @author Mikkel Lindstrøm <Mikkel.Lindstrøm>
 */


public class Orderline {
    
    private int id;
    private Bottom bottom;
    private Topping topping;
    private int quantity;
    private double price;

    public Orderline(Bottom bottom, Topping topping, int quantity, double price) {
        //this.id = id;
        this.bottom = bottom;
        this.topping = topping;
        this.quantity = quantity;
        this.price = price;
    }
    
    public static Orderline createOrderline(Bottom bottom, Topping topping, int quantity, double price) {
        Orderline orderline = new Orderline(bottom, topping, quantity, price);
        return orderline;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    public void setBottom(Bottom bottom) {
        this.bottom = bottom;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public Bottom getBottom() {
        return bottom;
    }

    public Topping getTopping() {
        return topping;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Orderline{" + "id=" + id + ", bottom=" + bottom + ", topping=" + topping + ", quantity=" + quantity + ", price=" + price + '}';
    }
    
}
