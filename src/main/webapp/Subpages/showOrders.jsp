<%-- 
    Document   : showOrders
    Created on : 24-09-2017, 12:24:36
    Author     : GertLehmann
--%>

<%@page import="Servletter.ViewGenerator"%>
<%@page import="entities.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orders by User - CupCake4Life.dk</title>
        <style>
            .logout {
                margin-top: 15px;
                margin-left: 5px;
            }
        </style>
    </head>
    <body>
        <% User user = (User) (session.getAttribute("user")); %>

        <h1>Previous Orders by Customer:</h1>
        
        Customer : <b><%=user.getName()%></b><br><br>
        
       
        <%=ViewGenerator.viewOrdersByUser(user)%>
        
            <div class="logout">
            <form method="get" action="../shopCart.jsp">
                <button type="submit">Go back to Shopping Cart</button>
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
