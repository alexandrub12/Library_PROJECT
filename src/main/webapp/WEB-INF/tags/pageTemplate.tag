<%@tag description="base page template" pageEncoding="UTF-8"%>
<%@attribute name="pageTitle"%>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/design.css">
    <title>${pageTitle}</title>
</head>
<body>


<nav class="navbar">
    <img class="logo" src="css/logo.png">
    <ul>
        <li><a class="active" href="index.jsp">Home</a></li>
        <li><a href="LogIn.jsp">Log in</a></li>
        <li><a href="SignUp.jsp">Sign up</a></li>
        <li><a href="Books.jsp">Books</a></li>
    </ul>
</nav>


<main class="container-fluid mt-5">
    <jsp:doBody/>
</main>


</body>
</html>