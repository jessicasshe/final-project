package loginandsignup;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DatabaseConnector {
    String name;
    // pass in the required database to connect to?
    
public DatabaseConnector(String name){
    this.name = name; 
   }

public Connection connect(){
    Connection conn = null;
    try {
        //System.out.println(name);
        String url = "jdbc:sqlite:" + name;
        conn = DriverManager.getConnection(url);
    }
    catch(SQLException e)
    {
        System.out.println(e.getMessage());
    }
    return conn;

    

}

}
