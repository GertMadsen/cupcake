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
        <title>CUPCAKE4LIFE</title>
    </head>
    <body>
        <h1>HELLO CUPCAKE LOVERS!!!</h1>

        <form action="CheckLogin" method="POST">  
            <b>Username:</b><br>
            <input type="text" name="username" value=""><br><br>
            <b>Password:</b><br>
            <input type="password" name="password" value=""><br><br>

            <input type="submit" name="submit" value="Login">
        </form>

        <br>
        
        <form method="post" action="registration.jsp">
            <button type="submit">Register new user</button>
        </form>
        
        <br>
        
        <form method="get" action="index.html">
            <button type="submit">Go to index</button>
        </form>

    </body>
</html>
