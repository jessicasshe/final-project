/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
        System.out.println(name);
        String url = "jdbc:sqlite:" + name;
        conn = DriverManager.getConnection(url);
        System.out.println("Connection to SQLite has been established");
    }
    catch(SQLException e)
    {
        System.out.println(e.getMessage());
    }
    return conn;

    

}

}
