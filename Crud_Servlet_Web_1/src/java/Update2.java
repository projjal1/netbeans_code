import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import pack.Pojo;

@WebServlet("Update2")
public class Update2 extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        Pojo e=new Pojo();
        e.setId(Integer.parseInt(request.getParameter("id")));
        e.setName(request.getParameter("nm"));
        e.setAddress(request.getParameter("add"));
        
        int s=EmpDao.update(e);
        
        if(s>0)
            out.println("Updated..");
        else    
            out.println("Error..");
        request.getRequestDispatcher("index.html").include(request, response);
    }
}
