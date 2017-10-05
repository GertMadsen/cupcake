/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servletter;

import Mapper.*;
import entities.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This class is called from shopCart.jsp.
 * It can send the user to some errorpages if anything goes wrong:
 * notEnoughMoney.jsp, error_writing_order.jsp, noOrderMade.jsp.
 * If the order is a success it sends the user to: orderFinished.jsp.
 * 
 * @author GertLehmann
 */
@WebServlet(name = "GenerateOrder", urlPatterns = {"/GenerateOrder"})
public class GenerateOrder extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        ShoppingCart shopCart = (ShoppingCart) (session.getAttribute("shopCart"));
        double totalPrice = shopCart.getTotal_price();
        User user = (User) (session.getAttribute("user"));

        //UserMapper um = new UserMapper();
        UserMapper um = UserMapper.createUserMapper();
        OrderMapper om = OrderMapper.createOrderMapper();

        if (!shopCart.isEmpty()) {

            if (user.getBalance() < totalPrice) {
               request.getRequestDispatcher("notEnoughMoney.jsp")
                            .forward(request, response); 
            } else {

                Order newOrder = Order.createOrder(user);
                int orderNumber = 0;
                try {
                    orderNumber = om.putToOrderTable(newOrder);
                } catch (SQLException ex) {
                    request.getRequestDispatcher("Errorpages/error_writing_order.jsp")
                            .forward(request, response);
                }
                
                newOrder = om.getInitOrderById(orderNumber);
                request.setAttribute("newOrder", newOrder);
                
                for (Orderline ol : shopCart.getOrderlines()) {
                    int orderlineNumber = 0;
                    try {
                        orderlineNumber = om.putToOrderLineTable(ol);
                    } catch (SQLException ex) {
                        request.getRequestDispatcher("Errorpages/error_writing_order.jsp")
                                .forward(request, response);
                    }

                    try {
                        om.putToOrderdetailsTable(orderNumber, orderlineNumber, ol.getQuantity());
                    } catch (SQLException ex) {
                        request.getRequestDispatcher("Errorpages/error_writing_order.jsp")
                                .forward(request, response);
                    }
                }

                double newBalance = user.getBalance() - totalPrice;

                try {
                    um.updateUserBalanceById(user, newBalance);
                } catch (SQLException ex) {
                    request.getRequestDispatcher("Errorpages/error_writing_order.jsp")
                            .forward(request, response);
                }

                request.getRequestDispatcher("orderFinished.jsp")
                        .forward(request, response);
            }

        } else {
            request.getRequestDispatcher("noOrderMade.jsp")
                    .forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
