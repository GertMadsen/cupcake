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
        <title>JSP Page</title>
        
        
        <link rel="stylesheet" type="text/css" href="../css/style.css">
    </head>
    <body id ="wholebody">
        <div id="outernav">
         <ul id="nav">
            <li><a href="../login.jsp">Login</a></li>
            <li><a href="../index.html">Index</a></li>
          </ul> 
        </div>
        
        <div id="wholeForm">
            <h1>Register new user:</h1>

            <form action="../Login_Registration">       
                <b>Username:</b><br>
                <input type="text" name="username" value=""><br><br>
                <b>Password:</b><br>
                <input type="password" name="password" value=""><br><br>
                <b>Balance:</b><br>
                <input type="text" name="balance" value=""><br><br>
                <b>Email:</b><br>
                <input type="text" name="email" value=""><br><br>
                <input type="checkbox" name="administrator" value="admin" disabled="disabled" />
                <input type="hidden" name="login" value="false">

                <b>User: </b>
                <input type="radio" name="role" value="user" checked="checked" />

                <b>    Admin: </b>
                <input type="radio" name="role" value="admin" />
                <br><br>
                <input type="submit" name="submit" value="Register">

            </form>
            <br>

            <form method="get" action="../login.jsp">
                <button type="submit">Go back to Login</button>
            </form>

            
        </div>
        <div id="picture">
            <img src="../cupcakes.jpg" width="370" height="195" alt="cupcakes"/>
        </div>
    </body>
</html>
