import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Insert_data {
    
    public static void main(String[] args) {
        Connection con= null;
        Statement st= null;
        ResultSet rs= null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/SW_19", "root", "");
            st= con.createStatement();
            st.execute("INSERT INTO emp(name, address) VALUES('Alolika', 'Kolkata')");
        }
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
