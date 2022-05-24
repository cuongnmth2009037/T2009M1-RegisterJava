<%@ page import="com.example.t2009m1demo.entity.Account" %><%
    Account account =(Account) request.getAttribute("account");
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
    <div><b>Username:</b> <%= account.getUsername()%></div>
    <div><b>Password:</b> <%= account.getPassword()%></div>
    <div><b>Fullname:</b> <%= account.getFullname()%></div>
    <div><b>Email:</b> <%= account.getEmail()%></div>
    <div><b>Phone:</b> <%= account.getPhone()%></div>
    <div><b>Birthday:</b> <%= account.getBirthday()%></div>

</div>
</body>
</html>
