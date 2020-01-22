<%-- 
    Document   : order
    Created on : 7 Sep, 2019, 5:13:39 PM
    Author     : projjal
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orders</title>
    </head>
    
    <style>
        table,tr,th,td
        {
            border : 3px red solid;
        }
    </style>
    <body>
        <h1>Your Inbox!</h1>
        <br>
        <hr>
        <img src="https://cdn1.iconfinder.com/data/icons/ui-22/24/391-512.png" width="100" height="100">
        
        <br>
        <c:if test="${not empty list}">
                <c:forEach items="${list}" var="ls">
                    <p><c:out value="${ls.message}"/></p>
                </c:forEach>
        </c:if>
    <c:if test="${empty list}">
        <p>You have no messages...</p>
    </c:if>
    
    <br>
    <br>
    <a href="index.htm">Back to home page .. </a>
    
    </body>
</html>
