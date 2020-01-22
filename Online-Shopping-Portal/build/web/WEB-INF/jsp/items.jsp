<%-- 
    Document   : items
    Created on : 7 Sep, 2019, 7:53:54 PM
    Author     : projjal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My listed items.</title>
    </head>
    <style>
        table,tr,th,td
        {
            border: 2px black solid;
        }
        h1
        {
            background-color: skyblue;
        }
    </style>
    
    <body>
    <center>
        <h1>See status of your orders !</h1>
        <br>
        <hr>
        
        <br>
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
                <th>Edit item</th>
            </tr>
         <c:forEach items="${list}" var="ls">
                <tr>
                <form action="edit.htm?id=${ls.id}" method="POST">
                    <td><c:out value="${ls.id}"/> </td>
                    <td><c:out value="${ls.name}"/> </td>
                    <td><c:out value="${ls.quantity}"/> </td>
                    <td><c:out value="${ls.owner}"/> </td>
                    <td><c:out value="${ls.price}"/> </td>
                    <td><c:out value="${ls.type}"/></td>

                    <td><input type="submit" value="Edit item"></td>
                </form>
                </tr>
          </c:forEach>
        </table>
        </c:if>
        
        <br>
        <a href="index.htm">Back..</a>
    </center>
    </body>
</html>
