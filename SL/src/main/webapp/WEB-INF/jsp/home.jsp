<!-- The form tag will allow you to grab the information
from the form and send it to the controller -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Allows you to use c tags, tags that do things life if statements and loops -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Allows for java stuff on the page -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>In-Class Spring Project</title>
    <link rel="stylesheet" href="/css/home.css">
    <link rel="stylesheet" href="/css/flex.css">
    <link rel="stylesheet" href="/css/main.css">
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
    
    <div class="main-content flex-row">
        <c:choose>
            <c:when test="${user != null}">
                Hello there ${user.getName()}
            </c:when>
            <c:otherwise>
                You're not Billy!
            </c:otherwise>
        </c:choose>
    </div>
</body>

</html>