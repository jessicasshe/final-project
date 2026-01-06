package loginandsignup;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class UserDBOperator {
    Connection user_database;
    int user_id;
    String email;
    String password;
    String full_name; 
    Statement stmt;
    ResultSet rs;
    
    // don't pass in the values from login because its not guaranteed stuff will be entered; use SETTERS instead 
    
    public String setEmail(String email)
    {
        this.email = email;
        return this.email;
    }
    
    public String setPassword(String pass)
    {
        password = pass;
        return password;
    };
    
    public String setName(String name)
    {
        full_name = name;
        return full_name;
    }
                
    public UserDBOperator(Connection user_db)
    {
        user_database = user_db;
        stmt = null; // reused for queries
        rs = null; // reused for queries 
    }
    
    // RETURNS: user id 
    public int FindExistingUser() // returns the user ID for usage throughout the program
    {
            try{
                stmt = user_database.createStatement();
                rs = stmt.executeQuery("select * from Users where email ='"+email+"' and password='"+password+"'");

                if(rs.next()) // a row exists -> match found
                {
                   try{
                   
                       user_id = rs.getInt("user_id");
                       stmt.close();
                       rs.close();

                       return user_id; // valid
                    }
                    catch(SQLException e)
                    {
                        System.out.println("Something went wrong while finding the user");
                        e.printStackTrace();
                    }
                }
                else
                {
                    System.out.println("No user found!");
                    stmt.close();
                    rs.close();
                    return 0; // no duplicate 
                }
            }
            catch(SQLException e)
            {
                System.out.println("Something has gone wrong.");
                e.printStackTrace();
            }
            
            try{
                stmt.close();
                rs.close();
            }
            catch(SQLException e)
            {
                System.out.println("Something went wrong while trying to close");
            }
            return -1; // exception
        }   
    
    public int CreateNewUser() // returns user id of a new user 
    {
        try{
            stmt = user_database.createStatement();
            stmt.executeUpdate("INSERT into Users (name, email, password) VALUES('"+full_name+"', '"+email+"', '"+password+"') RETURNING user_id");
            rs = user_database.createStatement().executeQuery("SELECT last_insert_rowid()"); // returns a table with int of one row and one column 
            rs.next(); // read first row 
                
            user_id = rs.getInt("last_insert_rowid()"); // gives actual int value
            rs.close();
            stmt.close();
            return user_id;
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong");
            e.printStackTrace();       
        }
        
        try{
            rs.close();
            stmt.close();
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong while trying to close");
        }
        return 0;
    }
    
}
