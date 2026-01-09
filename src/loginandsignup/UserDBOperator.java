package loginandsignup;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.File;
import java.sql.Blob;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class UserDBOperator {
    // find a cleaner way to get access to column values w/o having all as attributes
    Connection user_database;
    int user_id;
    String email;
    String password;
    String full_name; 
    
    PreparedStatement pstmt;
    ResultSet rs;
    
    String title;
    String author;
    String num_pages;
    File book_img_file;
    byte[] blob_file;
    
    // userbooks
    String page_progress;
    String shelf_type;
    String book_id;
    
}
    
    
    // don't pass in the values from login because its not guaranteed stuff will be entered; use SETTERS instead 
    
    public int setUserId(int user_id)
    {
        this.user_id = user_id;
        return this.user_id;
    }
    
    public int setPageProgress(int page_progress)
    {
        this.page_progress = page_progress;
        return this.page_progress;
    }
    
    public int setBookId(int book_id)
    {
        this.book_id = book_id;
        return this._book_id;
    }
    
    public int addBookToUserBooks()
    {
        try{
            pstmt = db_operator.prepareStatement("INSERT into UserBooks (user_id, page_progress, shelf_type, book_id) VALUES(?, ?, ?, ?) WHERE ");
            pstmt.setInt(1, user_id);
            pstmt.setInt(2, page_progress);
            pstmt.setString(3, shelf_type);
            pstmt.setInt(4, book_id);
            int id = pstmt.executeUpdate();
            return id;
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong while trying to add a book into user books");
            e.printStackTrace();
        }
        return -1;
    }

    public DefaultListModel<String> getCurrentlyReading(String shelf_type)
    {
        DefaultListModel<String> curr_books = new DefaultListModel<>();
        
        // join Users with UserBooks first 
        
        try
        {
            pstmt = user_database.prepareStatement("SELECT book_name FROM Books JOIN UserBooks WHERE Books.book_id = UserBooks.book_id AND UserBooks.shelf_type = ?");
            pstmt.setString(1, shelf_type);
            rs.executeQuery();
            // only get book_ids from the reading shelf 
            while(rs.next())
            {
                curr_books.addElement(rs.getString("book_name");
            }
            return curr_books;
        }
        catch{SQLException e)
        {
            System.out.println("Something went wrong while trying to query for current books");
            e.printStackTrace();
        }
        return null;
    }
    
    public DefaultListModel<String> getBookNames() // used for SEARCH books available already
    {
        DefaultListModel<String> book_names = new DefaultListModel<>();        
        try{ 
            pstmt = user_database.prepareStatement("SELECT book_name FROM Books"); // change logic later for userbooks
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                System.out.println("Book being added is called: " + rs.getString("book_name"));
                book_names.addElement(rs.getString("book_name"));           
            }    public DefaultListModel<String> getBookNames() // used for SEARCH, temp for users curr reading list  

            return book_names;
        }
        
        catch(SQLException e)
        {
            System.out.println("Something went wrong when querying from the book database");
            e.printStackTrace();
        }
        return null;
    }
    
    public ResultSet getFullBookDetails()
    {
        try{
            pstmt = user_database.prepareStatement("SELECT * from Books INNER JOIN UserBooks WHERE Books.book_id = UserBooks.book_id ")
        }
    }
        
    public File setImageIcon(File img_file)
    {
        // change to BLOB file type 
        book_img_file = img_file;
        return book_img_file;
    }
    
    public byte[] setBLOBImageFile(byte[] file)
    {
        blob_file = file;
        return blob_file;
    }
            
    public String setTitle(String title)
    {
        this.title = title;
        return this.title;
    }
    
    public String setAuthor(String author)
    {
        this.author = author;
        return this.author;
    }
    
    public String setNumPages(String num_pages)
    {
        this.num_pages = num_pages;
        return this.num_pages;
    }
    
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
        pstmt = null; // reused for queries
        rs = null; // reused for queries 
    }
    
    // RETURNS: user id 
    public int FindExistingUser() // returns the user ID for usage throughout the program
    {
            try{
                pstmt = user_database.prepareStatement("SELECT * from Users where email= ? and password = ?");
                pstmt.setString(1, email);
                pstmt.setString(2, password);
                rs = pstmt.executeQuery();

                if(rs.next()) // a row exists -> match found
                {
                   try{
                   
                       user_id = rs.getInt("user_id");
                       pstmt.close();
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
                    pstmt.close();
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
            pstmt = user_database.prepareStatement(("INSERT into Users (name, email, password) VALUES(?, ?, ?, ?) RETURNING user_id"));
            pstmt.setString(1, full_name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.executeUpdate();
            rs = user_database.createStatement().executeQuery("SELECT last_insert_rowid()"); // returns a table with int of one row and one column 
            rs.next(); // read first row 
                
            user_id = rs.getInt("last_insert_rowid()"); // gives actual int value
            rs.close();
            pstmt.close();
            return user_id;
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong");
            e.printStackTrace();       
        }
        
        try{
            rs.close();
            pstmt.close();
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong while trying to close");
        }
        return 0;
    }
    
    public int createBook()
    {
        try{
            PreparedStatement pstmt = user_database.prepareStatement("INSERT into Books (book_name, author, num_pages, image) VALUES(?, ?, ?, ?)");
            pstmt.setBytes(4, blob_file);
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, num_pages);
 
            
            // call helper function to turn img file into BLOB
            System.out.println("Length of byte: " + blob_file.length);
            pstmt.executeUpdate();
            return 1; // book added successfully 
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong trying to insert books into the database");
            e.printStackTrace();
        }
        return 0; // error showed up 
    }
    
   public byte[] convertFiletoByte(File file) // returns the byte contents 
   {
       // use book_img_file
       try{
           FileInputStream input = new FileInputStream(file); // holds file contents
           return input.readAllBytes();  
        }  
        catch(IOException e)
        {
               System.out.println("Something went wrong while trying to convert the file");
               e.printStackTrace();
        }
       return null;
   }
   
    
   /* public byte[] getBLOBFile()
    {
        
    }
*/

}
