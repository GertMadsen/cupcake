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
        <style>
            .tablehead {
                text-align: center;
            }
        </style> 
    </head>
    <body>

        <table border="0">
            <thead class="tablehead">
                <tr>
                    <th>
                        <h1>Cupcake4Life.dk</h1>
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <img src="cupcakes.jpg" width="670" height="365" alt="cupcakes"/>

                    </td>
                    <td>
                        <h3>User login:</h3>

                        <form action="Login_Registration" method="POST">  
                            <b>Username:</b><br>
                            <input type="text" name="username" value=""><br><br>
                            <b>Password:</b><br>
                            <input type="password" name="password" value=""><br><br>
                            <input type="hidden" name="login" value="true">
                            <input type="submit" name="submit" value="Login">
                        </form>

                        <br>

                        <form method="post" action="Subpages/registration.jsp">
                            <button type="submit">Register new user</button>
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>


    </body>
</html>
