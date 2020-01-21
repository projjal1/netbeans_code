import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import pack.Pojo;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("View")
public class View extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        List<Pojo> l=EmpDao.fetch();
        out.println("<a href='index.html'>Add New Employee</a>");  
        out.println("<br><br>");
        out.println("<table border='1' width='100%' align=center>");
        out.println("<tr><th>Id</th><th>Name</th><th>Address</th><th>Delete</th><th>Update</th></tr>");
        
        for(Pojo obj:l)
        {
            out.print("<tr>");
            out.print("<td>"+obj.getId()+"</td>+<td>"+obj.getName()+"</td><td>"+obj.getAddress()+"</td>");
            out.print("<td><a href=Delete?id="+obj.getId()+">Delete record</a>");
            out.print("<td><a href=Update?id="+obj.getId()+">Edit record</a>");
            out.println("</tr>");
        }
        
        out.println("</table>");
    }
}
