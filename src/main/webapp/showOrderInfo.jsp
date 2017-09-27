<%-- 
    Document   : ShowOrderInfo
    Created on : 24-09-2017, 12:24:59
    Author     : GertLehmann
--%>

<%@page import="Servletter.ViewGenerator"%>
<%@page import="entities.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Info - CupCake4Life.dk</title>
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

        <div id="ordersFrame">

            <h1>Order Specification: </h1>

            <%  String oid = request.getParameter("orderId");
                int orderId = Integer.parseInt(oid);
                User user = (User) (session.getAttribute("user"));
                boolean admin = user.isAdmin();%>
  
                
            <%=ViewGenerator.viewSingleOrder(orderId, admin)%>

            <div class="logout">
                <form method="get" action="showOrders.jsp">
                    <button type="submit">Go back to Show Orders</button>
                </form>
                
                <br>
                
            </div>

        </div>


    </body>
</html>
