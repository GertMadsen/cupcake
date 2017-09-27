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
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <%@ include file = "topMenu.jsp" %>

        <div>
            <h1>Not enough cash!!</h1>

            <h3>You do not have enough cash for this order. 
                <br>Go back to Shopping Cart and make a new order.</h3><br>

            <br>
            <form method="get" action="Subpages/shopCart.jsp">
                <button type="submit">Go back to Shopping Cart</button>
            </form>


        </div>


        <%

            ArrayList<Orderline> orderLines = new ArrayList();
            double totalPrice = 0;
            session.setAttribute("orderLines", orderLines);
            session.setAttribute("totalPrice", totalPrice);

        %>
    </body>
</html>
