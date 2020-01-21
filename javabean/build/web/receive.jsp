

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <jsp:useBean id="snr" class="pack.ValidateBean" />

  <jsp:setProperty name="snr" property="user" />
  <jsp:setProperty name="snr" property="pass" />

  You entered user name as <jsp:getProperty name="snr" property="user" /> <br>

  You entered user password as <jsp:getProperty name="snr" property="pass" /> <br>

  <br>

  You are a <%= snr.validate("Rao", "java") %> user.  <br>

  <b>Thank You</b>
    </body>
</html>
