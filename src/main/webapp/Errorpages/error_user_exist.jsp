<%-- 
    Document   : error_user_exist
    Created on : 21-09-2017, 14:01:54
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

                <% String username = request.getParameter("username");%>

               Registration not completed
                <h3><%=username%></h3> is already used by another user. 
                    Please choose another username in order to complete user registration.<br><br>


                <form method="get" action="registration.jsp">
                    <button class="blackText" type="submit">Register new user</button>
                </form>
                <br>

            </div>

        </div> 

    </body>
</html>
