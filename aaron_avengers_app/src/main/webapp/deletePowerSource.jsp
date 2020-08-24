<%-- 
    Document   : deletePowerSource
    Created on : 13-Nov-2019, 5:46:26 PM
    Author     : Aaron Tran, Vinayak P
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mylib" uri="/WEB-INF/tlds/mytag_library.tld"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Power Source</title>
        <link rel="stylesheet" type="text/css" href="css/index.css">
    </head>
    <body>
        <h1>Delete A Power Source!</h1>
        <jsp:useBean id="powerSourceDb" class="com.tranaa.aaron_vinayak_a2.model.PowerSourceDb"/>
        <c:set var="powersCount" value="${powerSourceDb.getUnusedPowerSources().size()}" />
        <c:if test="${!empty error}">
            <h1>Error: ${error}</h1>
        </c:if>
        <c:choose>
            <c:when test="${powersCount > 0}">
                <form action="DeletePowerSource.do" method="post">
                    <mylib:UnusedPowerSourceHandler /></br>
                    <input type="submit" value="submit" />
                </form>
            </c:when>
            <c:otherwise>
                <h1>No Unused Powers to Delete</h1>
            </c:otherwise>
        </c:choose>
        <a href="index.html">Back to index</a>
    </body>
</html>
