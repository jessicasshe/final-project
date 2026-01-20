package code_files;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import code_files.DBOperator;

public class Login extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());

    /**
     * Creates new form Login
     */
    public Login(WindowManager manager, Validator validator, DBOperator db_operator) {
        initComponents();
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
        this.manager = manager;
        this.validator = validator;
        this.db_operator = db_operator;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login_option_pane = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        email_text = new javax.swing.JTextField();
        password_text = new javax.swing.JPasswordField();
        login_btn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        signup_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        Right.setBackground(new java.awt.Color(89, 69, 69));
        Right.setPreferredSize(new java.awt.Dimension(400, 500));

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        jPanel1.add(Right);
        Right.setBounds(-130, -10, 530, 510);

        Left.setBackground(new java.awt.Color(255, 248, 234));
        Left.setForeground(new java.awt.Color(61, 58, 75));
        Left.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Palatino", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(89, 69, 69));
        jLabel1.setText("LOGIN");

        jLabel2.setForeground(new java.awt.Color(89, 69, 69));
        jLabel2.setText("Email");

        jLabel3.setForeground(new java.awt.Color(89, 69, 69));
        jLabel3.setText("Password");

        email_text.addActionListener(this::email_textActionPerformed);

        password_text.addActionListener(this::password_textActionPerformed);

        login_btn.setBackground(new java.awt.Color(89, 69, 69));
        login_btn.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        login_btn.setForeground(new java.awt.Color(255, 255, 255));
        login_btn.setText("Login");
        login_btn.setAutoscrolls(true);
        login_btn.addActionListener(this::login_btnActionPerformed);

        jLabel4.setForeground(new java.awt.Color(89, 69, 69));
        jLabel4.setText("I don't have an account");

        signup_btn.setBackground(new java.awt.Color(89, 69, 69));
        signup_btn.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        signup_btn.setForeground(new java.awt.Color(255, 255, 255));
        signup_btn.setText("Sign Up");
        signup_btn.addActionListener(this::signup_btnActionPerformed);

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(131, 131, 131))
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(email_text, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(password_text))
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(29, 29, 29)
                        .addComponent(signup_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(login_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(email_text, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(password_text, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(login_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(signup_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jPanel1.add(Left);
        Left.setBounds(400, -10, 410, 510);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void email_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_textActionPerformed
        // TODO add your handling code here:        
    }//GEN-LAST:event_email_textActionPerformed

    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed
        
        if(validator.isEmpty(email_text.getText()) || validator.isEmpty(password_text.getText()))
        {
            manager.showErrorMessage(login_option_pane, "Cannot leave the fields empty, please try again.");
        }
        else 
           {
               // initializes a user before loading other details
               User user = new User(0, "Member", email_text.getText().trim(), password_text.getText().trim(), null, null, 0);

               if(db_operator.UserExists(user))
               {
                   user = db_operator.LoadExistingUser(user);
                   
                   db_operator.setUser(user);
                   
                   if(manager.getMenuWindow() == null)
                   {
                       manager.setMenuWindow(new Menu(manager, user));
                   }
                   
                   manager.getMenuWindow().setUser(user);
                   manager.getMenuWindow().configureWelcomeMessage();
                   manager.getMenuWindow().repaint();
                   manager.getMenuWindow().setVisible(true);
                   this.setVisible(false);
               }
                else
               {

                   manager.showErrorMessage(login_option_pane, "Wrong credentials!");
               }
           }
    }//GEN-LAST:event_login_btnActionPerformed

    private void signup_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup_btnActionPerformed
        // TODO add your handling code here:
        if(manager.getSignupWindow() == null)
        {
            Signup SignupFrame = new Signup(manager, validator, db_operator); 
            manager.setSignupWindow(SignupFrame);

        }
        manager.getSignupWindow().setVisible(true);
        this.setVisible(false); 
    }//GEN-LAST:event_signup_btnActionPerformed

    private void password_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_textActionPerformed

    /**
     * @param args the command line arguments
     */
    
              

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Right;
    private javax.swing.JTextField email_text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login_btn;
    private javax.swing.JOptionPane login_option_pane;
    private javax.swing.JPasswordField password_text;
    private javax.swing.JButton signup_btn;
    // End of variables declaration//GEN-END:variables
    private Connection user_db;
    private WindowManager manager;
    private Validator validator;
    private DBOperator db_operator;
}
