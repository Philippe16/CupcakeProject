
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Dreamy Cupcakes</title>

    <!-- CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/base.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/index.css">
</head>

<body>
<div id="wrapper">
    <div id="index_logo_container">
        <img src="<%=request.getContextPath()%>/assets/images/logo_elements/logo - original.png" alt="Dreamy Cupcakes' logo">
    </div>
</div> <!-- #wrapper END -->


<!-- Redirect to home.html after logo fade out -->
<script>
    setTimeout(function() {
        document.location = "fc/home";
    }, 1800); // <-- Delay in milliseconds - Match with logo fade out animation found in index.css
</script>
</body>

</html>