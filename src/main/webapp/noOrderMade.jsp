<%-- 
    Document   : noOrderMade
    Created on : 21-09-2017, 19:51:14
    Author     : GertLehmann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>No Order Made - CupCake4Life.dk</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <%@ include file = "topMenu.jsp" %>

        <div>
            <h1>No cupcakes!</h1>

            <h3>No cupcakes where added to Shopping Cart. 
                <br>Select some cupcakes before checking out.</h3><br>

            <br>
            <form method="get" action="shopCart.jsp">
                <button type="submit">Go back to Shopping Cart</button>
            </form>

        </div>
    </body>
</html>
