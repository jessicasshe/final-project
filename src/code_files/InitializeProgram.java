package code_files;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class InitializeProgram {
    
        /*
        // Pasted default generated code for look & feel
        try {
            // Set the desired Look and Feel here
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            // UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            // UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Create and show your GUI components after setting the L&F
        // e.g., new MyFrame().setVisible(true);

        */
        
        public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();     
                    }
        //</editor-fold>

        /* Create and display the form */    
        
        // Create a DB operator object first, then set the manager 
        WindowManager window_manager = new WindowManager(new DatabaseConnector("BookClub.db"), new DBOperator());
        window_manager.getDBOperator().setManager(window_manager);
        Validator validator = new Validator();
        window_manager.setLoginWindow(new Login(window_manager, validator, window_manager.getDBOperator()));
        
        }
 
    }

