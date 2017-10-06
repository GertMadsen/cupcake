package Servletter;

import Mapper.CupcakeMapper;
import entities.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This class generates orderlines to the future order from shopCart.jsp and then redirects back to the same page,
 * but now with an orderline attached to the page. The order is yet to be made, but will be created when your done
 * adding orderlines.
 * 
 * @author GertLehmann
 */
@WebServlet(name = "GenerateOrderLine", urlPatterns = {"/GenerateOrderLine"})
public class GenerateOrderLine extends HttpServlet {

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

        HttpSession session = request.getSession();
        ShoppingCart shopCart = (ShoppingCart) (session.getAttribute("shopCart"));
        double totalPrice = shopCart.getTotal_price();
        
        int bottomID = Integer.parseInt(request.getParameter("bottom"));
        int toppingID = Integer.parseInt(request.getParameter("topping"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        //CupcakeMapper cm = new CupcakeMapper();
        CupcakeMapper cm = CupcakeMapper.createCupcakeMapper();
        
        Bottom bottom = cm.getBottomByBottomId(bottomID);
        Topping topping = cm.getToppingByToppingId(toppingID);
        double price = (bottom.getPrice() + topping.getPrice())*(double)(quantity);
        totalPrice += price;
        
        Orderline newLine = Orderline.createOrderline(bottom,topping,quantity,price);
        shopCart.addToOrderlines(newLine);
        shopCart.setTotal_price(totalPrice);
        session.setAttribute("shopCart",shopCart);
        
        request.getRequestDispatcher("shopCart.jsp").forward(request, response);
        
                
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
