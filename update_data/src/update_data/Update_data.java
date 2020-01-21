import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Update_data {

    public static void main(String[] args) throws SQLException {
       Connection con= null;
        Statement st= null;
        ResultSet rs= null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/SW_19", "root", "");
            st= con.createStatement();
            String sql= "UPDATE emp SET name=?, address=?  WHERE roll=?";
            PreparedStatement statement= con.prepareStatement(sql);
            statement.setString(1, "kosturi");
            statement.setString(2, "howrah");
            statement.setInt(3, 1);
        
        int rowsUpdated = statement.executeUpdate();
if (rowsUpdated > 0) {
    System.out.println("An existing user was updated successfully!");
}}
            catch(Exception e)
                 {
                        e.printStackTrace();
                 }
        finally
                {
                  try{
                      st.close();
                      con.close();
                  }
                  catch(Exception e){
                       e.printStackTrace();
                  }
                }
    }
}
