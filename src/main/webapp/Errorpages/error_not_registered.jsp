<%-- 
    Document   : error_reg
    Created on : 21-09-2017, 11:34:49
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
    <body id ="wholebody">
        <%@ include file = "../topMenu.jsp" %>

        <div class="picFrame">

            <div id="adminFrame"> 

                <h2>Error!</h2>

                <h3>And error occured writing to database. 
                <br>Please try register again.</h3><br>

                <form method="get" action="registration.jsp">
                    <button class="blackText" type="submit">Register new user</button>
                </form>

            </div>

        </div>
     
    </body>
</html>
