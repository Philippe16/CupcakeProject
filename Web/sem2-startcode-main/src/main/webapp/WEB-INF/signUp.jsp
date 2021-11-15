
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Dreamy Cupcakes - Sign Un</title>

    <!-- CSS -->
    <link rel="stylesheet" href="../assets/css/base.css">
    <link rel="stylesheet" href="../assets/css/footer.css">
    <link rel="stylesheet" href="../assets/css/sign.css">

    <!-- Fonts -->
    <script src="https://kit.fontawesome.com/ca25e16baf.js" crossorigin="anonymous"></script>
</head>

<body>
    <div id="wrapper">
        <!-- Include header -->
        <%@include file="includes/header.txt"%>

        <main>
            <section class="form_section_container posRelative">
                <div class="form_title_container posAbsolute">
                    <h2 class="form_title">Sign up</h2>
                </div>

                <div class="standardForm_container">
                    <form action="signUpCommand" method="post">
                        <div class="inputSection">
                            <label for="firstName">First Name:</label><br>
                            <input name="firstName" id="firstName" type="text">
                        </div>

                        <div class="inputSection">
                            <label for="lastName">Last Name:</label> <br>
                            <input name="lastName" id="lastName" type="text">
                        </div>

                        <div class="inputSection">
                            <label for="email">Email:</label> <br>
                            <input name="email" id="email" type="text">
                        </div>


                        <div class="inputSection">
                            <label for="password">Password:</label> <br>
                            <input name="password" id="password" type="password">
                        </div>

                        <div class="formBtn_container">
                            <button id="loginBtn" class="btn" type="submit">Submit</button>
                        </div>
                    </form>

                    <div class = "signUpLink_container">
                        <p>Already have an account?</p>
                        <a class="signUpLink" href="signIn">Go to login</a>
                    </div>
                </div> <!-- .standardForm_container END -->
            </section>

            <div class="backBtn_container">
                <button class="btn" type="button">
                    <i class="backIcon fas fa-arrow-left"></i>
                    <a href="home">Back</a>
                </button>
            </div>
        </main>

        <!--Footer include -->
        <%@include file="includes/footer.txt"%>
    </div> <!-- #wrapper END -->
</body>
</html>