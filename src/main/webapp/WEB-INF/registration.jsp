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
    </head>
    <body>
        <h1>Hello cupcake monsters!</h1>
        
         <form action="AddUserServlet">       
            <b>Username:</b><br>
            <input type="text" name="username" value=""><br><br>
            <b>Password:</b><br>
            <input type="password" name="password" value=""><br><br>
            <b>Balance:</b><br>
            <input type="text" name="balance" value=""><br><br>
            <b>Email:</b><br>
            <input type="text" name="email" value=""><br><br>
            
            <input type="submit" name="submit" value="Register">
        </form>
        
        
        
        
    </body>
</html>
