<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<center>
    <div id="home-sec">

   
   <h1>${message}</h1><br>
        <table id="t1" border="1" style="font-family:Georgia, Garamond, Serif;font-style:italic;">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Address</th>
                 <th>Phone No.</th>
                 <th>Select</th>
                
            </tr>
            <c:forEach items="${us}" var="user">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.address}"/></td>
                <td><c:out value="${user.phNo}"/></td>
                <td><a href="editstudent.htm?id=${user.id}"><font color="red">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
         </div>
        </center>