
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
   <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">

      <title>Dreamy Cupcakes - About</title>

      <link rel="icon" type="image/png" href="../assets/images/logo_elements/favicon.png"/>

      <!-- CSS -->
      <link rel="stylesheet" href="../assets/css/base.css">
      <link rel="stylesheet" href="../assets/css/nav.css">
      <link rel="stylesheet" href="../assets/css/footer.css">
      <link rel="stylesheet" href="../assets/css/shoppingBasket.css">

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
            <section class="form_section_container posRelative">
               <div class="form_title_container posAbsolute">
                  <h2 class="form_title">Shopping cart</h2>
               </div>

               <div class="innerBorder">
                  <table id="cartItem_table">
                     <tr>
                        <th>&nbsp;&nbsp;&nbsp;Cupcake flavor&nbsp;&nbsp;&nbsp;</th>
                        <th>&nbsp;&nbsp;&nbsp;Cupcake topping&nbsp;&nbsp;&nbsp;</th>
                        <th>&nbsp;&nbsp;&nbsp;Amount&nbsp;&nbsp;&nbsp;</th>
                        <th>&nbsp;&nbsp;&nbsp;Price&nbsp;&nbsp;&nbsp;</th>
                        <th class="thNoUnderline"></th> <!-- Column for remove btns -->
                     </tr>

                     <c:forEach items="${sessionScope.shoppingBasketItems}" var="item">
                        <tr>
                           <td>${item.cupcake.cupcakeFlavor.name}</td>

                           <td>${item.cupcake.cupcakeTopping.name}</td>

                           <td class="centeredTd">${item.amount}</td>

                           <td class="centeredTd">${item.cupcake.price * item.amount}</td>
                           <td class="centeredTd">
                              <form action="removeOrderItemFromBasketCommand" method="POST">
                                 <input name="orderItemToBeRemoved" type="hidden" value="${item.id}">
                                 <button class="removeButton" type="submit">
                                    <i class="fas fa-minus-circle removeIcon"></i>
                                 </button>
                              </form>
                           </td>
                        </tr>
                     </c:forEach>

                     <tr>
                        <td>Total:</td>
                        <td></td>
                        <td class="centeredTd">${sessionScope.shoppingBasketTotalCupcakes}&nbsp;pcs.</td>
                        <input name="totalPrice" type="hidden" value="${sessionScope.shoppingBasketTotalPrice}">
                        <td class="centeredTd">${sessionScope.shoppingBasketTotalPrice}&nbsp;kr.</td>
                        <td class="centeredTd"></td>
                     </tr>
                  </table>

                   <c:if test="${sessionScope.orderConfirmed == true}">
                     <div id="confirmationBox">
                        <span id="thankYouMsg">Thank you!</span>
                        <br>
                        Your order has been confirmed&nbsp;<i class="msgIcon far fa-check-circle"></i>
                     </div>

                      <% request.getSession().removeAttribute("orderConfirmed"); %>
                   </c:if>

                  <c:if test="${requestScope.error != null}">
                     <div id="errorBox">
                        <span id="thankYouMsg">Oh no...</span>
                        <br>
                        ${requestScope.error}&nbsp;<i class="msgIcon fas fa-exclamation"></i>
                     </div>

                     <% request.getSession().removeAttribute("error"); %>
                  </c:if>

                  <div id="buyCupcakes_container">
                     <a id="buyCupcakes_link" href="buyCupcakesCommand">Buy</a>
                  </div>
               </div>

            </section>
         </main>

         <!--Footer include -->
         <%@include file="includes/footer.txt"%>
      </div> <!-- #wrapper END -->

      <script src="../assets/js/menu_mobile.js"></script>
   </body>
</html>
