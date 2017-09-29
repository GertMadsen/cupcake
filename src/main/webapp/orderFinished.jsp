<%-- 
    Document   : orderFinished
    Created on : 21-09-2017, 19:34:30
    Author     : GertLehmann
--%>
<%@page import="Servletter.ViewGenerator"%>
<%@page import="entities.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Finished - CupCake4Life.dk</title>

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>

    </head>
    <body style="background-color: #D2691E">
        <%@ include file = "topMenu.jsp" %>
        <%
            ArrayList<Orderline> orderlineList = (ArrayList) (session.getAttribute("orderLines"));
            double totalPrice = (double) (session.getAttribute("totalPrice"));
            User user = (User) (session.getAttribute("user"));
            Order newOrder = (Order) request.getAttribute("newOrder");
        %>

        <div id="ordersFrame">
            <h1>Order Finished!</h1>
            Your cupcakes has been shipped. Thanks for shopping at our webshop.<br>

            <h3>Order number : <%=newOrder.getOrder_id()%></h3>

            Customer : <b><%=user.getName()%></b>
            <br>Date : <b><%=newOrder.getDate()%></b><br>

            <table class="table table-center table-striped">
                <thead>
                    <tr>
                        <th>Bottom</th>
                        <th>Topping</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>SubTotal</th>
                    </tr>
                </thead>
                <tbody>

                    <%=ViewGenerator.linesAddedView(orderlineList)%>  

                    <tr>
                        <td><h3>Total</h3></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><h3><%=totalPrice%></h3></td>
                    </tr>

                </tbody>
            </table>

        </div>

        <%
            ArrayList<Orderline> orderLines = new ArrayList();
            totalPrice = 0;
            session.setAttribute("orderLines", orderLines);
            session.setAttribute("totalPrice", totalPrice);

        %>

    </body>
</html>
