<%-- 
    Document   : adminPage
    Created on : 27-09-2017, 14:45:54
    Author     : GertLehmann
--%>

<%@page import="Servletter.ViewGenerator"%>
<%@page import="entities.Orderline"%>
<%@page import="entities.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page - CupCake4Life.dk</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>

    <body id ="wholebody">
        <%@ include file = "topMenu.jsp" %>

        <div class="picFrame">
        
            <div id="adminFrame"> 

                <h2>Admin Page:</h2>
                
                <br>Click on buttom below to see all the orders 
                submitted by the different customers.<br><br>
                Furthermore you will be able to view details
                about every single order such as customer name
                and email.

                <div class="logout">
                    <form method="get" action="Subpages/showOrders.jsp">
                        <input class="blackText" type="submit" name="submit" value="Show All Orders">
                    </form>
                </div>

            </div>

       </div>

    </body>
</html>

