
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">

   <title>Dreamy Cupcakes - Home</title>

   <!-- CSS -->
   <link rel="stylesheet" href="../assets/css/base.css">
   <link rel="stylesheet" href="../assets/css/nav.css">
   <link rel="stylesheet" href="../assets/css/footer.css">
   <link rel="stylesheet" href="../assets/css/home.css">

   <!-- Fonts -->
   <script src="https://kit.fontawesome.com/ca25e16baf.js" crossorigin="anonymous"></script>
</head>

<body>
<div id="wrapper">
   <!-- header include -->
   <%@include file="includes/header.txt"%>
   <!-- header include END -->

   <!-- guest/customer nav include -->
   <%@include file="includes/nav.txt"%>
   <!-- guest/customer nav include END -->

   <main>
      <section id="welcomeSection" class="sitePreview posRelative">
         <h2 class="welcomePreviewTxt_title">
            <span class="h2Medium">Welcome</span><br>
            <span class="h2Small">to</span><br>
            <span class="h2Big">Dreamy Cupcakes</span>
         </h2>

         <div class="decorativeLine_container decorativeLine_right posAbsolute">
            <img class="decorativeLine_img" src="../assets/images/home/Welcome section/decorativeLine - PurpleRT.png" alt="Purple decorative line">
         </div>

         <div class="decorativeLine_container decorativeLine_left posAbsolute">
            <img class="decorativeLine_img" src="../assets/images/home/Welcome section/decorativeLine - PurpleLB.png" alt="Purple decorative line">
         </div>
      </section>

      <section id="aboutSection" class="sitePreview sitePreviewOpacity posRelative">
         <div class="sitePreviewTxt_container sitePreviewTxtLeft posAbsolute">
            <h2 class="sitePreviewTxt_title">~ About ~</h2>

            <p class="sitePreviewTxt_paragraph">
               Since summer 2021,  we 've been very fortunate to provide our lovely
               neighbors in Olska, Bornholm with 100% organic cupcakes in our
               little cupcake shop.
            </p>

            <a class="sitePreview_link" href="about.html">Read more...</a>
         </div>
      </section>

      <section id="shopSection" class="sitePreview sitePreviewOpacity posRelative">
         <div class="sitePreviewTxt_container sitePreviewTxtRight posAbsolute">
            <h2 class="sitePreviewTxt_title">~ Shop ~</h2>

            <p class="sitePreviewTxt_paragraph">
               Need a big batch of cupcakes for an event?<br>
               Or maybe you just like to "build your own" cupcakes? We do too ;)<br>
               Whatever the reason, our online cupcake shop is ready to accommodate your wishes!
            </p>

            <a class="sitePreview_link" href="shop.html">Visit our online cupcake shop</a>
         </div>
      </section>

      <section id="contactSection" class="sitePreview sitePreviewOpacity posRelative">
         <div class="sitePreviewTxt_container sitePreviewTxtLeft posAbsolute">
            <h2 class="sitePreviewTxt_title">~ Contact ~</h2>

            <p class="sitePreviewTxt_paragraph">
               Want to get in touch?<br>
               Any and all questions are welcome!<br>
               All contact information can be found on our contact page.
            </p>

            <a class="sitePreview_link" href="contact.html">Go to contact page</a>
         </div>
      </section>
   </main>

   <!--Footer include -->
   <%@include file="includes/footer.txt"%>
   <!--Footer include END -->
</div> <!-- #wrapper END -->

<script src="../assets/js/menu_mobile.js"></script>
</body>
</html>
