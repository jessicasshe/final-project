
package loginandsignup;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class LoginAndSignUp {
    
    public static void main(String[] args) {

        WindowManager window_manager = new WindowManager(new DatabaseConnector("BookClub.db"), new DBOperator());
        window_manager.getDBOperator().setManager(window_manager);
        window_manager.setLoginWindow(new Login(window_manager));
        
       
        
        // Testing purposes only: 
        //OptionPaneTester layout_tester = new OptionPaneTester();
        
    }
    
}
