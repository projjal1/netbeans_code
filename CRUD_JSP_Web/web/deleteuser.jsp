<%@page import="temp.UserDao"%>  
<jsp:useBean id="u" class="temp.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
UserDao.delete(u);  
response.sendRedirect("viewusers.jsp");  
%>  