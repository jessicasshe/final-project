
package code_files;
import javax.swing.JOptionPane;

public class SingleNote extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SingleNote.class.getName());


    public SingleNote(WindowManager manager, Validator validator, Note note) {
        this.manager = manager;
        this.validator = validator;
        this.note = note;
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        configureDetails();
        this.setVisible(true);
        original_text = note.getText();
    }

    public void configureDetails()
    {
        title.setText(note.getBook().getName());
        chapter_num.setText(String.valueOf(note.getChapterNum()));
        date_label.setText(note.getLastEditedDate());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        option_pane = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        edit_details_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        chapter_num = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        back_btn = new javax.swing.JButton();
        save_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        date_label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text_area = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(158, 118, 118));
        jPanel1.setSize(new java.awt.Dimension(800, 500));

        title.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Insert Book Title");

        edit_details_btn.setText("Edit Details");
        edit_details_btn.addActionListener(this::edit_details_btnActionPerformed);

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Chapter");

        chapter_num.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        chapter_num.setForeground(new java.awt.Color(255, 255, 255));
        chapter_num.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Last Edited: ");

        back_btn.setText("Back to Notes");
        back_btn.addActionListener(this::back_btnActionPerformed);

        save_btn.setText("Save");
        save_btn.addActionListener(this::save_btnActionPerformed);

        delete_btn.setText("Delete");
        delete_btn.addActionListener(this::delete_btnActionPerformed);

        date_label.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        date_label.setForeground(new java.awt.Color(255, 255, 255));
        date_label.setText("jLabel5");

        text_area.setColumns(20);
        text_area.setRows(5);
        jScrollPane1.setViewportView(text_area);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(48, 48, 48)
                                .addComponent(chapter_num, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(back_btn)
                                .addGap(304, 304, 304)
                                .addComponent(save_btn)
                                .addGap(18, 18, 18)
                                .addComponent(delete_btn))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(title)
                        .addGap(240, 240, 240)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(date_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(edit_details_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(date_label)
                            .addComponent(edit_details_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(chapter_num))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back_btn)
                    .addComponent(save_btn)
                    .addComponent(delete_btn))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1143, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(234, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edit_details_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_details_btnActionPerformed
        // update the existing note row 
        String input = manager.showInputMessage(option_pane, "Enter the new date (YYYY-MM-DD: ");
        date_label.setText(input);
        validator.setChangesMade(true);  
    }//GEN-LAST:event_edit_details_btnActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // return to reading notes
        manager.getReadingNoteWindow();
        this.setVisible(false);
    }//GEN-LAST:event_back_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        // TODO add your handling code here:
        int result = manager.showConfirmMessage(option_pane, "Are you sure you want to delete this note?");
        if(result == JOptionPane.OK_OPTION)
        {
         // call database to query note 
            
         // check if deleted successsfully
            
         // output success message
            
        // if user clicks OK go back to the reading notes screen 
        }
        
        
        
    }//GEN-LAST:event_delete_btnActionPerformed

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        // check if changes were made in the text field
        if(!original_text.equals(text_area.getText()))
        {
            validator.setChangesMade(true);
        }
       
        if(validator.getChangesMade())
        {
            int result = manager.showConfirmMessage(option_pane, "Do you want to save your changes?");
            if(result == JOptionPane.OK_OPTION)
            {
                System.out.println("Saving changes");
                
                // get most recent text field 
                
                if(manager.getDBOperator().saveNote(note) ==1)
                {
                    System.out.println("Saved changes successfully");
                    validator.setChangesSaved(true);
                }
            }
        }
        else
        {
            System.out.println("No changes to save");
        }
        
        // consider adding a plain message here
    }//GEN-LAST:event_save_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn;
    private javax.swing.JLabel chapter_num;
    private javax.swing.JLabel date_label;
    private javax.swing.JButton delete_btn;
    private javax.swing.JButton edit_details_btn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JOptionPane option_pane;
    private javax.swing.JButton save_btn;
    private javax.swing.JTextArea text_area;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
    private WindowManager manager;
    private Validator validator;
    private Note note;
    private String original_text;
}
