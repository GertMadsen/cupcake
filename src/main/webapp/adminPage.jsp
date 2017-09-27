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
        <title>Shopping Cart - CupCake4Life.dk</title>

        <style>
            .CShop {
                margin-left: 5px;
            }
            .DD{
                float: left; 
                width: 150px;
                height: 75px;
                margin-left: 5px;
                margin-bottom: 5px;
            }
            input[type=text] {
                width: 80%;
            }
            .logout {
                margin-top: 15px;
                margin-left: 5px;
            }
            .brugerP{
                margin-left: 10px;
                margin-bottom: 25px;
            }
            input[type=submit] {
                margin-top: 15px;
            }
            .checkout{
                margin-left: 475px;
                margin-top: 100px;
            }


        </style>

    </head>
    <body>
        <h1>Welcome to the Admin Page</h1>

        <%
            User user = (User) (session.getAttribute("user"));
            String username = user.getName();
            
        %>
  
        <div class='brugerP'>
            Admin : <b><%=username%></b> <br>
        </div>
        <div class ="CShop">

            


            <div class="logout">
                <form method="get" action="Subpages/showOrders.jsp">
                    <input type="submit" name="submit" value="Show All Orders">
                </form>
            </div>

            <div class="logout">
                <form method="get" action="login.jsp">
                    <input type="submit" name="submit" value="Log Out">
                </form>
            </div>

        </div>

    </body>
</html>

