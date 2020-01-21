package update_query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Update_Query 
{   
    public static void main(String[] args) 
    {        
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/sw_19", "root", "");
             
            stmt = connection.createStatement();    
            
            String sql = "UPDATE emp SET name=?, address=? WHERE id=?";
 
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "prakash");
            statement.setString(2, "Kolkata");
            statement.setInt(3, 2);

 
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) 
            {
                System.out.println("An existing user was updated successfully!");
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                stmt.close();
                connection.close();
           
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
