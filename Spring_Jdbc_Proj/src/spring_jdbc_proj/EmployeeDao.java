package spring_jdbc_proj;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;


public class EmployeeDao 
{
    public DataSource dataSource;
    public JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource ds)
    {
        dataSource=ds;
    }
    
    public void setJdbcTemplate(JdbcTemplate jd)
    {
        jdbcTemplate=jd;
    }
    
    public int saveEmployee(Employee e)
    {  
        String query="insert into registration(name,address) values('"+e.getId()+"','"+e.getName()+"','"+e.getAddress()+"')";  
        return jdbcTemplate.update(query);  
    }  

    public int updateEmployee(Employee e)
    {  
        String query="update registration set name='"+e.getName()+"',address='"+e.getAddress()+"' where id='"+e.getId()+"' ";  
        return jdbcTemplate.update(query);  
    }     
    
    public List<Employee> selectAll()
    {
        return jdbcTemplate.query("select name,address from registration",new EmployeeRowMapper());
    }
}
