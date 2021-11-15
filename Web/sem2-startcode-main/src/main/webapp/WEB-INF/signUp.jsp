<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Dreamy Cupcakes - Sign Up</title>

    <!-- CSS -->
    <link rel="stylesheet" href="../assets/css/base.css">
    <link rel="stylesheet" href="../assets/css/footer.css">
    <link rel="stylesheet" href="../assets/css/signUp.css">
    <!-- Fonts -->
    <script src="https://kit.fontawesome.com/ca25e16baf.js" crossorigin="anonymous"></script>
</head>

<body>
<div id="wrapper">
    <%@include file="includes/header.txt"%>

    <main>

        <section class="form_section_container posRelative">
            <div class="form_title_container posAbsolute">
                <h2 class="form_title">Sign Up</h2>
            </div>

            <div class="standardForm">


                <form action="signUpCommand" method="post">


                    <div class="signInFormSection">

                        <label for="firstName">First Name:</label><br>
                        <input name="firstName" id="firstName" type="text">
                    </div>

                    <div class="signInFormSection">

                        <label for="lastName">Last Name:</label> <br>
                        <input name="lastName" id="lastName" type="text">
                    </div>

                    <div class="signInFormSection">

                        <label for="email">Email:</label> <br>
                        <input name="email" id="email" type="text">
                    </div>


                    <div class="signInFormSection">

                        <label for="password">Password:</label> <br>
                        <input name="password" id="password" type="password">
                    </div>



                    <div class="sumbitButtonContainer">

                        <button class="loginBtn" type="submit">Sign Up</button>

                    </div>



                    <div class="goToLogin">
                        <p>Already have an account?</p>
                        <a href="signIn">Go to login</a>
                    </div>

                </form>

            </div>
        </section>

        <button class="homeBtn" type="button">
            <i class="ArrowRight fas fa-arrow-left"></i>
            <a href="home.html">Back</a>
        </button>


    </main>
    <!--Footer include -->
    <%@include file="includes/footer.txt"%>

</div> <!-- #wrapper END -->
</body>
</html>