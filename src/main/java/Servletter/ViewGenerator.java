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
     * This class is the "Render class" it takes alot of the work away from the jsp pages so they can look smooth.
     * This class is used in shopCart.jsp, showOrders.jsp, showOrderInfo.jsp.
     * 
     */
public class ViewGenerator {
    
   
    /**
     * @param user is an expected value and if null it would crash the application.
     * @return a list of previous orders the specific user made. if parameter is wrong their
     * will be nothing to return since it depends on the parameter to find the list.
     * 
     * This method does not change the state of any object it prints the list of the user.
     * 
     */
    
    public static String viewOrdersByUser(User user) {
        String output = "";
        OrderMapper om = OrderMapper.createOrderMapper();
        ArrayList<Order> userOrders = (ArrayList) om.getOrdersByUserId(user);
       // ArrayList<Order> userOrders = user.orderList();
        output += "<tbody>";

        for (Order o : userOrders) {
            int id = o.getOrder_id();
            output += "<tr><td>" + id + "</td>" 
                    + "<td><a href=\"showOrderInfo.jsp?orderId=" + id + "\"> View this order </a></td>"
                    + "<td>" + o.getDate() + "</td></tr>";
        }
        output += "</tbody>";
        return output;
    }
    
    public static String viewAllOrders() {

        String output = "";
        
        OrderMapper om = OrderMapper.createOrderMapper();
        
        ArrayList<Order> userOrders = (ArrayList) om.getAllOrders();
        output += "<tbody>";

        for (Order o : userOrders) {
            int id = o.getOrder_id();
            String username = o.getUser().getName();

            output += "<tr><td>" + id + "</td><td>" + username + "</td>"
                    + "<td><a href=\"showOrderInfo.jsp?orderId=" + id + "\"> View this order </a></td>"
                    + "<td>" + o.getDate() + "</td></tr>";
        }
        output += "</tbody>";
        return output;
    }

    public static String viewSingleOrder(int orderId, boolean admin) {
        String output = "";
        OrderMapper om = OrderMapper.createOrderMapper();
        
        Order orderToShow = om.getOrderById(orderId);
        ArrayList<Orderline> orderLines = (ArrayList) om.getOrderlinesByOrderId(orderToShow);
        double totalPrice = 0;

        output = "<h3>Order ID. : " + orderId + "</h3>";
        output += "Customer : <b>" + orderToShow.getUser().getName() + "</b><br>";
        if (admin) {
            output += "email : <b>" + orderToShow.getUser().getEmail() + "</b><br>";
        }
        output += "Date : <b>" + orderToShow.getDate() + "</b><br><br>";

        output += "<table class=\"table table-center table-striped\"><thead>";
        output += "<tr><th>Bottom</th><th>Topping</th><th>Price</th>";
        output += "<th>Quantity</th><th>SubTotal</th></tr></thead>";
        output += "<tbody>";
        
        for (Orderline o : orderLines) {
            Bottom bot = o.getBottom();
            Topping top = o.getTopping();
            String botName = bot.getName();
            double botPrice = bot.getPrice();
            String topName = top.getName();
            double topPrice = top.getPrice();
            double price = botPrice + topPrice;
            int quantity = o.getQuantity();
            double subPrice = o.getPrice();
            totalPrice += subPrice;

            
            
            output += "<tr><td>" + botName + "</td>" 
                    + "<td>" + topName + "</td>" 
                    + "<td>" + price + "</td>"
                    + "<td>" + quantity + "</td>" 
                    + "<td>" + subPrice + "</td> </tr>";

        }

        output += "<tr><td><h3>Total</h3></td><td></td><td></td><td></td>";
        output += "<td><h3>" + totalPrice + "</h3></td></tr>";
        output += "</tbody></table>";
        
        return output;
    }

    public static String linesAddedView(ArrayList<Orderline> orderLines) {
        String output = "";

        for (Orderline ol : orderLines) {
            double price = ol.getBottom().getPrice() + ol.getTopping().getPrice();
            output += "<tr><td>" + ol.getBottom().getName() + "</td>"
                    + "<td>" + ol.getTopping().getName() + "</td>"
                    + "<td>" + price + "</td>"
                    + "<td>" + ol.getQuantity() + "</td>"
                    + "<td>" + ol.getPrice() + "</td></tr>";

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

}
