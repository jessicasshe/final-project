package loginandsignup;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;


public class ReadingNotes extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ReadingNotes.class.getName());

   
    public ReadingNotes(WindowManager manager, Validator validator, Book book) {
        initComponents();
        this.manager = manager;
        this.validator = validator;
        this.book = book;
        this.pack();
        this.setLocationRelativeTo(null);
        reading_notes_label.setText(book.getName());
        this.setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chapter_input = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        reading_notes_label = new javax.swing.JLabel();
        search_note_btn = new javax.swing.JButton();
        sort_note_btn = new javax.swing.JButton();
        new_note_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        chapter_note_list = new javax.swing.JList<>();

        chapter_input.setToolTipText("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(158, 118, 118));

        reading_notes_label.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        reading_notes_label.setForeground(new java.awt.Color(242, 242, 242));
        reading_notes_label.setText("Insert Book Name");

        search_note_btn.setText("Search Note");
        search_note_btn.addActionListener(this::search_note_btnActionPerformed);

        sort_note_btn.setText("Sort Notes");

        new_note_btn.setText("Open New Note");
        new_note_btn.addActionListener(this::new_note_btnActionPerformed);

        jScrollPane1.setViewportView(chapter_note_list);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(reading_notes_label, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(search_note_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                        .addComponent(sort_note_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(new_note_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(84, 84, 84))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reading_notes_label, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_note_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sort_note_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(new_note_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*private DefaultListModel<String> initializeListModel()
    {
        // get a collection of note objects for the users book
        
        // find the objects 'chapter' attribute 
        
        // add a string wit Chapter + chapter number to the model 
        
        // return the model
        
        
    }
*/
            
    private void search_note_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_note_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_note_btnActionPerformed

    private void new_note_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_note_btnActionPerformed
        // TODO add your handling code here:
            
        try
        {
        String chapter_entered = manager.showInputMessage(chapter_input, "Enter the chapter number:");
        if(!validator.isEmpty(chapter_entered) && validator.isNumeric(chapter_entered))
        {            
            Note note = new Note(manager.getDBOperator().getUser(), book, "January 15 2025", Integer.parseInt(chapter_entered), "null");
            if (manager.getDBOperator().addNewNote(note) == 1)
            {
                System.out.println("Note created successfully!");
                manager.setSingleNoteWindow(new SingleNote(manager, validator, note));
                this.setVisible(false);
            }
            else
            {
                manager.showErrorMessage(chapter_input, "This note already exists.");
            }
        }
       
        else
        {
            manager.showErrorMessage(chapter_input, "Please enter an integer chapter!");
        }
        }
        catch(NullPointerException e)
        {
            manager.showErrorMessage(chapter_input, "Value cannot be null");
        }
    }//GEN-LAST:event_new_note_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JOptionPane chapter_input;
    private javax.swing.JList<String> chapter_note_list;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton new_note_btn;
    private javax.swing.JLabel reading_notes_label;
    private javax.swing.JButton search_note_btn;
    private javax.swing.JButton sort_note_btn;
    // End of variables declaration//GEN-END:variables
    private WindowManager manager;
    private Validator validator;
    private Book book;
    private DefaultListModel<String> chapters;
}
