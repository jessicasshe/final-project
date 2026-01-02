/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loginandsignup;

/**
 *
 * @author JessicaS
 */
public class LoginAndSignUp {
    
    public static void main(String[] args) {
        // TODO code application logic here
        Login LoginFrame = new Login(); // create a login frame object (panels defined in login class)
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null); // center 
    }
    
}
