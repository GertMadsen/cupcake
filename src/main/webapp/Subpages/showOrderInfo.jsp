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
        <style>
            .logout {
                margin-top: 15px;
                margin-left: 5px;
            }
        </style>
    </head>
    <body>
        <h1>Order Specification: </h1>
        
        <%  String oid = request.getParameter("orderId");
            int orderId = Integer.parseInt(oid);
            User user = (User) (session.getAttribute("user"));
            boolean admin = user.isAdmin(); %>
            
        <%=ViewGenerator.viewSingleOrder(orderId,admin)%>

        <div class="logout">
            <form method="get" action="showOrders.jsp">
                <button type="submit">Go back to Show Orders</button>
            </form>
        </div>

        <br>

        <div class="logout">
            <form method="get" action="../login.jsp">
                <input type="submit" name="submit" value="Log Out">
            </form>
        </div>

    </body>
</html>
