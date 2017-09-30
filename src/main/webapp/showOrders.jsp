<%-- 
    Document   : showOrders
    Created on : 24-09-2017, 12:24:36
    Author     : GertLehmann
--%>

<%@page import="Servletter.ViewGenerator"%>
<%@page import="entities.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orders by User - CupCake4Life.dk</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>

    </head>
    <body style="background-color: #D2691E">
        <div id="include">
        <%@ include file = "topMenu.jsp" %>
        </div>

        <div id="ordersFrame">
            <%
                User user = (User) (session.getAttribute("user"));
                boolean admin = user.isAdmin();%>

            <%if (admin) {%>

            <h2>Previous Orders by All Customers:</h2>

            <div class="container">
                <div class="col-sm-12" id="orderPrevBtn">
                    <button id="sortuser" type="button" class="btn btn-danger btn-lg btn-block"">Sort by User.</button>
                </div>
            </div>

            <div class="container">
                <div class="col-sm-12" id="orderPrevBtn">
                    <button id="sortdate" type="button" class="btn btn-success btn-lg btn-block">Sort by Date.</button>
                </div>
            </div>
            <br>
            <table class="table table-center table-striped" id="ordertable">
                <thead>
                    <tr>
                        <th>Order ID.</th>
                        <th>User</th>
                        <th>Details</th>
                        <th>Date</th>
                    </tr>
                </thead>

                <%=ViewGenerator.viewAllOrders()%>
                <%--
                <%=ViewGenerator.viewAllOrders()%>
                --%>
            </table>

            <br>

            <%} else {%>   

            <h2>Previous Orders by Customer: <%=user.getName()%>  </h2>
            <table class="table table-center table-striped">
                <thead>
                    <tr>
                        <th>Order ID.</th>
                        <th>Details</th>
                        <th>Date</th>
                    </tr>
                </thead>

                <%=ViewGenerator.viewOrdersByUser(user)%>

            </table>           

            <br>
            <%}%>   


        </div>


        <%-- 
      <script src="script/script.js" type="text/javascript"></script>  
        --%>
        <script src="script/sort_script.js" type="text/javascript"></script>
    </body>
</html>
