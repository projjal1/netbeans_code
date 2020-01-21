import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
  
public class servlet2 extends HttpServlet 
{ 
  
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
    {
        try { 
        /*Declaration of the get method*/
        response.setContentType("text/html"); 
        PrintWriter out = response.getWriter(); 
  
        HttpSession session = request.getSession(false); 
        /*Resuming the session created  
                                        in the previous servlet using  
                                        the same method that was used 
                                        to create the session.  
                                        The boolean parameter 'false' 
                                        has been passed so that a new session 
                                        is not created since the session already 
                                        exists*/
  
        String n = (String)session.getAttribute("uname"); 
        out.print("Hello " + n); 
        session.setMaxInactiveInterval(10);//Second
        out.close(); 
    } 
    catch (Exception e) { 
        System.out.println(e); 
    } 
} 
} 