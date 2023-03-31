<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pirate Boat Dealership</title>
    <link rel="stylesheet" href="/css/home.css">
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
        <c:choose>
            <c:when test="${user != null}">
                Hello there ${user.getName()}
            </c:when>
            <c:otherwise>
                Hi Mom
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>