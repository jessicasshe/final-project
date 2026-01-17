package loginandsignup;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import java.util.ArrayList;


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
        configureJList("ASC");
        this.setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chapter_input = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        reading_notes_label = new javax.swing.JLabel();
        search_note_btn = new javax.swing.JButton();
        new_note_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        chapter_note_list = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        sort_combo_box = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        chapter_input.setToolTipText("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(158, 118, 118));

        reading_notes_label.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        reading_notes_label.setForeground(new java.awt.Color(242, 242, 242));
        reading_notes_label.setText("Insert Book Name");

        search_note_btn.setText("Search Note");
        search_note_btn.addActionListener(this::search_note_btnActionPerformed);

        new_note_btn.setText("Open New Note");
        new_note_btn.addActionListener(this::new_note_btnActionPerformed);

        chapter_note_list.setPreferredSize(new java.awt.Dimension(200, 200));
        chapter_note_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chapter_note_listMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(chapter_note_list);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Chapter Notes");

        sort_combo_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascending", "Descending" }));
        sort_combo_box.addActionListener(this::sort_combo_boxActionPerformed);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sort By");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(reading_notes_label, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(search_note_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(new_note_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(183, 183, 183))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(108, 108, 108)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sort_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reading_notes_label, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(new_note_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_note_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sort_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
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

    private DefaultListModel<String> configureListModel(String sort_type)
    {
        // name of list model: chapters 
        chapters.addElement("Test");
        
        // get a collection of note objects for the users book
        chapters_array_list = manager.getDBOperator().getNotes(book, sort_type);

        for(Note note : chapters_array_list)
        {
            chapters.addElement(Integer.toString(note.getChapterNum()));
        }
        return chapters;     
    }
    
    private void configureJList(String sort_type)
    {
        chapters.clear();
        chapter_note_list.setModel((DefaultListModel<String>)(configureListModel(sort_type)));
    }
    
    
    private void filterSearch(int chapter_num)
    {
        chapters.clear();
        chapters.addElement(Integer.toString(chapter_num));
        chapter_note_list.setModel((DefaultListModel<String>)chapters);
    }

            
    private void search_note_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_note_btnActionPerformed
        // search the array list for notes that correspond to the selected chapter 
        String chapter_to_search = manager.showInputMessage(chapter_input, "Select the chapter you want to search for");
        if(validator.isNumeric(chapter_to_search) && !validator.isEmpty(chapter_to_search))
        {
            boolean note_found = false;
            for(Note note : chapters_array_list)
            {
                if(note.getChapterNum() == Integer.parseInt(chapter_to_search))
                {
                    filterSearch(note.getChapterNum());
                    note_found = true;
                    break;
                }
            }
            if(note_found == false)
            {
                chapters.clear();
                chapters.addElement("No notes found");
                chapter_note_list.setModel((DefaultListModel<String>)chapters);
            }
            
            
                
        }
        else
        {
            
        }
        
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

    private void chapter_note_listMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chapter_note_listMousePressed
        // get the note object corresponding to the chapter
        for(Note note: chapters_array_list)
        {
            if(note.getChapterNum() == Integer.parseInt(chapter_note_list.getSelectedValue()))
            {
                manager.setSingleNoteWindow(new SingleNote(manager, validator, note));
           }
        }
    }//GEN-LAST:event_chapter_note_listMousePressed

    private void sort_combo_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sort_combo_boxActionPerformed
        String action = sort_combo_box.getSelectedItem().toString();
        switch(action)
        {
            case "Ascending": 
                configureJList("ASC");
                break;
            case "Descending":
                configureJList("DESC");
                break;
        }
    }//GEN-LAST:event_sort_combo_boxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JOptionPane chapter_input;
    private javax.swing.JList<String> chapter_note_list;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton new_note_btn;
    private javax.swing.JLabel reading_notes_label;
    private javax.swing.JButton search_note_btn;
    private javax.swing.JComboBox<String> sort_combo_box;
    // End of variables declaration//GEN-END:variables
    private WindowManager manager;
    private Validator validator;
    private Book book;
    private DefaultListModel<String> chapters = new DefaultListModel<>();
    private ArrayList<Note> chapters_array_list;
}
