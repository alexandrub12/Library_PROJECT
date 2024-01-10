<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
  <meta charset="utf-8">
  <title>Login</title>
  <link rel="stylesheet" href="css/LogInStyle.css">
</head>
<body>
<div>
  <a href="index.jsp">
    <img class="logo" src="css/logo.png">
  </a>
</div>
<div class="center">
  <h2>Login</h2>
  <form method="post">
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
    <div class="pass">Forgot Password?</div>
    <input type="submit" value="Login">
    <div class="signup_link">
      Not a member? <a href="SignUp.html">Signup</a>
    </div>
  </form>
</div>

</body>
</html>