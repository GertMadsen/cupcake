<%-- 
    Document   : error_writingOrder
    Created on : 21-09-2017, 19:52:49
    Author     : GertLehmann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page - CupCake4Life.dk</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <%@ include file = "../topMenu.jsp" %>
            <h2>Error!</h2>
            

            <h3>The order was not registered in the database. 
                <br>Please try making the order again.</h3><br>

            <form method="get" action="shopCart.jsp">
                <button type="submit">Go to Shopping Cart</button>
            </form>
    </body>
</html>
