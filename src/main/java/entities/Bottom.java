/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *  This class is an entity which is used to make a cupcake combined with the entity Topping.
 *  It's methods are pretty standard  set/get methods with the one exeptions that is has a method,
 *  that creates a new object of a Bottom.
 * 
 * @author Strom
 */
public class Bottom {
    
    private int id;
    private String name;
    private double price;
    
    
    public Bottom (int id){
        this.id = id;
        //this.name = name;
        //this.price = price;     
    }
    
    public static Bottom createBottom(int id) {
        Bottom bottom = new Bottom(id);
        return bottom;
    }
    
    
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Bottom{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
    }
    

    
}
