<%-- 
    Document   : buy
    Created on : 7 Sep, 2019, 9:17:42 AM
    Author     : projjal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Place Order</title>
    </head>
    <body>
        <h1>Select Item and Place Order!</h1>
        <hr>
        <br>
        <img src="data:image/png;base64,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">
        <br>
        <p>${msg}</p>
        <br>
        <p>Name of commodity: ${name}</p>
        <p>Name of owner: ${owner}</p>
        <p>Type of commodity: ${type}</p>
        <p>Price of each item: ${price}</p>
        
        <form action="confirm.htm" method="POST">
            
        <p>Id of commodity: <input readonly type="number" name="id" value="${id}"></p>
        <p>Select quantity: <input name="quantity" id="qt" onkeypress="gettotal()" onkeyup="gettotal()" onclick="gettotal()" value="1" type="number" min="1" max=${qty}></p>
            
        <p>Grand Total</p>
        <p><input name="total" value="price" readonly type="number" id="tot" </p>
         
        <script>
            function 
            gettotal()
            {
                var x;
                x=document.getElementById("qt").value * ${price};
                document.getElementById("tot").value=x;
                if(x>${wallet})
                {
                    document.getElementById("button").setAttribute("hidden",true);
                    document.getElementById("label").removeAttribute("hidden");
                }
                else 
                {
                    document.getElementById("button").removeAttribute("hidden");
                    document.getElementById("label").setAttribute("hidden",true);
                }
            }
            
        </script>
        
        <br>
        <br>
        <br>
        <Label id="label" hidden>Insufficient balance. Add credit to your wallet.</Label>
        <input id="button" type="submit"  value="Proceed to buy">
        </form>
                
                <br>
                <br>
                <a href="shop.htm">Back ..</a>
   
    </body> 
</html>
