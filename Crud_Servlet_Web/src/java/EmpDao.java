import com.DataConnect;
import com.Std;
import java.sql.*;
import java.util.*;

public class EmpDao 
{
    Connection con=null;
    
    public static int save(Std e)
    {
        int status =0;
        
        try
        {
            Connection c=DataConnect.connect();
            PreparedStatement ps=c.prepareStatement("insert into Student(name,password,email,country) values(?,?,?,?)");
        
            ps.setString(1,e.getName());
            ps.setString(2,e.getPassword());
            ps.setString(3,e.getEmail());
            ps.setString(4,e.getCountry());
            status=ps.executeUpdate();
            
            c.close();
        }
        catch(Exception exp)
        {            
        }     
        return status;
    }
    
    public static List<Std> view()
    {
        List<Std> l=new ArrayList<Std>();
        try
        {
            Connection c=DataConnect.connect();
            PreparedStatement ps=c.prepareStatement("select * from Student");
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
                Std e=new Std();
                e.setId(Integer.parseInt(rs.getString(1)));
                e.setName(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setCountry(rs.getString(5));
                l.add(e);
            }
            c.close();
        }
        catch(Exception exp)
        {            
        }     
        
        return l;
    }
    
    public static Std getEmployeeById(int id)
    {
        Std e=new Std();
        try
        {
            Connection c=DataConnect.connect();
            PreparedStatement ps=c.prepareStatement("select * from Student where id=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setCountry(rs.getString(5));
            }
            
            c.close();
        }
        catch(Exception exp)
        {}
        return e;
    }
    public static int update(Std e){  
        int status=0;  
        try{  
            Connection con=DataConnect.connect();
            PreparedStatement ps=con.prepareStatement(  
                         "update Student set name=?,password=?,email=?,country=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getPassword());  
            ps.setString(3,e.getEmail());  
            ps.setString(4,e.getCountry());  
            ps.setInt(5,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }
        catch(Exception ex){}  
          
        return status;  
    }  
    public static int delete(int id)
    {
        int status=0;
        try
        {
            Connection c=DataConnect.connect();
            PreparedStatement ps=c.prepareStatement("delete from Student where id=?");
            ps.setInt(1,id);
            
            status=ps.executeUpdate();
            
            c.close();
        }
        catch(Exception exp){}
        
        return status;
    }
}
