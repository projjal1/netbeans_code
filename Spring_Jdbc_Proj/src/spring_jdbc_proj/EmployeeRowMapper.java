package spring_jdbc_proj;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper 
{
    @Override
    public Object mapRow(ResultSet rs, int line) throws SQLException 
    {
        EmployeeResultSetExtractor extractor = new EmployeeResultSetExtractor();
        return extractor.extractData(rs);
    }

}