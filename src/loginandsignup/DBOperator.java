package loginandsignup;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.File;
import java.sql.Blob;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ByteArrayInputStream;
import javax.swing.DefaultListModel;

public class DBOperator {
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
    int num_users_read;
    byte[] blob_file;
    
    // userbooks
    int page_progress;
    String shelf_type;
    int book_id;
    
    
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
        return this.book_id;
    }
    
    public int setNumUsersRead(int num_users)
    {
        num_users_read = num_users;
        return num_users_read;
    }
    
    public int addBookToUserBooks()
    {
        
        try{
            
            // check for duplication
            pstmt = user_database.prepareStatement("SELECT * from UsersBooks where user_id = ? AND page_progress = ? AND shelf_type = ? AND book_id = ? AND total_users_read = ?");
            pstmt.setInt(1, user_id);
            pstmt.setInt(2, page_progress);
            pstmt.setString(3, shelf_type);
            pstmt.setInt(4, book_id);
            pstmt.setInt(5, num_users_read);
            rs = pstmt.executeQuery();
            
            if(rs.next())
            {
                System.out.println("This book & its version already exists within the club");
                return 0;
            }

            // insertion once valid
            pstmt = user_database.prepareStatement("INSERT into UsersBooks (user_id, page_progress, shelf_type, book_id) VALUES(?, ?, ?, ?)");
            int id = pstmt.executeUpdate();
            pstmt.close();
            return id;
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong while trying to add a book into user books");
            e.printStackTrace();
        }
        return -1;
    }

    public DefaultListModel<String> getBookNames(String shelf_type) // overloaded method 
    {
        DefaultListModel<String> curr_books = new DefaultListModel<>();
        
        // join Users with UserBooks first 
        
        try
        {
            pstmt = user_database.prepareStatement("SELECT book_name FROM Books JOIN UsersBooks WHERE Books.book_id = UsersBooks.book_id AND UsersBooks.shelf_type = ?");
            pstmt.setString(1, shelf_type);
            rs = pstmt.executeQuery();

            // only get book_ids from the reading shelf 
            while(rs.next())
            {
                curr_books.addElement(rs.getString("book_name"));
            }
            return curr_books;
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong while trying to query for books in " + shelf_type);
            e.printStackTrace();
        }
        return null;
    }
    
    public DefaultListModel<String> getBookNames() // used for SEARCH books available already
    {
        DefaultListModel<String> book_names = new DefaultListModel<>();        
        try
        { 
            pstmt = user_database.prepareStatement("SELECT book_name FROM Books"); // change logic later for userbooks
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                System.out.println("Book being added is called: " + rs.getString("book_name"));
                book_names.addElement(rs.getString("book_name"));           
            }     
            return book_names;
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong when querying from the book database");
            e.printStackTrace();
        
        return null;
        }
    }
    
    public ResultSet getFullBookDetails(String book_name) // for individual book window
    {
        try
        {
            // left join (Books table) bc some books might not belong to the user yet
            pstmt = user_database.prepareStatement("SELECT * from Books LEFT JOIN UsersBooks WHERE Books.book_id = UsersBooks.book_id AND book_name = '"+book_name+"'");
            return pstmt.executeQuery(); // returns all book info personal to user & to general book
        }
        
        catch(SQLException e)
        {
            System.out.println("Something went wrong while trying to get the full book details");
            e.printStackTrace();
        }
        return null;
    }
       
    
    public byte[] setBLOBImageFile(byte[] file) // where is this being called? check later
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
                
    public DBOperator(Connection user_db)
    {
        user_database = user_db;
        pstmt = null; // reused for queries
        rs = null; // reused for queries 
    }
    
    // RETURNS: user id 
    public int FindExistingUser() 
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
                pstmt.close();
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
        // verify if the book alr exists-> UNIQUE in sqlite
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
   
  /* public File convertBytetoFile(byte[] img_byte)
   {
       try{
           ByteArrayInputStream byte_input = new ByteArrayInputStream(img_byte);
           return byte_input.
       }
   }
*/
}
