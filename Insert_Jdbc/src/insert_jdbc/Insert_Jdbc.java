import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class Insert_Jdbc {
    public static void main(String[] args) {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/SW_19", "root", "");
             
            stmt = connection.createStatement();
           /* stmt.execute("INSERT INTO student (name,address) "
                                + "VALUES ('Alolika','Kolkata')");*/
             String sql = "SELECT id,name,address FROM emp";
         rs = stmt.executeQuery(sql);
      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("id");
         String nm = rs.getString("name");
         String addr = rs.getString("address");
        

         //Display values
         System.out.print("ID: " + id);
         System.out.print(", Name: " + nm);
         System.out.print(", Address: " + addr);
         System.out.println();
        
        }
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                stmt.close();
                connection.close();
           
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
