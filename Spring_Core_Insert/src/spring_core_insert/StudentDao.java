package spring_core_insert;

 
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
  
import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.PreparedStatementCallback;  
  
public class StudentDao 
{  
private JdbcTemplate jdbcTemplate;  
  
public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
    this.jdbcTemplate = jdbcTemplate;  
}  
  
public Boolean saveEmployeeByPreparedStatement(final Student e){  
    String query="insert into student(Name,Password,Email,Country) values(?,?,?,?)";  
    return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){  
  
    public Boolean doInPreparedStatement(PreparedStatement ps)  
            throws SQLException, DataAccessException {  
              
       
        ps.setString(1,e.getName());  
        ps.setString(2,e.getPassword()); 
         ps.setString(3,e.getEmail());
         ps.setString(4,e.getCountry());
              
        return ps.execute();  
              
    }  
    });  
}  
  
  
}  