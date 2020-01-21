<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>

<%
String fn=request.getParameter("name");
String pwd=request.getParameter("password");
String em=request.getParameter("email");
String cn=request.getParameter("country");

try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "");
Statement st=conn.createStatement();

int i=st.executeUpdate("insert into student(name,password,email,country)values('"+fn+"','"+pwd+"','"+em+"','"+cn+"')");
if(i>0)
out.println("Data is successfully inserted!");
else
 out.println("Wrong!");   
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>