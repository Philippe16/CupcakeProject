
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
    <link rel="stylesheet" href="../assets/css/signIn.css">

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
                <h2 class="form_title">Sign Un</h2>
            </div>

            <div class="standardForm_container">
                <form action="signUpCommand" method="POST">
                    <div class="signInFormSection">
                        <label for="email">Email:</label> <br>
                        <input id="email" name="email" type="text">
                    </div>

                    <div class="signInFormSection">
                        <label for="password">Password:</label> <br>
                        <input id="password" name="password" type="text">
                    </div>

                    <div class="formBtn_container">
                        <button id="loginBtn" class="btn" type="submit">Login</button>
                    </div>
                </form>

                <div class = signUpLink_container>
                    <p>No account yet?</p>
                    <a class="signUpLink" href="signUp">Create an account</a>
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