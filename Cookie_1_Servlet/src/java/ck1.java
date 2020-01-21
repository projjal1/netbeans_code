
  
  import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
  
  
public class ck1 extends HttpServlet {  
  
  public void doPost(HttpServletRequest request, HttpServletResponse response){  
    try{  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("userName");  
    out.print("Welcome "+n);  
    Cookie ck=new Cookie("uname",n);//creating cookie object  
    ck.setMaxAge(60*60*60);
    response.addCookie(ck);//adding cookie in the response  
  
    //creating submit button  
    out.print("<form action='ck2' method ='post'>");
    out.print("<input type='submit' value='go'>");  
    out.print("</form>");  
          
    out.close();  
  
        }catch(Exception e){System.out.println(e);}  
  }  
}  