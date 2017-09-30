<%-- 
    Document   : topMenu
    Created on : 27-09-2017, 17:45:43
    Author     : GertLehmann
--%>

<%@page import="entities.User"%>
<%
    User topUser = (User) (session.getAttribute("user"));
    String topName = "";
    double topBalance = 0;
    if (topUser != null) {
        topName = topUser.getName();
        topBalance = topUser.getBalance();
    }
%>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <ul class="nav navbar-nav">
            <li style="font-size: 24px" id="cc4l" class="navbar-text">CupCake4life.dk</li>
        <% if (topUser != null) {%>
                <% if (!topUser.isAdmin()) {%>
            <li><a href="shopCart.jsp">Shopping Cart</a></li>
                <% } %>
            <li><a href="showOrders.jsp">Show Orders</a></li>
        <% }%>
        </ul>

        <% if (topUser != null) {%>

        <ul class="nav navbar-nav navbar-right">
            <li class="navbar-text">Logged in as : <%=topName%></li>
                <% if (!topUser.isAdmin()) {%>
            <li class="navbar-text">Your balance is : <%=topBalance%></li>
                <% } else { %>
            <li class="navbar-text">(Administrator)</li>
                <% } %>
            <li class="navbar-text"><form action="Login_Registration" method="POST">  
                    <input type="hidden" name="logout" value="true">
                    <input class="blackText" type="submit" name="submit" value="LogOut">
                </form></li>
        </ul>
        <% } else { %>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="registration.jsp">Register</a></li>
            <li><a href="index.jsp">Login</a></li>
        </ul>
            
            
        <% }%>

    </div>
</nav>