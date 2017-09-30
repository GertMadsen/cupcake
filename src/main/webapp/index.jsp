<%-- 
    Document   : login
    Created on : 20-09-2017, 18:13:11
    Author     : Strom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page - CupCake4Life.dk</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body id ="wholebody">
        <%  session.setAttribute("user", null); %>
        <%@ include file = "topMenu.jsp" %>

        <div class="picFrame">

            <div id="loginForm">    
                <h2>User login:</h2>

                <form action="Login_Registration" method="POST">  
                    <b>Username:</b><br>
                    <input class="blackText" type="text" name="username" value=""><br><br>
                    <b>Password:</b><br>
                    <input class="blackText" type="password" name="password" value=""><br><br>
                    <input type="hidden" name="login" value="true">
                    <input type="hidden" name="logout" value="false">
                    <input class="blackText" type="submit" name="submit" value="Login">
                </form>

                <br>

                <form method="post" action="registration.jsp">
                    <button class="blackText" type="submit">Register new user</button>
                </form>

            </div>

        </div>



    </body>
</html>
