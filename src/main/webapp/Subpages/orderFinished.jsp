<%-- 
    Document   : orderFinished
    Created on : 21-09-2017, 19:34:30
    Author     : GertLehmann
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="entities.Orderline"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


        <div>
            <h1>Order Finished!</h1>

            <h2>Your cupcakes has been shipped. 
                <br>Go back to Shopping Cart or Log out.</h2><br>

            <br>
            <form method="get" action="shopCart.jsp">
                <button type="submit">Go back to Shopping Cart</button>
            </form>

            <div >
                <form method="get" action="login.jsp">
                    <input type="submit" name="submit" value="Log out">
                </form>
            </div>

        </div>


        <%

            ArrayList<Orderline> orderLines = new ArrayList();
            double totalPrice = 0;
            session.setAttribute("orderLines", orderLines);
            session.setAttribute("totalPrice", totalPrice);

        %>
    </body>
</html>
