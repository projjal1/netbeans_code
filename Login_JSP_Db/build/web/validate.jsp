<%@ page import ="java.sql.*" %>
<%
    try{
        
        Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
      String dbDriver = "com.mysql.jdbc.Driver"; 
        String dbURL = "jdbc:mysql://localhost:3306/"; 
        // Database name to access 
        String dbName = "college"; 
        String dbUsername = "root"; 
        String dbPassword = ""; 
  
        Class.forName(dbDriver); 
        Connection conn = DriverManager.getConnection(dbURL + dbName, 
                                                     dbUsername,  
                                                     dbPassword); 
        
        String username = request.getParameter("username");   
        String password = request.getParameter("password");
        PreparedStatement pst = conn.prepareStatement("Select name,password from student where name=? and password=?");
        pst.setString(1, username);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();                        
        if(rs.next()){ %>         
        <h2>Valid login credentials </h2> 
              
       <% }else {%>
       <h2>Invalid login credentials</h2>          
  <% }
    }
   catch(Exception e){       
       out.println("Something went wrong !! Please try again");       
   }      
%>
