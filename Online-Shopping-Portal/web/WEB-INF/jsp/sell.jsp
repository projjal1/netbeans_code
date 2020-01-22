<%-- 
    Document   : sell
    Created on : 6 Sep, 2019, 10:23:14 PM
    Author     : projjal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sell on Platform</title>
    </head>
    
    <style>
        table,tr,td
        {
            height:40px;
            width:500px;
            border:2px red solid;
        }
        h1
        {
            background-color: red;
        }
    </style>
    
    <body>
        <h1>Commodity Seller Platform</h1>
        <hr>
        <br>
        
        <img src="data:image/jpeg;base64,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">
        
        <br>
         <p>${msg}</p>
        <br>
        <form action="list.htm" method="POST">
            <table>
                <tr>
                    <td>name</td>
                    <td><input type="text" name="name" placeholder="Type Name of commodity"></td>
                </tr>
                <tr>
                    <td>quantity</td>
                    <td><input type="number" name="quantity"></td>
                </tr>
                <tr>
                     <td>price</td>
                     <td><input type="number" name="price" min="1"></td>
                </tr>
                <tr>
                     <td>type</td>
                     <td>
                         <select name="type">
                             <option>Electronics</option>
                             <option>Computers and accessories</option>
                             <option>Mobiles</option>
                             <option>Books</option>
                             <option>Kitchen stuff</option>
                             <option>Pantry</option>
                             <option>Stationary</option>
                         </select>
                     </td>
                </tr>
            </table>
            <br>
            <input type="submit" value="Sell commodity">
        </form>
        <br>
        <br>
        <hr>
        <a href="index.htm">Back..</a>
    </body>
</html>
