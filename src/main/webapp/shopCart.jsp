<%-- 
    Document   : shopCart
    Created on : 21-09-2017, 09:27:31
    Author     : Strom
--%>

<%@page import="entities.Orderline"%>
<%@page import="entities.Bottom"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Topping"%>
<%@page import="java.util.List"%>
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
            }
            .brugerP{
                margin-left: 10px;
                margin-bottom: 10px;
            }
            input[type=submit] {
                margin-top: 15px;
            }
            .checkout{
                margin-left: 475px;
                margin-top: 300px;
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

        <%
            ArrayList<Topping> toppingList = (ArrayList) (session.getAttribute("toppingList"));
            ArrayList<Bottom> bottomList = (ArrayList) (session.getAttribute("bottomList"));
            ArrayList<Orderline> orderlineList = (ArrayList) (session.getAttribute("orderLines"));
        %>



        <div class ="CShop">

            <form name="CupcakeSelect" action="GenerateOrderLine" method="get">
                <div class="DD">
                    Bottom <br>
                    <select name="bottom">
                        <% for (int b = 0; b < bottomList.size(); b++) {
                                String navn = bottomList.get(b).getName() + "  " + Double.toString(bottomList.get(b).getPrice());

                                out.println("<option value=" + (b + 1) + ">" + navn + " </option>");

                            }
                        %>
                    </select>
                </div>
                <div class="DD">
                    Topping <br>
                    <select name="topping">
                        <% for (int t = 0; t < toppingList.size(); t++) {
                                String navn = toppingList.get(t).getName() + "  " + Double.toString(toppingList.get(t).getPrice());

                                out.println("<option value=" + (t + 1) + ">" + navn + " </option>");

                            }
                        %>
                    </select>
                </div>

                <div class="DD">
                    Quantity <br>
                    <input type="text" name="quantity" value="0">
                </div>

                <input type="submit" name="submit" value="Add">

            <div class="CShop">
                <br>
                <% for (Orderline ol : orderlineList) { %>
                Bottom = <%=ol.getBottom().getName() %> * 
                Topping = <%=ol.getTopping().getName()%> * 
                Quantity = <%=ol.getQuantity()%> * 
                Price = <%=ol.getPrice()%>
                <br>
                <% } %>
            </div>
                
                <div class='checkout'>
                    
                    
                    <input type="submit" name="submit" value="CheckOut">
                </div>


            </form>

            <div class="logout">
                <form method="get" action="login.jsp">
                    <button type="submit">Logout</button>
                </form>
            </div>
            
            <br>
            
            <div class="invoice">
                <form method="get" action="customerPage.jsp">
                    <button type="submit">to to customerPage</button>
                </form>
            </div>
            
        </div>



    </body>
</html>
