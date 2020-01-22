<%-- 
    Document   : signup
    Created on : 6 Sep, 2019, 7:22:43 PM
    Author     : projjal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
    </head>
    <style>
        table,tr,td
        {
            height:40px;
            width:500px;
            border:2px red solid;
        }
        .main
        {
            position:relative;
            height: 250px;
        }        
        .split
        {
            position: absolute;
            z-index: 0;
            width: 50%;
        }
        .left
        {
            left: 0;
        }
        .right
        {
            right: 0;
        }
        .end
        {
            position: relative;
        }
        .error
        {
            color:red;
        }
    </style>
    <body>
        <h1>Sign Up!</h1>
        <hr>
        <br>
        <p class="error">${msg}</p>
        <br>
        <div class="main">
        <div class="split left">
        <form action="add.htm" method="POST">
            <table>
                <tr>
                    <td>name</td>
                    <td><input type="text" name="name" placeholder="Type username"></td>
                </tr>
                <tr>
                    <td>password</td>
                    <td><input type="password" name="password" placeholder="Type password"></td>
                </tr>
                <tr>
                     <td>Status</td>
                     <td>
                         <select name="status">
                             <option selected="1">Shopper</option>
                             <option>Personnel</option>
                         </select>
                     </td>
                </tr>
            </table>
            <br>
            <input type="submit" value="Sign Up!">
        </form>
        </div>
            
        <div class="split right">
            <img src="data:image/png;base64,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">    
        </div>    
        </div>
        
        <br>
        <br> 
        
        <div class="end">          
        <hr>
        <a href="index.htm">Back to Home Page..</a>
        </div>
    </body>
</html>
