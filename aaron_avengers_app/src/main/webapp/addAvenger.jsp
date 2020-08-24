<%-- 
    Document   : addAvengers
    Created on : 10-Nov-2019, 8:44:58 PM
    Author     : Aaron Tran, Vinayak P
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mylib" uri="/WEB-INF/tlds/mytag_library.tld"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Avengers</title>
        <link rel="stylesheet" type="text/css" href="css/index.css">
    </head>
    <body>
        <h1>Add an Avenger!</h1>
        <jsp:useBean id="powerSourceDb" class="com.tranaa.aaron_vinayak_a2.model.PowerSourceDb"/>
        <c:set var="powersCount" value="${powerSourceDb.getPowerSources().size()}" />
        <c:if test="${!empty error}">
            <h1>Error: ${error}</h1>
        </c:if>
        <c:choose>
            <c:when test="${powersCount > 0}">
                <form action="AddAvenger.do" method="post">
                    <label>Name:</label> <input type="text" name="name" required/></br></br>
                    <label>Description:</label> <input type="text" name="description" required/></br></br>
                    <mylib:PowerSourceHandler /></br>
                    <input type="submit" value="submit" />
                </form>
            </c:when>
            <c:otherwise>
                <h1>No powers to make new Avengers</h1>
            </c:otherwise>
        </c:choose>
        <a href="index.html">Back to index</a>
    </body>
</html>
