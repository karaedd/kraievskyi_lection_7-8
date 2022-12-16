<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>Login Page</h1>
<h4 style="color:red">${errorMsg}</h4>
<form method="post" action="${pageContext.request.contextPath}/login">
    Please enter your login: <input type="text" name="login" required>
    Please enter your password: <input type="password" name="password" required>
    <button type="submit">Login</button>
</form>
</body>
</html>
