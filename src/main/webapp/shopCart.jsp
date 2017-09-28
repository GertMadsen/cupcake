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
        <link href="css/style2.css" rel="stylesheet" type="text/css"/>

    </head>
    <body id="shopBody">
        <%@ include file = "topMenu.jsp" %>

        <%
            User user = (User) (session.getAttribute("user"));
            ArrayList<Topping> toppingList = (ArrayList) (session.getAttribute("toppingList"));
            ArrayList<Bottom> bottomList = (ArrayList) (session.getAttribute("bottomList"));
            ArrayList<Orderline> orderlineList = (ArrayList) (session.getAttribute("orderLines"));
            double totalPrice = (double) (session.getAttribute("totalPrice"));
        %>

        
            <div id="container2" class="container d-inline border-bottom-0 " >

                <div class="col-sm-2">

                </div>


                <div class="col-sm-4 d-inline" id="shopVindue">


                    <form name="CupcakeSelect" action="GenerateOrderLine" method="get">

                        <div class="DD">
                            <div class="text-center" id="textColor">  
                                <p class="font-weight-bold" ><h3>Bottom</h3></p> 
                            </div>

                            <select class="btn dropdown-toggle" id="bottomBtn" name="bottom">
                                <%=ViewGenerator.bottomSelect(bottomList)%>
                            </select>
                        </div>
                        <div class="DD">
                            <div class="text-center" id="textColor"> 
                                <p class="font-weight-bold"><h3>Topping</h3></p> 
                            </div>
                            <select class="btn dropdown-toggle" id="toppingBtn" name="topping">
                                <%=ViewGenerator.toppingSelect(toppingList)%>
                            </select>
                        </div>

                        <div class="DD">
                            <div class="text-center font-weight-bold" id="textColor"> 
                                <p class="font-weight-bold" ><h3>Quantity</h3></p>  
                            </div>
                            <input class="form-control" id="qua" type="text" name="quantity" value="1">
                        </div>

                        <div id="idKnapD">
                            <input class="btn btn-success btn-lg btn-block" id="addKnap" type="submit" name="submit" value="Add">
                        </div>



                    </form>
                </div>
        </span>
        <div class="col-sm-6 pre-scrollable" id="itemsKurv">

            <% if (!orderlineList.isEmpty()) {%>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Bottom</th>
                        <th>Topping</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>SubTotal</th>
                    </tr>
                </thead>
                <tbody>

                    <%=ViewGenerator.linesAddedView(orderlineList)%>

                    <tr id="totalprice">
                        <td><h3>Total</h3></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><h3><%=totalPrice%></h3></td>
                    </tr>
                </tbody>
            </table>

            <% }%>


        </div>






    </div>
</div>



<div class="container">
    <div class="col-sm-12" id="finishBtn">
        <form method="get" action="GenerateOrder">
            <input class="btn btn-success btn-lg btn-block" type="submit" name="submit" value="Finish Order">
        </form>

    </div>
 </div>

<div class="container">
    <div class="col-sm-12" id="orderPrevBtn">
            <form method="get" action="showOrders.jsp">
                <input class="btn btn-danger btn-lg btn-block" type="submit" name="submit" value="Show Previous Orders">
            </form>
    </div>

</div>





</body>
</html>
