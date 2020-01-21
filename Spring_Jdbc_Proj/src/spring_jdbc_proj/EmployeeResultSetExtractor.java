package spring_jdbc_proj;
    
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class EmployeeResultSetExtractor implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet rs) throws SQLException 
    {
        Employee em = new Employee();
        em.setName(rs.getString(1));
        em.setAddress(rs.getString(2));
        
        return em;
    }
}