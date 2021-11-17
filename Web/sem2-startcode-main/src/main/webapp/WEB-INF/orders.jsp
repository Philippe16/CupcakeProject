<%--
  Created by IntelliJ IDEA.
  User: philippesuenson
  Date: 17/11/2021
  Time: 13.08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="shoppingBagMsg" value="${requestScope.shoppingBagMsg}" scope="page" />

<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Dreamy Cupcakes - Shop</title>

        <link rel="icon" type="image/png" href="../assets/images/logo_elements/favicon.png"/>

        <!-- CSS -->
        <link rel="stylesheet" href="../assets/css/base.css">
        <link rel="stylesheet" href="../assets/css/nav.css">
        <link rel="stylesheet" href="../assets/css/footer.css">
        <link rel="stylesheet" href="../assets/css/orders.css">

        <!-- Fonts -->
        <script src="https://kit.fontawesome.com/ca25e16baf.js" crossorigin="anonymous"></script>
</head>

    <body>
    <div id="wrapper">
        <!-- header include -->
        <%@include file="includes/header.txt"%>

        <!-- guest/customer nav include -->
        <%@include file="includes/nav.txt"%>

        <main>

            <h2 class="tableTitle">Orders</h2>

            <table class="ordersTable">
                <tr id="ordersTable_head">
                    <th>Order ID</th>
                    <th>Items (cupcake topping, cupcake flavor, amount)</th>
                    <th>Total price</th>
                    <th>Order date</th>
                </tr>

                <c:forEach items="${sessionScope.customerOrders}" var="order">
                    <tr class="ordersTable_data">
                        <td>#${order.order_id}</td>
                        <td>
                            -Coffee,chocolate, 12<br>
                            - Lemon, Vanilla, 6
                        </td>
                        <td>200.00kr</td>
                        <td>${order.orderDate}</td>
                    </tr>
                </c:forEach>
            </table>


        </main>

        <!--Footer include -->
        <%@include file="includes/footer.txt"%>
    </div> <!-- #wrapper END -->

    <script src="../assets/js/menu_mobile.js"></script>
    </body>
</html>

