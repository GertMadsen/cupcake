/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servletter;

import Mapper.*;
import entities.*;
import java.util.ArrayList;

/**
 *
 * @author GertLehmann
 */
public class ViewGenerator {

    public static String viewOrdersByUser(User user) {
        String output = "";
        OrderMapper om = new OrderMapper();
        ArrayList<Order> userOrders = (ArrayList) om.getOrdersByUserId(user);
 
        output += "<h1>Previous Orders by Customer:</h1>";
        output += "<h3>Customer : "+user.getName()+"</h3>";
        
        for (Order o : userOrders) {
            int id = o.getOrder_id();
            output += "Order no. : " + id 
                    + " - <a href=\"showOrderInfo.jsp?orderId="+id+"\"> View this order </a>" 
                    + " - Date : " + o.getDate() + "<br>";
        }

        return output;
    }

        public static String viewAllOrders() {

      
        String output = "";
        OrderMapper om = new OrderMapper();
        ArrayList<Order> userOrders = (ArrayList) om.getAllOrders();
        output += "<h1>Previous Orders by All Customers:</h1>";
        
        for (Order o : userOrders) {
            int id = o.getOrder_id();
            String username = o.getUser().getName();
            
            output += "Order no. : " + id + " by User : " + username  
                    + " - <a href=\"Subpages/showOrderInfo.jsp?orderId="+id+"\"> View this order </a>" 
                    + " - Date : " + o.getDate() + "<br>";
        }

        return output;
    }
    
        
        
    public static String viewSingleOrder(int orderId, boolean admin) {
        String output = "";
        OrderMapper om = new OrderMapper();
        Order orderToShow = om.getOrderById(orderId);
        ArrayList<Orderline> orderLines = (ArrayList) om.getOrderlinesByOrderId(orderToShow);
        double totalPrice = 0;

        output = "<h3>Order no. : " + orderId + "</h3>";
        output += "Customer : <b>" + orderToShow.getUser().getName() + "</b><br>";
        if (admin) {
            output += "email : <b>" + orderToShow.getUser().getEmail() + "</b><br>";
        }
        output += "Date : <b>" + orderToShow.getDate() + "</b><br><br>";
        
        for (Orderline o : orderLines) {
            Bottom bot = o.getBottom();
            Topping top = o.getTopping();
            String botName = bot.getName();
            double botPrice = bot.getPrice();
            String topName = top.getName();
            double topPrice = top.getPrice();
            double price = botPrice+topPrice;
            int quantity = o.getQuantity();
            double subPrice = o.getPrice();
            totalPrice += subPrice;

            output += "Bottom : <b>" + botName + "</b> a <b>" + botPrice
                    + "</b> - Topping : <b>" + topName + "</b> a <b>" + topPrice
                    + "</b> - Price : <b>" + price
                    + "</b> - Quantity : <b>" + quantity + "</b> - SubTotal : <b>" + subPrice + "</b><br>";

        }

        output += "<br><h3>Total price : " + totalPrice + "</h3>";

        return output;
    }

    public static String linesAddedView(ArrayList<Orderline> orderLines) {
        String output = "";

        for (Orderline ol : orderLines) {
            double price = ol.getBottom().getPrice()+ol.getTopping().getPrice();
            output += "Bottom = <b>" + ol.getBottom().getName() + "</b> - "
                    + "Topping = <b>" + ol.getTopping().getName() + "</b> - "
                    + "Price = <b>" + price + "</b> - "
                    + "Quantity = <b>" + ol.getQuantity() + "</b> - "
                    + "SubTotal = <b>" + ol.getPrice() + "</b><br>";

        }

        return output;
    }

    public static String bottomSelect(ArrayList<Bottom> bottomList) {
        String output = "";
        int i = 1;
        for (Bottom bot : bottomList) {
            output += "<option value=" + i + ">" + bot.getName() + " -> " + bot.getPrice() + " </option>";
            i++;
        }
        return output;
    }
 
    public static String toppingSelect(ArrayList<Topping> toppingList) {
        String output = "";
        int i = 1;
        for (Topping top : toppingList) {
            output += "<option value=" + i + ">" + top.getName() + " -> " + top.getPrice() + " </option>";
            i++;
        }
        return output;
    }
 

    
    public static void main(String[] args) {
        UserMapper um = new UserMapper();
        User testUser = um.getUserByID(1);

        String toShow = viewOrdersByUser(testUser);
        System.out.println(toShow);

//        String toShow2 = viewSingleOrder(1);
//        System.out.println(toShow2);

    }

}
