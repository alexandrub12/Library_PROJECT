<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>SignUp</title>
    <link rel="stylesheet" href="css/SignUp.css">
</head>
<body>
<div class="logo">
    <a href="index.jsp">
        <img class="logo" src="css/logo.png">
    </a>
</div>
<div class="center">
    <h2>Sign Up</h2>
    <form method="post">
        <div class="txt_field">
            <input type="email" required>
            <span></span>
            <label>Email</label>
        </div>
        <div class="txt_field">
            <input type="text" required>
            <span></span>
            <label>Username</label>
        </div>
        <div class="txt_field">
            <input type="password" required>
            <span></span>
            <label>Password</label>
        </div>
        <div class="txt_field">
            <input type="password" required>
            <span></span>
            <label>Repeat Password</label>
        </div>
        <input type="submit" value="SignUp">
    </form>
</div>

</body>
</html>