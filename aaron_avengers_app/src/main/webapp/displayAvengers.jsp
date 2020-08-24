<%-- 
    Document   : displayAvengers
    Created on : 10-Nov-2019, 8:44:49 PM
    Author     : Aaron Tran, Vinayak P
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Avengers</title>
        <link rel="stylesheet" type="text/css" href="css/index.css">
    </head>
    <body>
        <h1>Here are the Avengers</h1></br>
        <c:if test="${!empty error}">
            <h1>Error: ${error}</h1>
        </c:if>
        <div class="avengersContainer">
        <c:forEach var="avenger" items="${avengers}">
            <div class="avenger">
                <h2>${avenger.getName()},</br> ${avenger.getDescription()}</h2></br>
                <p>Power Source: ${avenger.getPowerSource().getDescription()}</p></br>
            </div>
        </c:forEach>
        </div>
        <a href="index.html">Back to index</a>
    </body>
</html>
