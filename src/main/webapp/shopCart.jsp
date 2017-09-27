<%-- 
    Document   : shopCart
    Created on : 21-09-2017, 09:27:31
    Author     : Strom
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
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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
        <h1>Welcome to Cupcake4life.dk</h1>

        <%
            User user = (User) (session.getAttribute("user"));
            String username = user.getName();
            double balance = user.getBalance();
            ArrayList<Topping> toppingList = (ArrayList) (session.getAttribute("toppingList"));
            ArrayList<Bottom> bottomList = (ArrayList) (session.getAttribute("bottomList"));
            ArrayList<Orderline> orderlineList = (ArrayList) (session.getAttribute("orderLines"));
            double totalPrice = (double) (session.getAttribute("totalPrice"));
        %>

        <div class='brugerP'>
            Customer : <b><%=username%></b> - Balance = <b><%=balance%></b><br>
        </div>
        <div class ="CShop">

            <form name="CupcakeSelect" action="GenerateOrderLine" method="get">
                <div class="DD">
                    Bottom <br>
                    <select name="bottom">
                        <%=ViewGenerator.bottomSelect(bottomList)%>
                    </select>
                </div>
                <div class="DD">
                    Topping <br>
                    <select name="topping">
                        <%=ViewGenerator.toppingSelect(toppingList)%>
                    </select>
                </div>

                <div class="DD">
                    Quantity <br>
                    <input type="text" name="quantity" value="1">
                </div>

                <input type="submit" name="submit" value="Add">


            </form>
            <br><br><br>
            <div class="CShop">
                <%=ViewGenerator.linesAddedView(orderlineList)%>
                <h3>Total price : <%=totalPrice%></h3>
            </div>

            <div class="logout">
                <form method="get" action="GenerateOrder">
                    <input type="submit" name="submit" value="Finish Order">
                </form>
            </div>

            <div class="logout">
                <form method="get" action="Subpages/showOrders.jsp">
                    <input type="submit" name="submit" value="Show Previous Orders">
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
