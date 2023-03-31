<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up For Spring Project</title>
    <link rel="stylesheet" href="/css/signUp.css">
    <link rel="stylesheet" href="/css/flex.css">
    <link rel="stylesheet" href="/css/main.css">
</head>

<body class="flex-column">
    <div class="header flex-row">
        <a href="/sign-up" class="header-links">Sign Up</a>
        <a href="/" class="header-links">Home</a>
        <a href="/sign-in" class="header-links">Sign In</a>
    </div>
    <div class="main-content flex-row">
        <div class="signup-box flex-column">
            <h1>Sign Up</h1>
            <!-- form:form tags are for spring forms so you can
                send this data to the controller -->
            <form:form modelAttribute="user" action="sign-up" method="post">
                <div class="flex-column center-vertically">
                    <div class="flex-row input-field">
                        <!-- form:inputs so spring can track your input to a variable -->
                        <!-- The path represents the variable to set the data to -->
                        <div>Email: </div>
                        <form:input path="email" type="text" class="input-box" />
                    </div>
                    <div class="flex-row input-field">
                        <!-- form:inputs so spring can track your input to a variable -->
                        <!-- The path represents the variable to set the data to -->
                        <div>Password: </div>
                        <form:input path="password" type="password" class="input-box" />
                    </div>
                    <div class="flex-row input-field">
                        <!-- form:inputs so spring can track your input to a variable -->
                        <!-- The path represents the variable to set the data to -->
                        <div>Name: </div>
                        <form:input path="name" type="text" class="input-box" />
                    </div>
                    <!-- form:button so it can submit the spring form on submit (when clicked) -->
                    <form:button class="submit-button">Submit</form:button>
                </div>
            </form:form>
        </div>
    </div>
</body>

</html>