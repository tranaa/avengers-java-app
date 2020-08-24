<%-- 
    Document   : addPowerSource
    Created on : 13-Nov-2019, 4:41:09 PM
    Author     : Aaron Tran, Vinayak P
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Power Source Page</title>
        <link rel="stylesheet" type="text/css" href="css/index.css">
    </head>
    <body>
        <h1>Add A New Power Source</h1>
        <c:if test="${!empty error}">
            <h1>Error: ${error}</h1>
        </c:if>
        <form action="AddPowerSource.do" method="post">
            Description: <input type="text" name="description" required/></br></br>
            <input type="submit" value="submit" />
        </form>
        <a href="index.html">Back to index</a>
    </body>
</html>
