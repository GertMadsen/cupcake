<%-- 
    Document   : shopCart
    Created on : 21-09-2017, 09:27:31
    Author     : Strom
--%>

<%@page import="entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

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
                margin-left: 1200px;
                margin-top: 350px; 
            }
            .brugerP{
                margin-left: 10px;
                margin-bottom: 10px;
            }



        </style>

    </head>
    <body>
        <h1>Welcome to the Cupcake shop</h1>

        <%
            User user = (User) (session.getAttribute("user"));
            String username = user.getName();
            double balance = user.getBalance();
        %>
        <div class='brugerP'>
            Hello <%=username%> - your balance is : <%=balance%>
        </div>


        <div class ="CShop">
     
            <form name="CupcakeSelect" action="GenerateOrderLine" method="POST">
                <div class="DD">
                    Bottom <br>
                    <select name="mydropdown">
                        <option value="1">Fresh Milk</option>
                        <option value="2">Old Cheese</option>
                        <option value="3">Hot Bread</option>
                    </select>
                </div>
                <div class="DD">
                    Topping <br>
                    <select name="mydropdown">
                        <option value="1">Fresh Milk</option>
                        <option value="2">Old Cheese</option>
                        <option value="3">Hot Bread</option>
                    </select>
                </div>


                <div class="DD">
                    Quantity <br>
                    <input type="text" name="quantity" value="">
                </div>

                <input type="submit" name="submit" value="Add">
            </form>


                      

            <div class="logout">
                <form method="get" action="login.jsp">
                    <button type="submit">Logout</button>
                </form>
            </div>

        </div>



    </body>
</html>