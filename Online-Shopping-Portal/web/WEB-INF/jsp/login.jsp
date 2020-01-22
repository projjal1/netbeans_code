<%-- 
    Document   : newjsplogin
    Created on : 6 Sep, 2019, 7:22:48 PM
    Author     : projjal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
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
            backface-visibility: visible;
            background-position-x: anything;
            background-color: yellowgreen;
        }
        .main
        {
            position: relative;
            height: 250px;
        }
        .end
        {
            position: relative;
        }
        .split
        {
            z-index: 0;
            position: absolute;
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
        .error
        {
            color:red;
        }
    </style>
    
    <body>
        <h1>Login!</h1>
        <hr>
        <br>
        <p class="error">${msg}</p>
        <br>
        <div class="main">
        <div class="split left">
        <form action="check.htm" method="POST">
            <table>
                <tr>
                    <td>name</td>
                    <td><input type="text" name="name" placeholder="Type username"></td>
                </tr>
                <tr>
                    <td>password</td>
                    <td><input type="password" name="password" placeholder="Type password"></td>
                </tr>
            </table>
            <br>
            <input type="submit" value="Login!">
        </form>
        </div>
            
        <div class="split right">    
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCe2FENKoZLX8LmsMyKnue-ppjJ_DoDOzVH4kiJWtg81G3u4Zq&s">
        </div>
        </div>
        
        <br>
        <br>
        
        <div class="end">
        <hr>
        <a id="back" href="index.htm">Back to home page..</a>
        </div>
        
    </body>
</html>
