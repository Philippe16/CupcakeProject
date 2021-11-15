
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
   <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">

      <title>Dreamy Cupcakes - Shop</title>

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

                  <form action="shopCommand" method="POST">
                     <div id="selectFlexContainer" class="flexRow">
                        <div class="selectContainer">
                           <div class="label_container">
                              <label for="cupcakeFlavorInput">Cupcake flavor</label>
                           </div>

                           <select id="cupcakeFlavorInput" class="cupcakeSelect" name="cupcakeFlavor">
                              <option value="" disabled selected>Select a flavor</option>
                              <option value="Chocolate">Chocolate</option> <!-- Change value to id -->
                              <option value="Vanilla">Vanilla</option>
                              <option value="Nutmeg">Nutmeg</option>
                              <option value="Pistacio">Pistacio</option>
                              <option value="Almond">Almond</option>
                           </select>
                        </div> <!-- .selectContainer END -->

                        <div class="selectContainer">
                           <div class="label_container">
                              <label for="cupcakeToppingInput">Cupcake topping</label>
                           </div>

                           <select id="cupcakeToppingInput" class="cupcakeSelect" name="cupcakeTopping">
                              <option value="" disabled selected>Select a topping</option>
                              <option value="Chocolate">Chocolate</option>
                              <option value="Blueberry">Blueberry</option>
                              <option value="Rasberry">Rasberry</option>
                              <option value="Crispy">Crispy</option>
                              <option value="Strawberry">Strawberry</option>
                              <option value="Rum/Raisin">Raisin</option>
                              <option value="Orange">Orange</option>
                              <option value="Lemon">Lemon</option>
                              <option value="Blue cheese">Blue cheese</option>
                           </select>
                        </div> <!-- .selectContainer END -->

                        <div class="selectContainer">
                           <div class="label_container">
                              <label for="cupcakenr">Cupcake amount</label>
                           </div>

                           <select id="cupcakenr" class="cupcakeSelect"name="cupcakenr">
                              <option value="" disabled selected>Select an amount</option>
                              <option value="2">2</option>
                              <option value="4">4</option>
                              <option value="6">6</option>
                              <option value="8">8</option>
                              <option value="10">10</option>
                           </select>
                        </div>
                     </div>

                     <div id="msgBtn_container" class="flexRow">
                        <div id="shopMsg_container" class="orderAdded">
                           Delicious cupcakes were added to basket!
                           <i class="orderAddedIcon far fa-check-circle"></i>
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
                  <h2 class="tableTitel">Cupcake flavors</h2>

                  <table id="flavorTable">
                     <tr>
                        <th>Variety</th>
                        <th>Price</th>
                     </tr>

                     <c:forEach items="${sessionScope.cupcakeShop.cupcakeFlavors}" var="flavor">
                        <tr>
                           <td>${flavor.name}</td>
                           <td>${flavor.price}</td>
                        </tr>
                     </c:forEach>
                  </table>
               </div>

               <div class="table_container">
                  <h2 class="tableTitel">Cupcake toppings</h2>

                  <table id="toppingTable">
                     <tr>
                        <th>Variety</th>
                        <th>Price</th>
                     </tr>

                     <c:forEach items="${sessionScope.cupcakeShop.cupcakeToppings}" var="topping">
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
   </body>
</html>
