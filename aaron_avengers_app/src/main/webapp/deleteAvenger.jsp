<%-- 
    Document   : deleteAvenger.jsp
    Created on : 13-Nov-2019, 4:17:33 PM
    Author     : Aaron Tran, Vinayak P
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mylib" uri="/WEB-INF/tlds/mytag_library.tld"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Avenger</title>
        <link rel="stylesheet" type="text/css" href="css/index.css">
    </head>
    <body>
        <h1>Snap an Avenger!</h1>
        <jsp:useBean id="avengerDb" class="com.tranaa.aaron_vinayak_a2.model.AvengerDb"/>
        <c:set var="avengersCount" value="${avengerDb.getAvengers().size()}" />
        <c:if test="${!empty error}">
            <h1>Error: ${error}</h1>
        </c:if>
        <c:choose>
            <c:when test="${avengersCount > 0}">
                <form action="DeleteAvenger.do" method="post">
                    <mylib:AvengersHandler /></br>
                    <input type="submit" value="submit" />
                </form>
            </c:when>
            <c:otherwise>
                <h1>No one here</h1>
            </c:otherwise>
        </c:choose>
        <a href="index.html">Back to index</a>
    </body>
</html>
