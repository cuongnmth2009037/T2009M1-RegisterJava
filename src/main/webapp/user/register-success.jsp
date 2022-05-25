<%@ page import="com.example.t2009m1demo.entity.Account" %>
<%@ page import="com.example.t2009m1demo.entity.User" %><%
    User user =(User) request.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="alert alert-success">
        <strong>Register Success!</strong>
    </div>
    <div><b>Username:</b> <%= user.getUsername()%></div>
    <div><b>Password:</b> <%= user.getPassword()%></div>
    <div><b>Fullname:</b> <%= user.getFullname()%></div>
    <div><b>Email:</b> <%= user.getEmail()%></div>
    <div><b>Phone:</b> <%= user.getPhone()%></div>
    <div><b>Birthday:</b> <%= user.getBirthday()%></div>

</div>
</body>
</html>
