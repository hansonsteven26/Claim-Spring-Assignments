<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Administration Page</title>
    <link rel="stylesheet" href="/css/flex.css">
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="/css/adminTools.css">
</head>

<body class="flex-column">
    <c:choose>
        <c:when test="${user != null}">
            <div class="header flex-row">
                <div class="header-links">Aloha, ${user.getName()}</div>
                <a href="/" class="header-links">Home</a>
                <a href="/logout" class="header-links">Log Out</a>
            </div>
        </c:when>
        <c:otherwise>
            <div class="header flex-row">
                <a href="/sign-up" class="header-links">Sign Up</a>
                <a href="/" class="header-links">Home</a>
                <a href="/sign-in" class="header-links">Sign In</a>
            </div>
        </c:otherwise>
    </c:choose>
    <!-- Reservations, Places, Amenities -->
    <div class="main-content flex-row">
        <div class="flex-column">
            <div class="flex-row justify-center">
                <h1>Welcome, Admin. Choose an Option</h1>
            </div>
            <div class="flex-row justify-center">
                <a href="/reservation" class="link-button">View Reservations</a>
                <a href="/adminPlace" class="link-button">Create/Update Places</a>
                <a href="/amenity" class="link-button">Create/Update Amenities</a>
            </div>
        </div>
    </div>
</body>

</html>