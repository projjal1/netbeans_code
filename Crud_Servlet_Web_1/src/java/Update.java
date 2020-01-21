import java.io.IOException;
import java.io.PrintWriter;
import pack.Pojo;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("Update")
public class Update extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        
        int id=Integer.parseInt(request.getParameter("id"));
        
        Pojo e=EmpDao.fetch(id);
        out.println("<h1>Update Record</h1>");
        out.println("<form method='POST' action='Update2'>");
        out.println("<p><input hidden type='number' name='id' value="+e.getId()+"></p>");
        out.println("<p>Name: <input type='text' name='nm' value='"+e.getName()+"'></p>");
        out.println("<p>Address: <input type='text' name='add' value='"+e.getAddress()+"'></p>");
        out.println("<p><input type=submit value=Update></p>");
        out.println("</form>");
    }
}
