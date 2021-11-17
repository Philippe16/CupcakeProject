
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
      <link rel="stylesheet" href="../assets/css/shop.css">

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
                  <h2 class="form_title">Build your own cupcakes</h2>
               </div>

               <div class="standardForm_container">
                  <div class="howTo">
                     1) Choose a cupcake flavor<br>
                     2) Choose a cupcake topping<br>
                     3) Choose how many<br>
                     4) Click on the button "Add to basket"<br>
                     5) Repeat!<br>
                     6) When done, go to your basket <i class="basketIcon fas fa-shopping-basket"></i>
                  </div>

                  <form action="addToBasketCommand" method="POST">
                     <div id="selectFlexContainer" class="flexRow">
                        <div class="selectContainer">
                           <div class="label_container">
                              <label for="cupcakeFlavorInput">Cupcake flavor</label>
                           </div>

                           <select id="cupcakeFlavorInput" class="cupcakeSelect" name="cupcakeFlavor" required>
                              <option value="" disabled selected>Select a flavor</option>

                              <c:forEach items="${sessionScope.cupcakeShop.cupcakeFlavors}" var="flavor">
                                 <option value="${flavor.id}">${flavor.name}</option>
                              </c:forEach>
                           </select>
                        </div> <!-- .selectContainer END -->

                        <div class="selectContainer">
                           <div class="label_container">
                              <label for="cupcakeToppingInput">Cupcake topping</label>
                           </div>

                           <select id="cupcakeToppingInput" class="cupcakeSelect" name="cupcakeTopping" required>
                              <option value="" disabled selected>Select a topping</option>

                              <c:forEach items="${sessionScope.cupcakeShop.cupcakeToppings}" var="topping">
                                 <option value="${topping.id}">${topping.name}</option>
                              </c:forEach>
                           </select>
                        </div> <!-- .selectContainer END -->

                        <div class="selectContainer">
                           <div class="label_container">
                              <label for="amountOfCupcakesInput">Cupcake amount</label>
                           </div>

                           <select id="amountOfCupcakesInput" class="cupcakeSelect" name="amountOfCupcakes" required>
                              <option value="" disabled selected>Select an amount</option>
                              <option value="2">2</option>
                              <option value="4">4</option>
                              <option value="6">6</option>
                              <option value="8">8</option>
                              <option value="10">10</option>
                              <option value="30">30</option>
                              <option value="50">50</option>
                           </select>
                        </div>
                     </div>

                     <div id="msgBtn_container" class="flexRow">
                        <div id="shopMsg_container" class="orderAdded">
                           <c:if test="${sessionScope.shoppingBagMsg != null }">
                              ${sessionScope.shoppingBagMsg}

                              <i class="orderAddedIcon far fa-check-circle"></i>

                              <% request.getSession().removeAttribute("shoppingBagMsg"); %>
                           </c:if>
                        </div>

                        <div id ="addToBasketBtn_container">
                           <button id="addToBasket_btn" type="submit">
                              Add to basket <i class="basketIcon fas fa-shopping-basket"></i>
                           </button>
                        </div>
                     </div>
                  </form>
               </div>
            </section>

            <section>
               <div class="table_container">
                  <h2 class="tableTitle">Cupcake flavors</h2>

                  <table id="flavorTable">
                     <tr>
                        <th>Variety</th>
                        <th>Price</th>
                     </tr>

                     <c:forEach items="${sessionScope.cupcakeFlavors}" var="flavor">
                        <tr>
                           <td>${flavor.name}</td>
                           <td>${flavor.price}</td>
                        </tr>
                     </c:forEach>
                  </table>
               </div>

               <div class="table_container">
                  <h2 class="tableTitle">Cupcake toppings</h2>

                  <table id="toppingTable">
                     <tr>
                        <th>Variety</th>
                        <th>Price</th>
                     </tr>

                     <c:forEach items="${sessionScope.cupcakeToppings}" var="topping">
                        <tr>
                           <td>${topping.name}</td>
                           <td>${topping.price}</td>
                        </tr>
                     </c:forEach>
                  </table>
               </div>
            </section>
         </main>

         <!--Footer include -->
         <%@include file="includes/footer.txt"%>
      </div> <!-- #wrapper END -->

      <script src="../assets/js/menu_mobile.js"></script>
   </body>
</html>

