/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servletter;

import Data.Connector;
import Mapper.*;
import entities.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author GertLehmann
 */
@WebServlet(name = "Login_Registration", urlPatterns = {"/Login_Registration"})
public class Login_Registration extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String loginSite = request.getParameter("login");
        String logoutSite = request.getParameter("logout");

        UserMapper um = UserMapper.createUserMapper();
        CupcakeMapper cm = CupcakeMapper.createCupcakeMapper();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (logoutSite.equals("true")) {
            Connector.closeConnection();
            request.getRequestDispatcher("index.jsp")
                    .forward(request, response);
        }
        if (loginSite.equals("true")) {

            User loggedInUser = um.getUserByName(username);

            if (loggedInUser == null) {
                request.getRequestDispatcher("Errorpages/login_error.jsp")
                        .forward(request, response);

            } else if (!loggedInUser.getPassword().equals(password)) {
                request.getRequestDispatcher("Errorpages/login_error.jsp")
                        .forward(request, response);
            } else if (loggedInUser.getName().equals("")) {
                request.getRequestDispatcher("Errorpages/login_error.jsp")
                        .forward(request, response);
            } else {
                ArrayList<Topping> toppingList = (ArrayList) (cm.getListOfTops());
                ArrayList<Bottom> bottomList = (ArrayList) (cm.getListOfBots());
                ShoppingCart shopCart = ShoppingCart.createShoppingCart();
 
                HttpSession session = request.getSession();
                session.setAttribute("user", loggedInUser);
                session.setAttribute("toppingList", toppingList);
                session.setAttribute("bottomList", bottomList);
                session.setAttribute("shopCart", shopCart);

                boolean admin = loggedInUser.isAdmin();
                if (admin) {
                    request.getRequestDispatcher("adminPage.jsp").forward(request, response);

                } else {
                    request.getRequestDispatcher("shopCart.jsp").forward(request, response);

                }

            }

        } else {

            User testNameUser = um.getUserByName(username);

            if (testNameUser.getUser_id() != 0) {
                request.getRequestDispatcher("Errorpages/error_user_exist.jsp")
                        .forward(request, response);
            } else {
                String balanceText = request.getParameter("balance");
                
                String email = request.getParameter("email");
                String role = request.getParameter("role");
                
                if (username.equals("") | password.equals("") 
                        | balanceText.equals("") | email.equals("")) {
                     request.getRequestDispatcher("Errorpages/error_fill_all.jsp")
                        .forward(request, response);
                }
             
                double balance = Double.parseDouble(balanceText);
                boolean admin = false;
                if (role.equals("admin")) {
                    admin = true;
                }

                User newUser = null;
                newUser = newUser.createUser(username, password, balance, email, admin);
                
                try {
                    um.putUser(newUser);
                    request.getRequestDispatcher("register_completed.jsp")
                            .forward(request, response);

                } catch (SQLException ex) {
                    request.getRequestDispatcher("Errorpages/error_not_registered.jsp")
                            .forward(request, response);

                }

            }

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
