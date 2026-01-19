package code_files;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import java.util.ArrayList;

public class DBOperator {
   
    private WindowManager manager;
    // REPLACE THESE WITH A USER OBJECT 
    private User user;
    
    public DBOperator(WindowManager manager)
    {
        this.manager = manager;
    }
    
    public DBOperator()
    {
        
    }
    
    public WindowManager setManager(WindowManager manager)
    {
        this.manager = manager;
        return this.manager;
    }
    
    public User getUser()
    {
        return user;
    }
    
    /*
    Used for when you want to access the name of the author who last edited an announcement
    */
    public String getUserName(int user_id)
    {
        try(Connection conn = newConnection(); 
            // get the most recent announcement created 
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Users WHERE user_id = ?"))
        {
            pstmt.setInt(1, user_id);
            try(ResultSet rs = pstmt.executeQuery())
            {
                return rs.getString("name");
            }
                   
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public User setUser(User user){
        this.user = user;
        return this.user;
    }
   
    
    public Connection newConnection()
    {
      return manager.getConnector().connect();
    }
   
    public Announcement loadAnnouncement()
    {
        try(Connection conn = newConnection(); 
            // get the most recent announcement created 
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Announcements ORDER BY date DESC LIMIT 1"))
        {
            try(ResultSet rs = pstmt.executeQuery())
            {
                Announcement announcement = new Announcement(rs.getInt("user_id"), rs.getString("text"), rs.getString("date"));
                return announcement;
            }
                   
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public int saveAnnouncement(Announcement announcement)
    {
        try(Connection conn = newConnection(); 
            // save a new announcement 
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Announcements (user_id, text, date) VALUES(?, ?, DATETIME('now', 'localtime'))"))
        {
            pstmt.setInt(1, user.getUserId());
            pstmt.setString(2, announcement.getText());
            
            int val = pstmt.executeUpdate();
            return val;
        }
                   
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    
    public int saveLink(String meeting_link)
    {
        // update the same row
         try(Connection conn = newConnection(); 
            // get the most recent announcement created 
            PreparedStatement pstmt = conn.prepareStatement("UPDATE FROM MeetingLinks (link) VALUES(?)"))
        {
            pstmt.setString(1, meeting_link);
            int val = pstmt.executeUpdate();
            return val;
                 
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    
    public String getLink()
    {
         try(Connection conn = newConnection(); 
            // get the most recent announcement created 
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM MeetingLinks LIMIT 1"))
        {
            try(ResultSet rs = pstmt.executeQuery())
            {
                String meeting_link = rs.getString("link");
                return meeting_link;
            }
                   
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public Note loadNote(Note note)
    {
         try(Connection conn = newConnection(); 
            PreparedStatement pstmt = conn.prepareStatement("SELECT * from ReadingNotes (last_edited_date, text) WHERE book_id = ? AND user_id = ?"))
        {
            pstmt.setInt(1, note.getBook().getBookId());
            pstmt.setInt(2, note.getUser().getUserId());
            
            try(ResultSet rs = pstmt.executeQuery())
            {
                note.setLastEditedDate("last_edited_date");
                note.setText("text");
                return note;
            }
         
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong when loading a note...");
            e.printStackTrace();
        }
        return null;
    }
            
    
    
    /*
    Called from the ReadingNotes window to add a new note to the databaase
    @ param: local note object to get attribute values
    @ return: 1 for success, 0 else, -1 exception
    */
    public int addNewNote(Note note)
    {
        try(Connection conn = newConnection(); 
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ReadingNotes (user_id, book_id, last_edited_date, chapter, text) VALUES(?, ?, DATETIME('now', 'localtime'), ?, ?) ON CONFLICT(user_id, book_id, chapter) DO NOTHING"))
        {
            pstmt.setInt(1, user.getUserId());
            pstmt.setInt(2, note.getBook().getBookId());
            pstmt.setInt(4, note.getChapterNum());
            pstmt.setString(5, note.getText());
            
            int val = pstmt.executeUpdate();
            return val;
                   
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong when creating a new note...");
            e.printStackTrace();
        }
        return -1;
    }
    
    /* 
    Called from the single book window after a user clicks save note 
    @ param : note object that needs to be updated 
    @ return : 1 if success, 0 if not, -1 for exception
    // where should i call the function to update the last edited? 
    
    */
    
    public int saveNote(Note note)
    {
        try(Connection conn = newConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE ReadingNotes SET last_edited_date = DATETIME('now', 'localtime'), text = ? WHERE user_id = ? AND  book_id = ? AND  chapter = ? "))
        {
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
    Called from the single note window 
    @ param : book_id, user_id, chapter from the original note object 
    @ return : an updated note object 
    */
 
    
    /* Called from ReadingNotes Window
    Queries the Notes database using the user and Book id to get a resultset of all the row objects sorted by chapter 
    Loop through the resultset to get the collection of notes 
    @ param : Book 
    @ return : ArrayList of Note objects
    
    
    */
    
    public ArrayList<Note> getNotes(Book book)
    {
        ArrayList<Note> notes = new ArrayList<>();
        try(Connection conn = newConnection();
                PreparedStatement pstmt = conn.prepareStatement("SELECT * from ReadingNotes WHERE book_id = ? AND user_id = ? ORDER BY chapter ASC"))
            
            {
                pstmt.setInt(1, book.getBookId());
                pstmt.setInt(2, user.getUserId());
                try(ResultSet rs = pstmt.executeQuery())
                {
                    while(rs.next())
                    {
                        notes.add(new Note(user, book, rs.getString("last_edited_date"), rs.getInt("chapter"), rs.getString("text")));
                    }
                    return notes;

                }
                
            }
       catch(SQLException e)
       {
           System.out.println("Something went wrong while searching for existing notes...");
           e.printStackTrace();
       }
        return null;
    }
    
    public int deleteNote(Note note)
    {
        try(Connection conn = newConnection();
                PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ReadingNotes WHERE book_id = ? AND user_id = ? AND chapter = ?"))
            {
                pstmt.setInt(1, note.getBook().getBookId());
                pstmt.setInt(2, user.getUserId());
                pstmt.setInt(3, note.getChapterNum());
                int val = pstmt.executeUpdate();
                return val;
            }
       catch(SQLException e)
       {
           System.out.println("Something went wrong while searching for existing notes...");
           e.printStackTrace();
       }
       return -1;
    }
    
    
   /* public DefaultListModel<String> getChapterList() 
    {
        
    }
    */
    
    /* 
    Called from the SingleBookInfo window. Updates the column values specifically in Books for a selected book.
    @param: none, used setter methods to edit column values 
    @return: 1 if updated/no conflict, 2 if duplicate exists, -1 if exception raised
    */
    public int updateBooksColumns(Book book)
    {
        try(Connection conn = newConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE OR IGNORE Books SET author = ?, book_name = ? , total_users_read = ?, image = ? , num_pages = ? WHERE book_id = ? ")
            ){
            
            pstmt.setString(1, book.getAuthor());
            pstmt.setString(2, book.getName());
            pstmt.setInt(3, book.getTotalUsersRead());
            pstmt.setBytes(4, book.getImage());
            pstmt.setInt(5, book.getNumPages());
            pstmt.setInt(6, book.getBookId());
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
    public int updateUsersBooksColumns(UserBook userbook)
    {
        try(Connection conn = newConnection(); PreparedStatement pstmt = conn.prepareStatement("UPDATE OR IGNORE UsersBooks SET page_progress = ?, shelf_type = ? WHERE book_id = ?"))
        {
            
            pstmt.setInt(1, userbook.getPageProgress());
            pstmt.setString(2, userbook.getShelfType());
            pstmt.setInt(3, userbook.getBookId());
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
    
    public ArrayList<String> getSearchResults(String search_type, String search_value)
    {
        ArrayList<String> book_names = new ArrayList<>();
        try(Connection conn = newConnection(); PreparedStatement pstmt = conn.prepareStatement("SELECT book_name FROM Books where "+search_type+" = ?"))
        {
            switch(search_type)
            {   
                case "author":
                    System.out.println("Searching by author..");
                    pstmt.setString(1, search_value);
                    break;

                case "book_name":
                    System.out.println("Searching by title...");
                    pstmt.setString(1, search_value);
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
    
    public int addBookToUserBooks(Book book, String shelf) 
    {
        // unique index for(book_id, user_id) created to find the existing dupe
        try(Connection conn = newConnection(); PreparedStatement pstmt = conn.prepareStatement("INSERT into UsersBooks (user_id, page_progress, shelf_type, book_id) VALUES(?, ?, ?, ?) ON CONFLICT(user_id, book_id) DO NOTHING"))
        {
            pstmt.setInt(1, user.getUserId());
            pstmt.setInt(2, 0);
            pstmt.setString(3, shelf);
            pstmt.setInt(4, book.getBookId());
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
    
    public int removeBookFromUserBooks(UserBook user_book)
    {
        try(Connection conn = newConnection(); PreparedStatement pstmt = conn.prepareStatement("DELETE FROM UsersBooks WHERE user_id = ? AND page_progress = ? AND shelf_type = ? AND book_id = ?"))
        {
            
            pstmt.setInt(1, user.getUserId());
            
            
            pstmt.setInt(2, user_book.getPageProgress());
            
            
            pstmt.setString(3, user_book.getShelfType());
            
            pstmt.setInt(4, user_book.getBookId());
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
        
        try(Connection conn = newConnection(); PreparedStatement pstmt = conn.prepareStatement("SELECT book_name FROM Books JOIN UsersBooks ON Books.book_id = UsersBooks.book_id WHERE shelf_type = ? AND user_id = ?"))
        {
            pstmt.setString(1, shelf_type);
            pstmt.setInt(2, user.getUserId());
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
                    
                    UserBook user_book = new UserBook(user, rs.getInt("book_id"), rs.getString("book_name"), rs.getString("author"), rs.getInt("num_pages"), rs.getInt("total_users_read"), rs.getBytes("image"), rs.getInt("page_progress"), rs.getString("shelf_type"));

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
    
   
    /*
    Called in Login and Signup to check if a user already exists. In login, to validate credentials. In signup, to check if the signup is eligible 
    @ return: True if the user exists, false if user does not 
    */
    public boolean UserExists(User user) 
    {
            try(Connection conn = newConnection(); PreparedStatement pstmt = conn.prepareStatement("SELECT * from Users where email= ? AND password = ?")){
                pstmt.setString(1, user.getEmail());
                pstmt.setString(2, user.getPassword());
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
            return false; 
    }
    
    public User LoadExistingUser(User user)
    {
        try(Connection conn = newConnection(); PreparedStatement pstmt = conn.prepareStatement("SELECT * from Users where email = ? and password = ?"))
        {
            pstmt.setString(1,user.getEmail());
            pstmt.setString(2,user.getPassword());
            try(ResultSet rs = pstmt.executeQuery())
            {
               rs.next();
               user.setUserId(rs.getInt("user_id"));
               user.setUserType(rs.getString("user_type"));
               user.setName(rs.getString("name"));
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
    Called from the Signup Window to create a new user row 
    @ param: User object w/ default values
    @ return: update value (1= success, 0=fail, -1= exception)
    
    */
    public int CreateNewUser(User user) 
    {
        try(Connection conn = newConnection(); PreparedStatement pstmt = conn.prepareStatement("INSERT into Users (name, email, password) VALUES(?, ?, ?)")) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            // update user type later
            int update = pstmt.executeUpdate();
            return update;
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong");
            e.printStackTrace();       
        }
        return -1;
    }
    
    
    
    public int createBook(Book book)
    {
        // verify if the book alr exists-> UNIQUE in sqlite
        try(Connection conn = newConnection(); PreparedStatement pstmt = conn.prepareStatement("INSERT or IGNORE into Books (book_name, author, num_pages, image) VALUES(?, ?, ?, ?)")){
            pstmt.setBytes(4, book.getImage());
            pstmt.setString(1, book.getName());
            pstmt.setString(2, book.getAuthor());
            pstmt.setInt(3, book.getNumPages());
 
            int val = pstmt.executeUpdate();
            if(val == 1) // book added successfully
            {
               return 1;
            }
            else
            {
                return 0;
            }
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong trying to insert books into the database");
            e.printStackTrace();
        }
        return -1; // error showed up 
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
