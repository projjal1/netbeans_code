package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import Model.NewHibernateUtil;
import Model.User;
import java.io.IOException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import Model.Orders;
import Model.Objects;
import java.sql.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
import Model.Inbox;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("uname")
public class controller implements Serializable
{
    @RequestMapping("/sell")
    public ModelAndView sell(HttpServletRequest r)
    {
        ModelAndView o=new ModelAndView("sell");
        return o;
    }
    
    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest r)
    {
        ModelAndView o=new ModelAndView("index");
        r.getSession(false).invalidate();
        return o;
    }
    
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest r)
    {
        ModelAndView o=new ModelAndView("login");
        return o;
    }
    
    @RequestMapping("/signup")
    public ModelAndView signup(HttpServletRequest r)
    {
        ModelAndView o=new ModelAndView("signup");
        return o;
    }
    
    @RequestMapping("/change")
    public ModelAndView change(HttpServletRequest r)
    {
        ModelAndView o=new ModelAndView("edit");

        int id=Integer.parseInt(r.getParameter("id"));
        int qty=Integer.parseInt(r.getParameter("quantity"));
        int price=Integer.parseInt(r.getParameter("price"));
                
        Session s=NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        
        Query q=s.createQuery("update Objects set quantity='"+ qty +"' , price='"+price+"' where id='"+id+"'");
        q.executeUpdate();
        
        s.getTransaction().commit();
        
        o.addObject("msg","Item updated successfully!");
        return o;
    }
    
    @RequestMapping("/edit")
    public ModelAndView edit(@RequestParam("id") int id)
    {
        ModelAndView o=new ModelAndView("edit");

        Session s=NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List<Objects> ls=(List<Objects>)s.createQuery("from Objects where id='"+id+"'").list();
        
        for (Objects obj:ls)
        {
            o.addObject("id",obj.getId());
            o.addObject("name",obj.getName());
            o.addObject("qty",obj.getQuantity());
            o.addObject("price",obj.getPrice());
            o.addObject("type",obj.getType());
        }
        s.getTransaction().commit();
        return o;
    }
    
    @RequestMapping("/items")
    public ModelAndView items(HttpServletRequest r)
    {
        ModelAndView o=new ModelAndView("items");
        String nm=(String)r.getSession(false).getAttribute("uname");
        Session s=NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List ls=s.createQuery("from Objects where owner='"+nm+"'").list();
        o.addObject("list",ls);
        s.getTransaction().commit();
        return o;
    }
    
    @RequestMapping("/notifications")
    public ModelAndView notifications(HttpServletRequest r)
    {
        ModelAndView o=new ModelAndView("msgs");
        Session s=NewHibernateUtil.getSessionFactory().openSession();
        String nm=(String)r.getSession(false).getAttribute("uname");
        s.beginTransaction();
        List ls=s.createQuery("from Inbox where name='"+nm+"'").list();
        o.addObject("list",ls);
        s.getTransaction().commit();
        return o;
    }
    
    @RequestMapping("/orders")
    public ModelAndView orders(HttpServletRequest r)
    {
        ModelAndView o=new ModelAndView("order");
        Session s=NewHibernateUtil.getSessionFactory().openSession();
        String nm=(String)r.getSession(false).getAttribute("uname");
        s.beginTransaction();
        List ls=s.createQuery("from Orders where user='"+nm+"'").list();
        o.addObject("list",ls);
        s.getTransaction().commit();
        return o;
    }
    
    @RequestMapping("/confirm")
    public ModelAndView confirm(HttpServletRequest r)
    {
        ModelAndView o=new ModelAndView("succ_order");
        String nm=(String)r.getSession(false).getAttribute("uname");
        
        int id=Integer.parseInt(r.getParameter("id"));
        int quantity=Integer.parseInt(r.getParameter("quantity"));
        int price=Integer.parseInt(r.getParameter("total"));
        
        Session s=NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        
        //First fetch existing commodity details
        List<Objects> l=(List<Objects>)s.createQuery("from Objects where id='"+id+"'").list();
        
        s.getTransaction().commit();
        
        int qty=0;
        String owner="";
        String name="";
        
        for(Objects obj:l)
        {
            qty=obj.getQuantity();
            owner=obj.getOwner();
            name=obj.getName();
        }
        
        qty-=quantity;
        
        s=NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        
        Query q=s.createQuery("update Objects set quantity='"+qty +"' where id='"+id+"'");
        q.executeUpdate();
        
        s.getTransaction().commit();
        
        s=NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        
        //Now add a notification to owner about sale of his items
        String messg=quantity + " items of "+name+" has been sold. Amount has been credited";        
        Inbox i=new Inbox(owner,messg);
        s.save(i);
        
        s.getTransaction().commit();
        
       
        s=NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        
         //Add Amount to wallet of owner
        List<User> ls=(List<User>)s.createQuery("from User where name='"+owner+"'").list();
        int wallet=0;
        for(User obj:ls)
        {
            wallet=obj.getWallet();
        }
        wallet+=price;
        
        q=s.createQuery("update User set wallet='"+ wallet +"' where name='"+owner+"'");
        q.executeUpdate();
        
        s.getTransaction().commit();
        
        s=NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        
        //Deduct amount from wallet of user
        ls=(List<User>)s.createQuery("from User where name='"+nm+"'").list();
        wallet=0;
        for(User obj:ls)
        {
            wallet=obj.getWallet();
        }
        wallet-=price;
        
        q=s.createQuery("update User set wallet='"+ wallet +"' where name='"+nm+"'");
        q.executeUpdate();
        
        //Finally add item to Order page
        Orders or=new Orders(name,quantity,price,owner,nm) ;
        s.save(or);
        
        s.getTransaction().commit();
        
        o.addObject("msg","Order successfully placed!");
        return o;
    }
    
    
    @RequestMapping("/buy")
    public ModelAndView buy(@RequestParam("id") int id,HttpServletRequest r)
    {
        ModelAndView o=new ModelAndView("buy");
        String nm=(String)r.getSession(false).getAttribute("uname");
        Session s=NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List<Objects> ls=(List<Objects>)s.createQuery("from Objects where id='"+id+"'").list();
        for(Objects u:ls)
        {
            o.addObject("id",u.getId());
            o.addObject("qty",u.getQuantity());
            o.addObject("owner",u.getOwner());
            o.addObject("price",u.getPrice());
            o.addObject("type",u.getType());
            o.addObject("name",u.getName());
        }
        List<User> l =(List<User>)s.createQuery("from User where name ='"+nm+"'").list();
        for(User u:l)
        {
               o.addObject("wallet",u.getWallet());
        }
        s.getTransaction().commit();
        return o;
    }
    
    @RequestMapping("/wallet")
    public ModelAndView wallet(HttpServletRequest r)
    {
        ModelAndView o=new ModelAndView("wallet");
        String nm=(String)r.getSession(false).getAttribute("uname");
        try
        {
            Session s=NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
 
            if(r.getMethod().equals("POST")==true)
            { 
                List<User> l =(List<User>)s.createQuery("from User where name ='"+nm+"'").list();
                int id=0;
                int wallet=0;
                for(User u:l)
                {
                    id=u.getId();
                    wallet=u.getWallet();
                }
                int amt=Integer.parseInt(r.getParameter("amt"))+wallet;
                Query q=s.createQuery("update User set wallet='"+amt +"' where id='"+id+"'");
                q.executeUpdate();
                o.addObject("msg","Amount added to wallet successfully");
            }
            
            List ls =s.createQuery("from User where name ='"+nm+"'").list();
            o.addObject("list",ls);
            s.getTransaction().commit();   
        }
        catch(HibernateException e)
        {
            //Todo
        }
        return o;
    }
    
    @RequestMapping("/shop")
    public ModelAndView shop(HttpServletRequest r)
    {
        ModelAndView o=new ModelAndView("shop");
        
        try
        {
            Session s=NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            List ls =s.createQuery("from Objects").list();
            o.addObject("list",ls);
            s.getTransaction().commit();            
        }
        catch(HibernateException e)
        {
            //Todo
        }
        return o;
    }
    
    @RequestMapping("/choose")
    public ModelAndView choose(HttpServletRequest r)
    {
        ModelAndView o=new ModelAndView("shop");
        String type=r.getParameter("search");
        try
        {
            Session s=NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            List ls =s.createQuery("from Objects where type like '"+type+"'").list();
            o.addObject("list",ls);
            s.getTransaction().commit();            
        }
        catch(HibernateException e)
        {
            //Todo
        }
        return o;
    }
    
    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest r)
    {
        ModelAndView obj=new ModelAndView("sell");
        
        String nm=r.getParameter("name");        
        int qty=Integer.parseInt(r.getParameter("quantity"));
        int price=Integer.parseInt(r.getParameter("price"));
        String type=r.getParameter("type");        
        String owner = (String)r.getSession(false).getAttribute("uname");
        
        try
        {
            Session s=NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            Objects o=new Objects(nm,qty,owner,price,type);
            s.saveOrUpdate(o);
            s.getTransaction().commit();
            obj.addObject("msg","Item listed");
        }
        catch(HibernateException e)
        {
            obj.addObject("msg",e.getMessage());
        }
        return obj;
    }
    
    @RequestMapping("/add")
    public ModelAndView add(HttpServletRequest r)
    {
        
        String nm=r.getParameter("name");
        String pass=r.getParameter("password");
        String st=r.getParameter("status");
        try
        {
            Session s=(Session)NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            List ls=s.createQuery("from User where name='"+nm+"'").list();
            
            if(!ls.isEmpty())
            {
                ModelAndView o=new ModelAndView("signup");
                o.addObject("msg","User already present");
                s.getTransaction().commit();
                return o;          
            }
            else 
            {                
                ModelAndView o=new ModelAndView("index");
                User obj=new User(nm,pass,st,0);
                s.save(obj);
                s.getTransaction().commit();
                
                HttpSession sess=r.getSession(true);
                sess.setAttribute("uname", nm);
                return o;
            }
        }
        catch(HibernateException e)
        {
            e.printStackTrace();
        }
        ModelAndView o=new ModelAndView("index");
        return o;
    }
    
    @RequestMapping("/check")
    public ModelAndView check(HttpServletRequest r)
    {

        String nm=r.getParameter("name");
        String pass=r.getParameter("password");
        try
        {
            Session s=(Session)NewHibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            List ls=s.createQuery("from User where name='"+nm+"' and password='"+pass+"'").list();
            s.getTransaction().commit();
            
            if(!ls.isEmpty())
            {        
                ModelAndView o=new ModelAndView("index");
              
                HttpSession sess=r.getSession(true);
                sess.setAttribute("uname", nm);
                
                o.addObject("msg","User logged in ");
                return o;
            }
            else 
            {
                ModelAndView o=new ModelAndView("login");
                o.addObject("msg","User name or password is invalid");
                return o;
            }
        }
        catch(HibernateException e)
        {
            e.printStackTrace();
        }
         ModelAndView o=new ModelAndView("index");
         return o;
    }
}
