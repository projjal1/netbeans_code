import pack.DataConect;
import pack.Pojo;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;

public class EmpDao 
{
    public static int insert(Pojo e)
    {                
        String n=e.getName();
        String ad=e.getAddress();
        int s=0;
        
        try
        {
            Connection c=DataConect.initialize();
            PreparedStatement p=c.prepareStatement("insert into Docs(name,address) values(?,?)");
            p.setString(1,n);
            p.setString(2,ad);
            
            s=p.executeUpdate();
            
            c.close();
        }
        catch(Exception exp)
        {
            
        }
        
        return s;
    }
    
    public static List<Pojo> fetch()
    {
        List<Pojo> l=new ArrayList<Pojo>();
        try
        {
            Connection c=DataConect.initialize();
            PreparedStatement ps=c.prepareStatement("select * from Docs");
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
                Pojo o=new Pojo();
                o.setId(rs.getInt(1));
                o.setName(rs.getString(2));
                o.setAddress(rs.getString(3));
                l.add(o);
            }           
            c.close();
        }
        catch(Exception exp)
        {
            
        }
        return l;        
    }
    
    public static int delete(int id)
    {
        int st=0;
        try
        {
            Connection c=DataConect.initialize();
            PreparedStatement ps=c.prepareStatement("delete from Docs where id=?");
            ps.setInt(1,id);
            st=ps.executeUpdate();
            c.close();
        }
        catch(Exception exp){}
        return st;
    }
    
    public static Pojo fetch(int id)
    {
        Pojo obj=new Pojo();
        try
        {
            Connection c=DataConect.initialize();
            PreparedStatement ps=c.prepareStatement("select * from Docs where id=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
                obj.setId(rs.getInt(1));
                obj.setName(rs.getString(2));
                obj.setAddress(rs.getString(3));
            }
            c.close();
        }
        catch(Exception exp){}
        
        return obj;
    }
    
    public static int update(Pojo e)
    {
        int status=0;
        try
        {
            Connection c=DataConect.initialize();
            PreparedStatement ps=c.prepareStatement("update Docs set name=?,address=? where id=?");
            ps.setString(1,e.getName());
            ps.setString(2,e.getAddress());
            ps.setInt(3,e.getId());
            
            status=ps.executeUpdate();
            c.close();
        }
        catch(Exception exp){}
        return status;
    }
}
