<%-- 
    Document   : shopCart
    Created on : 21-09-2017, 09:27:31
    Author     : Strom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>


    </head>
    <body>
        <h1>Hello World!</h1>


        <form name="BottomSelect" action="" method="get">
            <div align="center">
                <select name="mydropdown">                  
                    <option value="1">Fresh Milk</option>
                    <option value="2">Old Cheese</option>
                    <option value="3">Hot Bread</option>
                </select>
            </div>
        </form>
        <br><br><br><br>

        <form name="ToppingSelect" action="" method="get">
            <div align="center">
                <select name="mydropdown">
                    <option value="1">Fresh Milk</option>
                    <option value="2">Old Cheese</option>
                    <option value="3">Hot Bread</option>
                </select>
            </div>
        </form>


        <form name="AddOrderLine" action="AddOrderLineServlet" method="POST">
            <div align="center">
              <input type="submit" name="submit" value="Add">
            </div>
        </form>




    </body>
</html>
