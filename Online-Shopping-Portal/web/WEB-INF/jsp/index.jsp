<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Shopping Server</title>
    </head>
    <style>
        .topnav
        {
            background: bisque;
            overflow:hidden;
            height:30px;
        }
        .topnav :hover
        {
            color:red;
        }
        .topnav a
        {
            text-decoration: none;
        }
        
    </style>
  
    <div class="topnav">
        <a href="index.htm">Home</a>
        &nbsp;
        <% 
            HttpSession sess=request.getSession(false);  //Prevents the creation of new session
            String myName=(String)sess.getAttribute("uname");
            
            if (myName!=null)
            { %>
            &emsp;
            <%= myName %>
            &emsp;
            <a href="logout.htm">Logout</a>
            &emsp;
            <a href="orders.htm">Orders</a>
            &emsp;
            <a href="sell.htm">Sell</a>
            &emsp;
            <a href="items.htm">My Items</a>
            &emsp;
            <a href="shop.htm">Shop</a>
            &emsp;
            <a href="notifications.htm">Notifications</a>
            &emsp;
            <a href="wallet.htm">Wallet</a>
            <% } 
            else 
            { %>
            &emsp;
            <a href="signup.htm">Sign Up</a>
            &emsp;
            <a href="login.htm">Login</a>
            <% } %>    
    </div>
    
    <body>
        <hr>
        <p>${msg0}</p>
        <p>${msg}</p>
        <p>${msg1}</p>
        <p>${msg2}</p>

        <img alt="logo" src="https://homebusinessmag.com/wp-content/uploads/2017/06/photo_61712_20160305.jpg" height="600" width="1000" position="absolute">
    </body>
</html>
