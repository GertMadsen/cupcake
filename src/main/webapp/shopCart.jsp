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

        </style>

    </head>
    <body>
        <div class ="CShop">
            <form name="BottomSelect" action="" method="POST">
                <div class="DD">
                    Bottom <br>
                    <select name="mydropdown">
                        <option value="1">Fresh Milk</option>
                        <option value="2">Old Cheese</option>
                        <option value="3">Hot Bread</option>
                    </select>
                </div>
            </form>


            <form name="ToppingSelect" action="" method="POST">
                <div class="DD">
                    Topping <br>
                    <select name="mydropdown">
                        <option value="1">Fresh Milk</option>
                        <option value="2">Old Cheese</option>
                        <option value="3">Hot Bread</option>
                    </select>
                </div>
            </form>


            <form name="quantity" action="" method="POST">
                <div class="DD">
                   Quantity <br>
                    <input type="text" name="quantity" value="">
                </div>
            </form>


            <form name="AddOrderLine" action="AddOrderLineServlet" method="POST">
                <div>
                    <br>
                    <input type="submit" name="submit" value="Add">
                </div>
            </form>

        </div>



    </body>
</html>
