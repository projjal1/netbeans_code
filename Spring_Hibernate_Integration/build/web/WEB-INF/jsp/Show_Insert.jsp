<%-- 
    Document   : Show_Insert
    Created on : 10 Aug, 2019, 10:18:34 AM
    Author     : SLC25
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${message}</h1><br>
   <form action="Succ_Insert.htm" method="get">
              <table id="t1" border="1" style="font-family:Georgia, Garamond, Serif;color:red;font-style:italic;">
            
          
            
            <tr>
                <td>Name</td>
                <td><input type="text" name="nm"></td>
            </tr>
             <tr>
                <td>User Name</td>
                <td><input type="text" name="un"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="pass"></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="ad"></td>
            </tr>
             <tr>
                <td>Phone No.</td>
                <td><input type="text" name="phno"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Register"></td>
            </tr> 
              </table>
        </form>
    </body>
</html>
