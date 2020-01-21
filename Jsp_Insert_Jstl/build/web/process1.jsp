<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<html>
   <head>
      <title>JSTL sql:update Tag</title>
   </head>

   <body>
    <title>Updating a database using the sql:update tag</title>
<sql:setDataSource var="dataSource" driver="com.mysql.jdbc.Driver"
url="jdbc:mysql://localhost:3306/college" user="root" password="" scope="session" />

     <c:catch var="exception">
<sql:update dataSource="${dataSource}" var="updatedTable">
INSERT INTO student (name,password,email,country) VALUES (?, ?, ?, ?)
<sql:param value="${param.name}" />
<sql:param value="${param.password}" />
<sql:param value="${param.email}" />
<sql:param value="${param.country}" />
</sql:update>
<c:if test="${updatedTable>=1}">
<font size="5" color='green'> Congratulations ! Data inserted
successfully.</font>
</c:if>
</c:catch>
<c:if test="${exception!=null}">
<c:out value="Unable to insert data in database." />
</c:if>