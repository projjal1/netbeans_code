import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pack.Pojo;
import javax.servlet.annotation.WebServlet;

@WebServlet("Insert")
public class Insert extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        Pojo e=new Pojo();
        e.setName(request.getParameter("name"));
        e.setAddress(request.getParameter("address"));
        
        int s=EmpDao.insert(e);
        
        if(s>0)
        {
            out.println("Inserted data..");
            request.getRequestDispatcher("index.html").include(request, response);
        }
        else 
        {
            out.println("Error, not inserted..");
            //request.getRequestDispatcher("index.html").include(request, response);
        }        
    }
}
