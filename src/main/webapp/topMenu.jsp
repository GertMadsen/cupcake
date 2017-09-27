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
     </ul>

     <% if (topUser != null) { %>

        <ul class="nav navbar-nav navbar-right">
            <li class="navbar-text">Logged in as : <%=topName%></li>
            <% if (!topUser.isAdmin()) { %>
            <li class="navbar-text">Your balance is : <%=topBalance%></li>
            <% } else { %>
            <li class="navbar-text">(Administrator)</li>
            <% } %><li><a href="index.jsp">Log Out</a></li>
        </ul>

        <% } %>

    </div>
</nav>