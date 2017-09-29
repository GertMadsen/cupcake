<%-- 
    Document   : notEnoughMoney
    Created on : 21-09-2017, 21:42:37
    Author     : GertLehmann
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="entities.Orderline"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Not Enough Money - CupCake4Life.dk</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>

    </head>
    <body id="wholebody">
        <%@ include file = "topMenu.jsp" %>

        <div class="picFrame">

            <div id="adminFrame"> 

                <h2>Order Error!</h2>
                No order was submitted.<br>
                <h3>Not enough cash.</h3> 
                You do not have enough cash for this order.
                Go back to Shopping Cart and make a new order..

                <br><br><br>
                
                <form method="get" action="shopCart.jsp">
                    <button class="blackText" type="submit">Go back to Shopping Cart</button>
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
