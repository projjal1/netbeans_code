package pack;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DataConect 
{
    public static Connection initialize()throws ClassNotFoundException,SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","");
        return c;
    }
}
