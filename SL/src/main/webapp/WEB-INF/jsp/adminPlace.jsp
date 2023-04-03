<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Administration Places</title>
    <link rel="stylesheet" href="/css/flex.css">
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="/css/adminPlace.css">
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
    <div class="main-content flex-column">
        <div class="flex-column">

        </div>
        <form:form modelAttribute="place" action="adminPlace" method="post">
            <div class="flex-column center-vertically box">
                <h1>Create Places for Users! Get to Work, Billy!</h1>
                <div class="flex-row input-field">
                    <!-- form:inputs so spring can track your input to a variable -->
                    <!-- The path represents the variable to set the data to -->
                    <div>Name: </div>
                    <form:input path="name" type="text" />
                </div>
                <div class="flex-row input-field">
                    <!-- form:inputs so spring can track your input to a variable -->
                    <!-- The path represents the variable to set the data to -->
                    <div>Price: </div>
                    <form:input path="price" type="decimal" />
                </div>
                <div class="flex-row input-field">
                    <!-- form:inputs so spring can track your input to a variable -->
                    <!-- The path represents the variable to set the data to -->
                    <div>Image URL: </div>
                    <form:input path="imgURL" type="text" />
                </div>
                <!-- form:button so it can submit the spring form on submit (when clicked) -->
                <form:button>Submit</form:button>
            </div>
        </form:form>
        <div>
            <c:forEach items="${allPlaces}" var="place">
                <div class="box flex-column">
                    <div>Name: ${place.getName()}</div>
                    <div>Price: $${place.getPrice()}</div>
                    <img src="${place.getImgURL()}" class="placeImage" />
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>