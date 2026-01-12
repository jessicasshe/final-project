
package loginandsignup;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class LoginAndSignUp {
    
    public static void main(String[] args) {
        // TODO code application logic here
        WindowManager window_manager = new WindowManager();
        window_manager.setLoginWindow(new Login(window_manager));
        // center 
        
        
        // Testing purposes only: 
        //GridLayoutTester layout_tester = new GridLayoutTester();
        
    }
    
}
