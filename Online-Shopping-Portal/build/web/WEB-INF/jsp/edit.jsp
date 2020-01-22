<%-- 
    Document   : edit
    Created on : 7 Sep, 2019, 8:21:07 PM
    Author     : projjal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit item</title>
    </head>
    
    <style>
        .error
        {
            color:red;
        }
    </style>
    
    <body>
        <h1>Edit item price, quantity!</h1>
        <hr>
        <br>
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAm5iD9123UGuDNSHzRm8pdI-XdLCl5wYcGHHuoBpniUS5Ei2EKQ&s">
        <br>
        <p class="error">${msg}</p>
        <br>        
        <br>
        <form action="change.htm" method="POST">
            ID : <input type="number" readonly name="id" value="${id}">
            <br>
            <p>Name of commodity :  ${name}</p>
            <p>Quantity : <input type="number" min="0" name="quantity" value="${qty}"></p>
            <p>Price of each : <input type="number" min="0" name="price" value="${price}"></p>
             <p>Type of commodity : ${type}</p>
            <br>
            <br>
            <input type="submit" value="Edit item">
        </form>
            <br>
            <br>
            <a href="index.htm">Back..</a>
    </body>
</html>
