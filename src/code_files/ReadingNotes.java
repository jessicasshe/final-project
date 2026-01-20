package code_files;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import java.util.Collections;


// Notes: User requires a 'Reset' button to display all of their notes again after filtering 

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
        configureJList();
        this.setVisible(true);
    }

    public Book setBook(Book book)
    {
        this.book = book;
        return this.book;
    }
    
    public void configureName()
    {
        reading_notes_label.setText(book.getName());
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
        reset_search_btn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        chapter_input.setToolTipText("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(158, 118, 118));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

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

        reset_search_btn.setText("Reset Search");
        reset_search_btn.addActionListener(this::reset_search_btnActionPerformed);

        jButton1.setText("Back to Book");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(102, 102, 102)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sort_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_note_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(188, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(new_note_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(183, 183, 183))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(reset_search_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(334, 334, 334))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(reading_notes_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reading_notes_label, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(new_note_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_note_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sort_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reset_search_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* Returns a model of ALL chapter notes for this book. 
    
    */
    public DefaultListModel<String> configureListModel()
    {
        chapters.clear();
        // get a collection of note objects for the users book
        chapters_array_list = manager.getDBOperator().getNotes(book); // always reinstantiated for latest update 

        for(Note note : chapters_array_list)
        {
            chapters.addElement(Integer.toString(note.getChapterNum()));
        }
        return chapters;     
    }
    
    public DefaultListModel<String> configureListModel(ArrayList<Integer> specific_chapters)
    {
        
        // get a collection of note objects for the users book
        for(Integer chapter : specific_chapters)
        {
            chapters.addElement(chapter.toString());
        }
        return chapters;     
    }
        
    private void configureJList()
    {
        chapters.clear();
        chapter_note_list.setModel((DefaultListModel<String>)(configureListModel()));
    }
    
    private void filterSearch(int chapter_num)
    {
        chapters.clear();
        chapters.addElement(Integer.toString(chapter_num));
        chapter_note_list.setModel((DefaultListModel<String>)chapters);
    }
    
    public ArrayList<Note> getNotes()
    {
        return chapters_array_list;
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
                manager.showErrorMessage(chapter_input, "No notes found");
                chapter_note_list.setModel((DefaultListModel<String>)chapters);
            }                
        }
        else
        {
            manager.showErrorMessage(chapter_input, "Enter a valid chapter!");
        }
        
    }//GEN-LAST:event_search_note_btnActionPerformed

    private void new_note_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_note_btnActionPerformed
        // TODO add your handling code here:
            
        try
        {
        String chapter_entered = manager.showInputMessage(chapter_input, "Enter the chapter number:");
        if(!validator.isEmpty(chapter_entered) && validator.isNumeric(chapter_entered))
        {            
            Note note = new Note(manager.getDBOperator().getUser(), book, "", Integer.parseInt(chapter_entered), "");
            if (manager.getDBOperator().addNewNote(note) == 1)
            {
                System.out.println("Note created successfully!");
                manager.setSingleNoteWindow(new SingleNote(manager, validator, note, manager.getDBOperator()));
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
                if(manager.getSingleNoteWindow() == null)
                {
                    manager.setSingleNoteWindow(new SingleNote(manager, validator, note, manager.getDBOperator()));
                }
                manager.getSingleNoteWindow().setNote(note);

                manager.getSingleNoteWindow().configureDetails();
                manager.getSingleNoteWindow().setVisible(true);
                this.setVisible(false);
           }
        }
    }//GEN-LAST:event_chapter_note_listMousePressed

    /* Sorts the current model setup 
    */
    private void sort_combo_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sort_combo_boxActionPerformed
        
        String action = sort_combo_box.getSelectedItem().toString();
        ArrayList<Integer> chapter_numbers = new ArrayList<>();
        // get a list of the chapter numbers 
        for(int i = 0; i < chapters.getSize(); i++)
        {
            chapter_numbers.add(Integer.parseInt(chapters.getElementAt(i)));
        }
        
        chapters.clear();
        
        switch(action)
        {
            case "Ascending": 
                Collections.sort(chapter_numbers);
                break;
            case "Descending":
                Collections.sort(chapter_numbers, Collections.reverseOrder());
                break;
        }
        chapter_note_list.setModel(configureListModel(chapter_numbers));
    }//GEN-LAST:event_sort_combo_boxActionPerformed

    private void reset_search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_search_btnActionPerformed
        configureJList();
    }//GEN-LAST:event_reset_search_btnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        manager.getSingleBookWindow().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JOptionPane chapter_input;
    private javax.swing.JList<String> chapter_note_list;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton new_note_btn;
    private javax.swing.JLabel reading_notes_label;
    private javax.swing.JButton reset_search_btn;
    private javax.swing.JButton search_note_btn;
    private javax.swing.JComboBox<String> sort_combo_box;
    // End of variables declaration//GEN-END:variables
    private WindowManager manager;
    private Validator validator;
    private Book book;
    private DefaultListModel<String> chapters = new DefaultListModel<>();
    private ArrayList<Note> chapters_array_list;
}
