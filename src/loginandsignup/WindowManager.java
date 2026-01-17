package loginandsignup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class WindowManager {
    // has access to all windows to set visible 
    CreateBook create_book_window;
    SearchBook search_book_window;
    SingleBookInfo single_book_window;
    BookCollection book_collection_window;
    ReadingNotes reading_notes_window;
    SingleNote single_note_window;
    Login login_window;
    Signup signup_window;
    String previous_window;
    
    DatabaseConnector db_connector;
    DBOperator db_operator;
    
    public WindowManager(DatabaseConnector connector, DBOperator db_operator)
    {
       db_connector = connector;
       this.db_operator = db_operator;
        
    }
    
    public void showErrorMessage(JOptionPane option_pane, String message)
    {
        option_pane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public String showInputMessage(JOptionPane option_pane, String message)
    {
        return option_pane.showInputDialog(null, message, "Edit Value", JOptionPane.PLAIN_MESSAGE);
    }
    
    public void showWarningMessage(JOptionPane option_pane, String message)
    {
        option_pane.showMessageDialog(null, message, "Warning!", JOptionPane.WARNING_MESSAGE);
    }
    
    public int showConfirmMessage(JOptionPane option_pane, String message)
    {
        return option_pane.showConfirmDialog(null, message, "Confirm", JOptionPane.OK_CANCEL_OPTION);
        
    }
    
    public DatabaseConnector getConnector()
    {
        return db_connector;
    }
    
    public DBOperator getDBOperator()
    {
        return db_operator;
    }
    
    public String setPreviousWindow(String window_name)
    {
        previous_window = window_name;
        return previous_window;
    }
    
    public String getPreviousWindow()
    {
        return previous_window;
    }
            
    public CreateBook setCreateBookWindow(CreateBook create_book_window)
    {
        this.create_book_window = create_book_window;
        
        return this.create_book_window;
    }
    
    public SearchBook setSearchBookWindow(SearchBook search_book_window)
    {
        this.search_book_window = search_book_window;
        return this.search_book_window;
    }
    
    public SingleBookInfo setSingleBookWindow(SingleBookInfo single_book_window)
    {
        this.single_book_window = single_book_window;
        return this.single_book_window;
    }
    
    public BookCollection setBookCollectionWindow(BookCollection book_collection_window)
    {
        this.book_collection_window= book_collection_window;
        return this.book_collection_window;
    }
    
    public ReadingNotes setReadingNoteWindow(ReadingNotes reading_note_window)
    {
        this.reading_notes_window = reading_note_window;
        
        return this.reading_notes_window;
    }
    
    public SingleNote setSingleNoteWindow(SingleNote single_note_window)
    {
        this.single_note_window = single_note_window;
        return this.single_note_window;
    }
    
        public ReadingNotes getReadingNoteWindow()
    {
        return this.reading_notes_window;
    }
    
    public SingleNote getSingleNoteWindow()
    {
        return single_note_window;
    }
    
    
    public Login setLoginWindow(Login login_window)
    {
        this.login_window = login_window;
        return this.login_window;
    }
    public Signup setSignupWindow(Signup signup_window)
    {
        this.signup_window = signup_window;
        return this.signup_window;
    }
    
    public CreateBook getCreateBookWindow()
    {
        return create_book_window;
    }
    
    public SearchBook getSearchBookWindow()
    {
        return search_book_window;
    }
    
    public SingleBookInfo getSingleBookWindow()
    {
        return single_book_window;
    }
    
    public BookCollection getBookCollectionWindow()
    {
        return book_collection_window;
    }
    
    public Login getLoginWindow()
    {
        return login_window;
    }
    
    public Signup getSignupWindow()
    {
        return signup_window;
    }
    
    public void editWindowVisibility(boolean is_visible, JFrame window_name)
    {
        window_name.setVisible(is_visible);
    }
                
}

