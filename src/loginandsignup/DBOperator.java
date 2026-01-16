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
import java.util.ArrayList;

public class DBOperator {
    // variables are given values using the setter methods 
    
    
    private WindowManager manager;
    // REPLACE THESE WITH A USER OBJECT 
    private User user;
    int user_id;
    String email = "jshe1@ocdsb.ca";
    String password = "123";
    String full_name; 
    String user_type;
    
    String title;
    String author;
    int num_pages;
    int num_users_read;
    byte[] blob_file;
    
    int page_progress;
    String shelf_type;
    int book_id;    
    
    public WindowManager setManager(WindowManager manager)
    {
        this.manager = manager;
        return this.manager;
    }
    
    public User getUser()
    {
        return user;
    }
    
    public User setUser(User user){
        this.user = user;
        return this.user;
    }
   
     
    public String setShelfType(String shelf_name)
    {
        shelf_type = shelf_name;
        return shelf_type;
    }
    
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
    
    public Connection newConnection()
    {
      return manager.getConnector().connect();
    }
    
    /*
    Returns an ArrayList of note objects for a users given book
    */
    /*
    public ArrayList<Note> getAllBookNotes(Book book)
    {
        // get resultset of all notes with user id, book id
    
        
    }
    
    
    /*
    Called from the ReadingNotes window to add a new note to the databaase
    @ param: local note object to get attribute values
    @ return: 1 for success, 0 else, -1 exception
    */
    public int addNewNote(Note note)
    {
        try(Connection conn = newConnection(); 
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ReadingNotes (user_id, book_id, last_edited_date, chapter, text) VALUES(?, ?, ?, ?, ?) ON CONFLICT(user_id, book_id, chapter) DO NOTHING"))
        {
            pstmt.setInt(1, user.getUserId());
            pstmt.setInt(2, note.getBook().getBookId());
            pstmt.setString(3, note.getLastEditedDate());
            pstmt.setInt(4, note.getChapterNum());
            pstmt.setString(5, note.getText());
            
            int val = pstmt.executeUpdate();
            if(val == 1)
            {
                return val;
            }
            return 0;
                   
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong when creating a new note...");
            e.printStackTrace();
        }
        return -1;
    }
    
    public int saveNote(Note note)
    {
        try(Connection conn = newConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE ReadingNotes SET last_edited_date = ?, text = ? WHERE user_id = ? AND  book_id = ? AND  chapter = ? "))
        {
            pstmt.setString(1, note.getLastEditedDate());
            pstmt.setString(2, note.getText());
            pstmt.setInt(3, user.getUserId());
            pstmt.setInt(4, note.getBook().getBookId());

            pstmt.setInt(5, note.getChapterNum());
            int val = pstmt.executeUpdate();
            if(val == 1)
            {
                return val;
            }
            return 0;
            
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong while saving note");
            e.printStackTrace();
        }
        return -1;
    }
    
    
    /* 
    Called from the SingleBookInfo window. Updates the column values specifically in Books for a selected book.
    @param: none, used setter methods to edit column values 
    @return: 1 if updated/no conflict, 2 if duplicate exists, -1 if exception raised
    */
    public int updateBooksColumns()
    {
        try(Connection conn = newConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE OR IGNORE Books SET author = ?, book_name = ? , total_users_read = ?, image = ? , num_pages = ? WHERE book_id = ? ")
            ){
            
            pstmt.setString(1, author);
            pstmt.setString(2, title);
            pstmt.setInt(3, num_users_read);
            pstmt.setBytes(4, blob_file);
            pstmt.setInt(5, num_pages);
            pstmt.setInt(6, book_id);
            int value = pstmt.executeUpdate();
            System.out.println(value);
            return value; 
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong when trying to update book information in Books");
            e.printStackTrace();
        }
        return -1;
    }
    
    
    /*
    Called from SingleBookWindow. Updates the columns in UsersBooks based on the edits the user made.
    @ return 1 if updated, 0 if conflict,  -1 if an exception was raised.
    */        
    public int updateUsersBooksColumns()
    {
        try(Connection conn = newConnection(); PreparedStatement pstmt = conn.prepareStatement("UPDATE OR IGNORE UsersBooks SET page_progress = ?, shelf_type = ? WHERE book_id = ?"))
        {
            
            pstmt.setInt(1, page_progress);
            pstmt.setString(2, shelf_type);
            pstmt.setInt(3, book_id);
            int updated_val = pstmt.executeUpdate();
            System.out.println(updated_val);
            return updated_val; // change later
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong when updating book info in UsersBooks");
            e.printStackTrace();
        }
        return -1;
    }
    /*
    Called from SearchBook wundow. 
    @ param: search type ('Title' or 'Author') based on what the user clicked
    @ return: an ArrayList with the names of the books that match the search
    */
    
    public ArrayList<String> getSearchResults(String search_type)
    {
        ArrayList<String> book_names = new ArrayList<>();
        try(Connection conn = newConnection(); PreparedStatement pstmt = conn.prepareStatement("SELECT book_name FROM Books where "+search_type+" = ?"))
        {
            switch(search_type)
            {   
                case "Author":
                    System.out.println("Searching by author..");
                    pstmt.setString(1,author);
                    break;

                case "Title":
                    System.out.println("Searching by title...");
                    pstmt.setString(1, title);
                    break;
            }
            try(ResultSet rs = pstmt.executeQuery())
            {
            
                while(rs.next())
                {
                    book_names.add(rs.getString("book_name"));
                }
                return book_names;
            }
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong when searching for books");
            e.printStackTrace();
        }
        return null;
    }
    
    /*
    
    */
    
    public int addBookToUserBooks(ResultSet details) // already given the row itself so it isnt necessary to set the attribute variables
    {
        try(Connection conn = newConnection(); PreparedStatement pstmt = conn.prepareStatement("INSERT OR IGNORE into UsersBooks (user_id, page_progress, shelf_type, book_id) VALUES(?, ?, ?, ?)"))
        {
            pstmt.setInt(1, user_id);
            pstmt.setInt(2, page_progress);
            pstmt.setString(3, shelf_type);
            pstmt.setInt(4, book_id);
            int value = pstmt.executeUpdate();
            return value;
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong while trying to add a book into user books");
            e.printStackTrace();
        }
        return -1;
    }


    public DefaultListModel<String> getBookNames(String shelf_type) // overloaded method for search on collection list
    {
        DefaultListModel<String> curr_books = new DefaultListModel<>();
        
        // join Users with UserBooks first, configure for ClubBooks 
        
        try(Connection conn = newConnection(); PreparedStatement pstmt = conn.prepareStatement("SELECT book_name FROM Books JOIN UsersBooks ON Books.book_id = UsersBooks.book_id WHERE shelf_type = ?"))
        {
            pstmt.setString(1, shelf_type);
            try(ResultSet rs = pstmt.executeQuery())
            {
                while(rs.next())
                {
                    curr_books.addElement(rs.getString("book_name"));

                }
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
    
    public DefaultListModel<String> getBookNames() 
    {
        DefaultListModel<String> book_names = new DefaultListModel<>();        
        try(Connection conn = newConnection(); PreparedStatement pstmt = conn.prepareStatement("SELECT book_name FROM Books")) 
        { 
            try(ResultSet rs = pstmt.executeQuery())
            {
                while(rs.next())
                {
                    System.out.println("Book being added is called: " + rs.getString("book_name"));
                    book_names.addElement(rs.getString("book_name"));           
                }
                return book_names;
            }
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong when querying from the book database");
            e.printStackTrace();
            return null;
        }
    }
   
    public String getSingleBookName(ResultSet book_row)
    {
        try
        {
            return book_row.getString("book_name");
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong when reading book name from row");
            e.printStackTrace();
        }
        return null;   
    }
        
    public int getBookId(String name)
    {
        try(Connection conn = newConnection(); PreparedStatement pstmt = conn.prepareStatement("SELECT book_id from Books WHERE book_name = '"+name+"'"))
        {
            try(ResultSet rs = pstmt.executeQuery())
            {
                return rs.getInt("book_id");
            }
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong querying for the book_id");
            e.printStackTrace();
        }
        return -1; 
    }
    
    
    /*
    Called from SingleBookInfo to get the full row of a book (Joined with user_id)
    @ param: book_id of book being viewed
    @ return: Book with attributes of column values of the resultset of the book 
    */
    
    public Book getFullBookDetails(int book_id) 
    {
        // split the method into 2: one to check if book exists (use in createbook) then one to create the object
        try(Connection conn = newConnection(); PreparedStatement pstmt = conn.prepareStatement("SELECT * from Books WHERE Books.book_id ="+book_id))
        {
            // left join (Books table) because some books might not belong to the user yet      
            try(ResultSet rs = pstmt.executeQuery())
            {
                if(rs.next())
                {     // printing for debugging purposes 

                    System.out.println("ResultSet Book Info: ");
                    System.out.println("Book ID: " + rs.getInt("book_id"));
                    System.out.println("Book name" + rs.getString("book_name"));
                    System.out.println("Book author" + rs.getString("author"));
                    System.out.println("Num. pages" + rs.getInt("num_pages"));
                    System.out.println("Total users read" + rs.getInt("total_users_read"));
                    if(rs.getBytes("image") != null)
                    {
                        System.out.println("A book cover exists!");
                    }
                    else
                    {
                        System.out.println("No picture available");
                    }
                    
                    Book book = new Book(rs.getInt("book_id"), rs.getString("book_name"), rs.getString("author"), rs.getInt("num_pages"), rs.getInt("total_users_read"), rs.getBytes("image"));
                    return book;
                }
            }
        }
        
        catch(SQLException e)
        {
            System.out.println("Something went wrong while trying to get the full book details");
            e.printStackTrace();
        }
        return null;
    }
    
    public UserBook getUsersBooksDetails(int book_id)
    {
        try(Connection conn = newConnection(); PreparedStatement pstmt = conn.prepareStatement("SELECT * from UsersBooks INNER JOIN Books ON Books.book_id = UsersBooks.book_id WHERE Books.book_id ="+book_id))
        {
            // left join (Books table) because some books might not belong to the user yet      
            try(ResultSet rs = pstmt.executeQuery())
            {
                if(rs.next())
                {     // printing for debugging purposes 

                    
                    System.out.println("ResultSet UserBook Info: ");
                    System.out.println("Page progress " + rs.getInt("page_progress"));
                    System.out.println("Shelf type" + rs.getString("shelf_type"));
                    if(rs.getBytes("image") != null)
                    {
                        System.out.println("A book cover exists!");
                    }
                    else
                    {
                        System.out.println("No picture available");
                    }
                    
                    UserBook user_book = new UserBook(user, rs.getInt("book_id"), rs.getString("book_name"), rs.getString("author"), rs.getInt("num_pages"), rs.getInt("total_users_read"), rs.getBytes("image"));

                    return user_book;
                }
            }
        }
       
        catch(SQLException e)
        {
            System.out.println("Something went wrong while trying to get the full book details");
            e.printStackTrace();
        }
        return null;
    }
    
   /*
    Called from SingleBookWindow to decide which buttons to display 
    @ param: book_id
    @ return: true if book exists, else false 
    
    */
    public boolean ExistsInUsersBooks(int book_id)  
    {
        try(Connection conn = newConnection(); PreparedStatement pstmt = conn.prepareStatement("SELECT 1 FROM Books INNER JOIN UsersBooks ON Books.book_id = UsersBooks.book_id WHERE Books.book_id = ?"))
        {
            pstmt.setInt(1, book_id);
            try(ResultSet rs = pstmt.executeQuery())
            {
                if(rs.next())
                {
                    return true;
                }
            }
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong trying to search for a book in UsersBooks");    
            
            e.printStackTrace();
        }
        return false;

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
    
    public int setNumPages(int num_pages)
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
                    
    /*
    Called in Login and Signup to check if a user already exists. In login, to validate credentials. In signup, to check if the signup is eligible 
    @ return: True if the user exists, false if user does not 
    */
    public boolean UserExists() 
    {
            try(Connection conn = newConnection(); PreparedStatement pstmt = conn.prepareStatement("SELECT * from Users where email= ?")){
                pstmt.setString(1, email);
                try(ResultSet rs = pstmt.executeQuery()){
                
                if(rs.next())
                {
                    return true;
                }
            }
            }
            catch(SQLException e)
            {
                System.out.println("Something has gone wrong.");
                e.printStackTrace();
            }
            return false; // unable to create new user
    }
    
    public User LoadExistingUser()
    {
        try(Connection conn = newConnection(); PreparedStatement pstmt = conn.prepareStatement("SELECT * from Users where email = ? and password = ?"))
        {
            pstmt.setString(1,email);
            pstmt.setString(2,password);
            try(ResultSet rs = pstmt.executeQuery())
            {
               rs.next();
               user = new User(rs.getInt("user_id"), rs.getString("user_type"), rs.getString("email"), rs.getString("password"), rs.getString("name"));
               return user;
            }
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong when loading the user");
            e.printStackTrace();
        }
        return null;
    }
    
    
    /*
    Called from the Signup Window 
    @ return: A new User object
    */
    public User CreateNewUser() 
    {
        try(Connection conn = newConnection(); PreparedStatement pstmt = conn.prepareStatement("INSERT into Users (name, email, password) VALUES(?, ?, ?) RETURNING user_id")) {
            pstmt.setString(1, full_name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            // update user type later
            int update = pstmt.executeUpdate();
            if(update == 1)
            {
                // Successful, create new user object with the row id 
                try(ResultSet rs = conn.createStatement().executeQuery("SELECT last_insert_rowid()")){
                    rs.next();
                    int user_id = rs.getInt("last_insert_rowid()"); // gives actual int value
                    user = new User(user_id, rs.getString("user_type"), rs.getString("email"), rs.getString("password"), rs.getString("name"));
                    return user;
                }
            }
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong");
            e.printStackTrace();       
        }
        return null;
    }
    
    
    
    public int createBook()
    {
        // verify if the book alr exists-> UNIQUE in sqlite
        try(Connection conn = newConnection(); PreparedStatement pstmt = conn.prepareStatement("INSERT or IGNORE into Books (book_name, author, num_pages, image) VALUES(?, ?, ?, ?)")){
            pstmt.setBytes(4, blob_file);
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setInt(3, num_pages);
 
            // call helper function to turn img file into BLOB
            System.out.println("Length of byte: " + blob_file.length);
            int val = pstmt.executeUpdate();
            if(val == 1) // book added successfully
            {
               
            }
            return 1; // book added successfully 
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong trying to insert books into the database");
            e.printStackTrace();
        }
        return 0; // error showed up 
    }
    
    // Why is this in DB operator? Add to SingleBookWindow
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
