<%-- 
    Document   : invoice
    Created on : Sep 21, 2017, 1:46:19 PM
    Author     : Christian
--%>

<%@page import="entities.Order"%>
<%@page import="java.util.List"%>
<%@page import="Mapper.OrderMapper"%>
<%@page import="entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! her er invoice</h1>
        <%
            User user = (User) (session.getAttribute("user"));
            String username = user.getName();
            double balance = user.getBalance();
            OrderMapper om = new OrderMapper();
            List<Order> orderList = 
                    om.getOrdersByUserId(user);
                    
        %>
        <div class='brugerP'>
            Hello <%=username%> - your balance is : <%=balance%>
        </div>
        
        <br>
        
        <div class='brugerP'>
            Hello <%=username%> - here are your previous orders : 
            <%=orderList%>
        </div>
        
        <br>
        
        <div class='brugerP'>
            Hello <%=username%> - orders vs. 2 : 
            <%=orderList%>
        </div>
        
        
        
        <br>
        <form method="get" action="index.html">
            <button type="submit">Go to index</button>
        </form>
    </body>
</html>
