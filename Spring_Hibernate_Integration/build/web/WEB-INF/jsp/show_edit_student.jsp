
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<center>
    <div id="home-sec">

   
    <h1>${message}</h1><br>
        <c:choose>
            <c:when test="${not empty us}">
                <div id="search_id" >
                <form action="updateeditstudent.htm" method="post">
                   <table id="t1" border="1" style="font-family:Georgia, Garamond, Serif;color:red;font-style:italic;">
                    <c:forEach items="${us}" var="ur">
                                          <tr>
                    
                    <tr>
                         <td>ID</td>
                         <td><input type="text" name="idd" value="${ur.id}"></td>
                     </tr>
                      <tr>
                         <td>Name</td>
                         <td><input type="text" name="nm" value="${ur.name}"></td>
                     </tr>
                     <tr>
                         <td>Address</td>
                         <td><input type="text" name="add" value="${ur.address}"></td>
                     </tr>
                    
                     <tr>
                         <td>phn</td>
                         <td><input type="text" name="phn" value="${ur.phNo}"></td>
                     </tr>
                    
                     
                 </c:forEach>
                 </table><br/>
                    <input type="submit" value="Update">
                 </form>
                </div>  
            </c:when>
            <c:otherwise>
                <h1>No such record found</h1>
            </c:otherwise>
        </c:choose>
        
      
         <a href="index.htm">Click Here</a> to get Home Page.
        </center>