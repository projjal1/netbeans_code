import com.Std;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Save extends HttpServlet 
{  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        Std e=new Std();
        e.setName(request.getParameter("name"));
        e.setPassword(request.getParameter("password"));
        e.setEmail(request.getParameter("email"));
        e.setCountry(request.getParameter("country"));
        
        int st=EmpDao.save(e);
        
        if(st>0)
        {
            out.println("<p>Successfully inserted data.</p>");
            request.getRequestDispatcher("index.html").include(request, response);
        }
        else 
        {
            out.println("Sorry, unable to process or insert the data");
        }
        
        out.close();
    }  
}
