<%-- 
    Document   : registration
    Created on : 20-09-2017, 18:06:39
    Author     : Strom
--%>

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
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body id ="wholebody">
        <%@ include file = "topMenu.jsp" %>

        <div class="picFrame">
            
            <div id="regForm">
                <h2>Register new user:</h2>

                <form action="../Login_Registration">       
                    <b>Username:</b><br>
                    <input class="blackText" type="text" name="username" value=""><br><br>
                    <b>Password:</b><br>
                    <input class="blackText" type="password" name="password" value=""><br><br>
                    <b>Balance:</b><br>
                    <input class="blackText" type="text" name="balance" value=""><br><br>
                    <b>Email:</b><br>
                    <input class="blackText" type="text" name="email" value=""><br><br>
                    <b>User: </b>
                    <input class="blackText" type="radio" name="role" value="user" checked="checked" />
                    <b>Admin: </b>
                    <input class="blackText" type="radio" name="role" value="admin" />
                    <br><br>
                    <input type="hidden" name="login" value="false">
                    <input class="blackText" type="submit" name="submit" value="Register">

                </form>
                <br>

                <form method="post" action="../index.jsp">
                    <button class="blackText" type="submit">Go back to Login</button>
                </form>

            </div>

        </div>

    </body>
</html>
