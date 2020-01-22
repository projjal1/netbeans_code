<%-- 
    Document   : shop
    Created on : 7 Sep, 2019, 12:25:16 AM
    Author     : projjal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping portal</title>
    </head>
    
    <style>
        h1
        {
            background-color: orchid;
        }
        table,tr,th,td
        {
            border: 2px black solid;
        }
    </style>
    
    <body>
    <center>
        <h1>Online Shop!</h1>
        <br>
        <hr>
        
        <br>
        <form action="choose.htm">
        <input type="search" name="search">
        &nbsp;
        <input type="submit" value="Search like">
        </form>
        <br>
        <br>
        <c:if test="${empty list}">
        No records to show..
        </c:if>
        <c:if test="${not empty list}">
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Owner</th>
                <th>Price</th>
                <th>Type</th>
                <th>Buy</th>
                <th>Add to Cart</th>
            </tr>
         <c:forEach items="${list}" var="ls">
                <tr>
                    <td><c:out value="${ls.id}"/></td>
                    <td><c:out value="${ls.name}"/></td>
                    <td><c:out value="${ls.quantity}"/></td>
                    <td><c:out value="${ls.owner}"/></td>
                    <td><c:out value="Rs. ${ls.price}"/></td>
                    <td><c:out value="${ls.type}"/></td>
                    <td><a href="buy.htm?id=${ls.id}">Buy Item</a></td>
                    <td><a href="buy.htm?id=${ls.id}">Add to cart</a></td>
                </tr>
          </c:forEach>
        </table>
        </c:if>
        
        <br>
        <br>
        <a href="index.htm">Back to home page..</a>
    </center>
    </body>
</html>
