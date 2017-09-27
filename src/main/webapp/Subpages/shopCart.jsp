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
        <link href="../css/style2.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <%@ include file = "topMenu.jsp" %>

        <%
            User user = (User) (session.getAttribute("user"));
            ArrayList<Topping> toppingList = (ArrayList) (session.getAttribute("toppingList"));
            ArrayList<Bottom> bottomList = (ArrayList) (session.getAttribute("bottomList"));
            ArrayList<Orderline> orderlineList = (ArrayList) (session.getAttribute("orderLines"));
            double totalPrice = (double) (session.getAttribute("totalPrice"));
        %>


        <div id="container2" class="container" >

            <div class="col-sm-2">

            </div>

            <div class="col-sm-8" id="shopVindue">


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

                    <div id="addKnap">
                        <input type="submit" name="submit" value="Add">
                    </div>


                </form>
            </div>

            <div class="col-sm-2">

            </div>
        </div>

        <div class="container">
            <div class="col-sm-2"></div>


            <div class="col-sm-8" id="itemsKurv">
                <%=ViewGenerator.linesAddedView(orderlineList)%>
                <h3>Total price : <%=totalPrice%></h3>
            </div>
            <div class="col-sm-2"></div>
        </div>


        <div class="container">
            <div class="col-sm-10"></div>

            <div class="col-sm-2">
                <div class="logout">
                    <form method="get" action="GenerateOrder">
                        <input type="submit" name="submit" value="Finish Order">
                    </form>
                </div>

                <div class="logout">
                    <form method="get" action="showOrders.jsp">
                        <input type="submit" name="submit" value="Show Previous Orders">
                    </form>
                </div>
            </div>

        </div>



    </div>

</body>
</html>
