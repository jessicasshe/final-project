
package loginandsignup;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class LoginAndSignUp {
    
    public static void main(String[] args) {

        WindowManager window_manager = new WindowManager(new DatabaseConnector("BookClub.db"), new DBOperator());
        window_manager.getDBOperator().setManager(window_manager);
        Validator validator = new Validator();
        window_manager.getDBOperator().setEmail("jshe1@ocdsb.ca");
        window_manager.getDBOperator().setPassword("123");
        window_manager.getDBOperator().setUser(window_manager.getDBOperator().LoadExistingUser());
        Book test_book = window_manager.getDBOperator().getFullBookDetails(1);
        //window_manager.setLoginWindow(new Login(window_manager));
        ReadingNotes reading_note_window = new ReadingNotes(window_manager, validator, test_book);
        
                // Testing purposes only: 
        //OptionPaneTester layout_tester = new OptionPaneTester();
        
    }
    
}
