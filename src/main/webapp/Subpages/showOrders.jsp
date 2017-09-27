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
         
        <% 
            User user = (User) (session.getAttribute("user")); 
            boolean admin = user.isAdmin();%>
            
        
        <%if (admin) {%>
        
          <%=ViewGenerator.viewAllOrders()%>
          
         <%} else {%>   
        
        <%=ViewGenerator.viewOrdersByUser(user)%>
        
        <%}%>   
        
        
        <%if (!admin) {%>
            <div class="logout">
            <form method="get" action="shopCart.jsp">
                <button type="submit">Go back to Shopping Cart</button>
            </form>
            </div>
            
            <br>
         <%}%>   

        
    </body>
</html>
