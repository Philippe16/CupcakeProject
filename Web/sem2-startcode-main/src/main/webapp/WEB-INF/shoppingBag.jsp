
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
      <link rel="stylesheet" href="../assets/css/shoppingBag.css">

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

               <form action="" method="POST" class="standardForm">
                  <table id="cartItem_table">
                     <tr>
                        <th>&nbsp;&nbsp;&nbsp;Cupcake flavor&nbsp;&nbsp;&nbsp;</th>
                        <th>&nbsp;&nbsp;&nbsp;Cupcake topping&nbsp;&nbsp;&nbsp;</th>
                        <th>&nbsp;&nbsp;&nbsp;Amount&nbsp;&nbsp;&nbsp;</th>
                        <th>&nbsp;&nbsp;&nbsp;Price&nbsp;&nbsp;&nbsp;</th>
                        <th class="thNoUnderline"></th> <!-- Column for remove btns -->
                     </tr>

                     <tr>
                        <!-- In the inputs, remove hardcoded values later -->

                        <input name="cupcakeFlavor" type="hidden" value="Chocolate">
                        <td>Chocolate</td>

                        <input name="cupcakeTopping" type="hidden" value="Mocca frosting">
                        <td>Mocca frosting</td>

                        <input name="amount" type="hidden" value="6">
                        <td class="centeredTd">6</td>

                        <input name="price" type="hidden" value="180.00">
                        <td class="centeredTd">180</td>
                        <td class="centeredTd"><i class="fas fa-minus-circle removeIcon"></i></td>
                     </tr>

                     <tr>
                        <td>Vanilla</td>
                        <td>Raspberry whipped cream</td>
                        <td class="centeredTd">2</td>
                        <td class="centeredTd">50</td>
                        <td class="centeredTd"><i class="fas fa-minus-circle removeIcon"></i></td>
                     </tr>

                     <tr>
                        <td>Lemon</td>
                        <td>Whipped cream</td>
                        <td class="centeredTd">2</td>
                        <td class="centeredTd">36</td>
                        <td class="centeredTd"><i class="fas fa-minus-circle removeIcon"></i></td>
                     </tr>

                     <tr>
                        <td>Total:</td>
                        <td></td>
                        <td class="centeredTd">10 pcs.</td>
                        <input name="totalPrice" type="hidden" value="266">
                        <td class="centeredTd">266 kr.</td>
                        <td class="centeredTd"></td>
                     </tr>
                  </table>

                  <div class="standardBtn_container">
                     <button class="standardBtn" type="submit">Buy</button>
                  </div>
               </form>
            </section>
         </main>

         <!--Footer include -->
         <%@include file="includes/footer.txt"%>
      </div> <!-- #wrapper END -->

      <script src="../assets/js/menu_mobile.js"></script>
   </body>
</html>
