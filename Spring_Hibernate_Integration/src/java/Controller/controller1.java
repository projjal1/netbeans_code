
package Controller;

import org.springframework.stereotype.Controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.NewHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controller1
{
     //Show Registration page
    @RequestMapping("/regdisp") 
    public ModelAndView regdisp(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception 
    {
         ModelAndView mv = new ModelAndView("Show_Insert");
       String m="Registration Page";
       mv.addObject("message",m);
       return mv;
        
    }
     //Inser Data from Registration page
    @RequestMapping("/Succ_Insert") 
    public ModelAndView Succ_Insert(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception 
    {
       ModelAndView mv = new ModelAndView("Succ_Ins");
         String ins="Insert Successfully";
         
         String name=hsr.getParameter("nm");
         String uname=hsr.getParameter("un");
         String pass=hsr.getParameter("pass");
         String add=hsr.getParameter("ad");
         String ph=hsr.getParameter("phno");
         
         
         try 
          {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Model.Student mu=new Model.Student(uname, pass, name, add, ph);
            session.saveOrUpdate(mu);
            session.getTransaction().commit();
          mv.addObject("insert", ins);
          } 
         catch (HibernateException e) 
          {
            System.out.println("Error");
            e.printStackTrace();
          }     
        return mv;      
    }
    //Display all record from student table 
      @RequestMapping("/Disp_All") 
    public ModelAndView Disp_All(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception 
    {
          ModelAndView mv = new ModelAndView("show_student");
        String out = "All Student Details ";
        try {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List result = session.createQuery("from Student  ").list();
            mv.addObject("us", result);
            session.getTransaction().commit();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("message", out);
        return mv;      
    }
       //Show login page
     @RequestMapping("/logindisp") 
    public ModelAndView logindisp(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception 
    {
         ModelAndView mv = new ModelAndView("Show_Login");
       String m="Login Page";
       mv.addObject("message",m);
       return mv;
        
    }
      //Check Login from database
    @RequestMapping("/SuccLogin") 
    public ModelAndView SuccLogin(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception 
    {
          //ModelAndView mv = new ModelAndView("Home");
        
        ModelAndView mv = new ModelAndView("index");
         String lg="Login Successful";
         String uname=hsr.getParameter("un");
         String pass=hsr.getParameter("pass");
           

         
         try 
         {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List result=session.createQuery("from Student  where userName='"+uname+"' and password='"+pass+"'").list();        
            
            HttpSession s=hsr.getSession();
            s.setAttribute("un",uname);
            
            mv.addObject("sr", result);
            session.getTransaction().commit();
 
         } 
         catch (HibernateException e) 
         {
            System.out.println("Error");
            e.printStackTrace();
         }
         mv.addObject("succ_lg", lg);
         return mv;
        
    }
    
    
    //Edit particular record from show_student page
      @RequestMapping("/editstudent") 
    public ModelAndView editstudent(@RequestParam int id) {  
        String out="Edit Student Details";
        ModelAndView mv1 = new ModelAndView("show_edit_student");
        try{
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List result = session.createQuery("from Student where id='"+id+"'").list();
        mv1.addObject("us", result);
        session.getTransaction().commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        mv1.addObject("message", out);
        return mv1;
    }
      
      //Insert particular Edited data from show_edit_student page
      @RequestMapping("/updateeditstudent") 
    public ModelAndView updateeditstudent(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception 
    {
        ModelAndView mv = new ModelAndView(""
                + "");
        
        String idd=hsr.getParameter("idd");
        String uname=hsr.getParameter("nm");
        String add=hsr.getParameter("add");   
        String phn=hsr.getParameter("phn");
        try
        {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction t = session.getTransaction();
        t.begin();
        Query query = session.createQuery("update Student set name='"+uname+"', address='"+add+"', phNo='"+phn+"' where id='"+idd+"'");
        query.executeUpdate();
        t.commit();
        mv.addObject("pr_up", "Updated Successful.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return mv;
    }
}
