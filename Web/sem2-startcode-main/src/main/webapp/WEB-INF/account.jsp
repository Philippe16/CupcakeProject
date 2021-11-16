
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Dreamy Cupcakes - Account</title>

        <link rel="icon" type="image/png" href="../assets/images/logo_elements/favicon.png"/>

        <!-- CSS -->
        <link rel="stylesheet" href="../assets/css/base.css">
        <link rel="stylesheet" href="../assets/css/nav.css">
        <link rel="stylesheet" href="../assets/css/footer.css">
        <link rel="stylesheet" href="../assets/css/account.css">

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
                <div class="pageTitle_container">
                    <h2>Account</h2>
                </div>

                <div class="accountIcon_container">
                    <i class="accountIcon fas fa-user-circle"></i>
                </div>

                <div id="userEmail_container">
                    ${sessionScope.user.email}
                </div>

                <div id="userName_container">
                    ~ ${sessionScope.user.firstName}&nbsp;
                    ${sessionScope.user.lastName} ~
                 </div>

                <div class="balanceTitle_container">
                    Current account Balance*
                </div>

                <div class="balanceOuterContainer">
                    <div class="balanceInnerContainer">
                        ${sessionScope.user.accountBalance}&nbsp; Kr.
                    </div>
                </div>

                <div id="viewAllOrders_container">
                    <a id="viewAllOrders_link" href="orders">
                        View all orders
                        <span class="purple">
                            <i class="fas fa-receipt"></i>
                        </span>
                    </a>
                </div>

                <div id="logoutContainer">
                    <a id="logoutLink" href ="signOutCommand">Logout</a>
                </div>

                <div class="accountBalanceInfo">
                    <span class="extraLineHeight">Account Balance*<br></span>
                    if you wish to add more to your balance, please contact the shop.<br>
                    Contact information can be found on the contact page at the bottom of the site
                </div>
            </main>

            <!--Footer include -->
            <%@include file="includes/footer.txt"%>
        </div> <!-- #wrapper END -->

        <script src="../assets/js/menu_mobile.js"></script>
    </body>
</html>
