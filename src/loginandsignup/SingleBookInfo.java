package loginandsignup;
import java.sql.ResultSet;
import java.sql.SQLException;
import loginandsignup.DBOperator;
import javax.swing.ImageIcon;
import java.io.IOException;
import javax.swing.SwingUtilities;
import java.io.File;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.lang.NumberFormatException;
import java.lang.NullPointerException;
import javax.swing.JLabel;


public class SingleBookInfo extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SingleBookInfo.class.getName());

    public SingleBookInfo(Book book, WindowManager manager){
        this.manager = manager;
        this.book = book;
        initComponents();
        configurePersonalButtons();
        this.setVisible(true);
        img_file_chooser.setVisible(false);
        this.pack();
        this.setLocationRelativeTo(null);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        img_file_chooser = new javax.swing.JFileChooser();
        book_details_edit_pane = new javax.swing.JOptionPane();
        error_option_pane = new javax.swing.JOptionPane();
        warning_option_pane = new javax.swing.JOptionPane();
        BookDetailsPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        book_img = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        book_name = new javax.swing.JLabel();
        book_author = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        back_btn = new javax.swing.JButton();
        users_completed = new javax.swing.JLabel();
        open_reading_notes_btn = new javax.swing.JButton();
        change_cover_btn = new javax.swing.JButton();
        edit_users_btn = new javax.swing.JButton();
        edit_name_btn = new javax.swing.JButton();
        edit_author_btn = new javax.swing.JButton();
        add_book_btn = new javax.swing.JButton();
        collection_selector = new javax.swing.JComboBox<>();
        remove_from_collection_btn = new javax.swing.JButton();
        progress_bar = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        shelf_name = new javax.swing.JLabel();
        save_details_btn = new javax.swing.JButton();
        update_page_pg_btn = new javax.swing.JButton();
        num_pages_label = new javax.swing.JLabel();
        num_pages = new javax.swing.JLabel();
        change_num_pages_btn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        img_file_chooser.setDialogTitle("");
        img_file_chooser.addActionListener(this::img_file_chooserActionPerformed);

        book_details_edit_pane.setInputValue(book_details_edit_pane);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(null);

        BookDetailsPanel.setBackground(new java.awt.Color(255, 248, 234));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Palatino", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(89, 69, 69));
        jLabel1.setText("Book Details");

        book_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loginandsignup/_.jpeg"))); // NOI18N
        book_img.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel4.setText("Author");

        book_name.setText("Insert Name");
        book_name.setPreferredSize(new java.awt.Dimension(310, 17));

        book_author.setText("Insert Author");
        book_author.setPreferredSize(new java.awt.Dimension(273, 17));

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel8.setText("Users Finished");

        back_btn.setText("Back to Book Collection");
        back_btn.addActionListener(this::back_btnActionPerformed);

        users_completed.setText("Insert # Users");
        users_completed.setPreferredSize(new java.awt.Dimension(220, 17));

        open_reading_notes_btn.setText("Open Reading Notes");
        open_reading_notes_btn.addActionListener(this::open_reading_notes_btnActionPerformed);

        change_cover_btn.setText("Change Book Cover");
        change_cover_btn.addActionListener(this::change_cover_btnActionPerformed);

        edit_users_btn.setText("Edit");
        edit_users_btn.addActionListener(this::edit_users_btnActionPerformed);

        edit_name_btn.setText("Edit");
        edit_name_btn.addActionListener(this::edit_name_btnActionPerformed);

        edit_author_btn.setText("Edit");
        edit_author_btn.addActionListener(this::edit_author_btnActionPerformed);

        add_book_btn.setText("Add Book To Collection");
        add_book_btn.addActionListener(this::add_book_btnActionPerformed);

        collection_selector.setBackground(new java.awt.Color(89, 69, 69));
        collection_selector.setForeground(new java.awt.Color(255, 255, 255));
        collection_selector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reading", "To-Read", "Finished" }));
        collection_selector.setSelectedItem(collection_selector);
        collection_selector.setToolTipText("Change List");
        collection_selector.addActionListener(this::collection_selectorActionPerformed);

        remove_from_collection_btn.setText("Remove From Collection");
        remove_from_collection_btn.addActionListener(this::remove_from_collection_btnActionPerformed);

        progress_bar.setPreferredSize(new java.awt.Dimension(240, 39));

        jLabel5.setText("Reading Progress");

        shelf_name.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        shelf_name.setText("Shelf Type");

        save_details_btn.setBackground(new java.awt.Color(89, 69, 69));
        save_details_btn.setForeground(new java.awt.Color(255, 255, 255));
        save_details_btn.setText("Save Details");
        save_details_btn.addActionListener(this::save_details_btnActionPerformed);

        update_page_pg_btn.setText("Edit");
        update_page_pg_btn.addActionListener(this::update_page_pg_btnActionPerformed);

        num_pages_label.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        num_pages_label.setText("Pages");

        num_pages.setText("Insert # Pages");

        change_num_pages_btn.setText("Edit");
        change_num_pages_btn.addActionListener(this::change_num_pages_btnActionPerformed);

        jButton1.setText("Reset Details");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout BookDetailsPanelLayout = new javax.swing.GroupLayout(BookDetailsPanel);
        BookDetailsPanel.setLayout(BookDetailsPanelLayout);
        BookDetailsPanelLayout.setHorizontalGroup(
            BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BookDetailsPanelLayout.createSequentialGroup()
                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(57, 57, 57)
                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(book_author, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(book_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edit_name_btn)
                            .addComponent(edit_users_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edit_author_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(change_num_pages_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(book_img, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(shelf_name, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(collection_selector, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(progress_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(38, 38, 38)
                                .addComponent(update_page_pg_btn)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                                .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(open_reading_notes_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                                .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(save_details_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(remove_from_collection_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(add_book_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(num_pages_label))
                                        .addGap(18, 18, 18)
                                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(users_completed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(num_pages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(3, 3, 3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(change_cover_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))))
        );
        BookDetailsPanelLayout.setVerticalGroup(
            BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                                .addGap(0, 54, Short.MAX_VALUE)
                                .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(update_page_pg_btn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(progress_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))
                            .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                                .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(shelf_name)
                                    .addComponent(collection_selector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(book_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edit_name_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(book_author, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(edit_author_btn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(users_completed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edit_users_btn))
                        .addGap(31, 31, 31)
                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(num_pages_label)
                            .addComponent(num_pages)
                            .addComponent(change_num_pages_btn))
                        .addGap(29, 29, 29)
                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(save_details_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                                .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(add_book_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(remove_from_collection_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(open_reading_notes_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                        .addComponent(book_img, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(change_cover_btn))))
        );

        collection_selector.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(BookDetailsPanel);
        BookDetailsPanel.setBounds(0, 0, 810, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* 
    Saves a reference to the list model of the previous shelf, in the case that the user has changed the shelf.
    @ param: the name of the shelf, read from the JChooseBox 
    @ return: DefaultListModel<String> of the shelf from BookCollection
    */
    public DefaultListModel<String> setPrevShelfReference(String shelf_type)
    {
        prev_shelf_list = manager.getBookCollectionWindow().getListReference(shelf_type);
        return prev_shelf_list;
    }
    
    /*
    Hides the buttons if the user doesn't have it added in their collection
    */
    public void configurePersonalButtons()
    {
        try
        {
            int val = manager.getDBOperator().FindBookInUserBooks(book.getBookId());
            System.out.println(val);
            if(manager.getDBOperator().FindBookInUserBooks(details.getInt("book_id")) == 0) // not found
            {
                showUsersBooksButtons = false;
                update_page_pg_btn.setVisible(false);
                progress_bar.setVisible(false);
                collection_selector.setVisible(false);
                remove_from_collection_btn.setVisible(false);
                open_reading_notes_btn.setVisible(false);
            }
            else
            {
                showUsersBooksButtons = true;
            }
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong when configuring buttons");
            e.printStackTrace();
        }
    }
    
    //public configureProgressBar(int pages_read, int num_pages)
    
   /*
    Initializes all the details of the Book, from most recent table values.
    */
   public void configureBookDetails(ResultSet details) 
    {
        try{
    
            if(details.next())
            {
                // checking for correct values 
                System.out.println("Book id: " + details.getInt("book_id"));
                System.out.println("Page progress: " + details.getInt("page_progress"));
                System.out.println("Book name: " + details.getString("book_name"));
                System.out.println("Number of pages: " + details.getInt("num_pages"));

                if(showUsersBooksButtons)
                {
                    collection_selector.setSelectedItem(details.getString("shelf_type"));
                    old_shelf_type = details.getString("shelf_type"); 
                    // setup the progress bar 
                    progress_bar.setMinimum(0);
                    progress_bar.setMaximum(details.getInt("num_pages"));
                    progress_bar.setValue(details.getInt("page_progress")); 
                    setPrevShelfReference(old_shelf_type);
                }
                
                book_name.setText(details.getString("book_name"));
                previous_name = details.getString("book_name");
                book_author.setText(details.getString("author"));
                users_completed.setText(String.valueOf(details.getInt("total_users_read")));
                num_pages.setText(String.valueOf(details.getInt("num_pages")));
                if(details.getBytes("image") != null)
                {
                    book_img.setIcon(new ImageIcon(details.getBytes("image")));
                }
                else
                {
                    System.out.println("No image found in database"); 
                }
            }
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong when trying to query for book details");
            e.printStackTrace();
        }
   }
                
   /* 
   Updates the users BookCollection when adding or removing a book. 
   Can be called from add book or remove book button
   @ param: action specified, "add" or "remove 
   */
    private void update_collection_lists(String action)      
    {  
        // gets the model of the shelf to change to
        DefaultListModel<String> list = manager.getBookCollectionWindow().getListReference(collection_selector.getSelectedItem().toString());
        String name = book_name.getText();
        
        switch(action)
        {
            case "add": 
                list.addElement(name);
            case "remove":
               list.removeElement(name);
        }
    }
    
    /* 
    Updates the users BookCollection after saving changes for potential shelf change
    @ param: prev shelf list reference 
    */
    private void update_collection_lists(DefaultListModel<String> prev_shelf_list)
    {
        DefaultListModel<String> list = manager.getBookCollectionWindow().getListReference(collection_selector.getSelectedItem().toString());
        
        String name = book_name.getText();
        
        if(list == prev_shelf_list)
        {
            int index = list.indexOf(previous_name);
            System.out.println("No shelf change applicable");
            list.setElementAt(name, index);
        }
        else
        {
            System.out.println("Removing from: " + old_shelf_type);
            prev_shelf_list.removeElement(previous_name); // need previous name!
            System.out.println("Adding to: " + collection_selector.getSelectedItem());
            list.addElement(name);
        }
    }
    
        
        /* 
    Called when the user presses the Save Details button. 
    The book may or may not be added to the Users book collection. 
    Calls helper functions updateBooksColumns() (db_operator) to update Books columns -> ignored if no unique value was violated 
    
    updateUsersBooksColumns() (db+operator) to update UsersBooks -> ignored if no edits
    */
    
    private void save_details_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_details_btnActionPerformed
        try{
            int result = warning_option_pane.showConfirmDialog(null, "Changes will be shared with all other club members. Proceed?", "Warning", JOptionPane.OK_CANCEL_OPTION);
            if(result == JOptionPane.OK_OPTION)
            {
                manager.getDBOperator().setBookId(details.getInt("book_id"));
                manager.getDBOperator().setAuthor(book_author.getText());
                manager.getDBOperator().setTitle(book_name.getText());
                manager.getDBOperator().setNumUsersRead(Integer.parseInt(users_completed.getText()));
                manager.getDBOperator().setBLOBImageFile(details.getBytes("image"));
                
                int book_rows_updated = manager.getDBOperator().updateBooksColumns();
                
                if(book_rows_updated == 1)
                {
                    System.out.println("Books columns updated successfully!");
                }
                
                else if(book_rows_updated == 0)
                {
                    System.out.println("Failed to save book information.");
                }

                if(showUsersBooksButtons)
                {
                    manager.getDBOperator().setShelfType(collection_selector.getSelectedItem().toString());
                    manager.getDBOperator().setPageProgress(progress_bar.getValue());
                    int users_books_rows_updated = manager.getDBOperator().updateUsersBooksColumns();
                    if(users_books_rows_updated == 1)
                    {
                        System.out.println("UsersBooks columns updated successfully!");
                        // check for shelf type to update users bookcollection 
                        update_collection_lists(prev_shelf_list);
                    }
                    
                }
            }
           
    }
        catch(SQLException e)
        {
            System.out.println("Something went wrong when saving details");
            e.printStackTrace();
        }
    }
    
    private void img_file_chooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_img_file_chooserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_img_file_chooserActionPerformed

    private void change_num_pages_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_num_pages_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_change_num_pages_btnActionPerformed

    private void update_page_pg_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_page_pg_btnActionPerformed
        try{
            String new_value = getNewValue();
            
            // validate if the new value is numeric 
            if(checkNumericValue(new_value))
            {
                if(Integer.parseInt(new_value) > progress_bar.getValue())
                {
                   showErrorMessage("Select a value within the range!");
                }
            }
            else
            {
                progress_bar.setValue(Integer.parseInt(new_value));
 
            }
        }
        catch(NumberFormatException e)
        {
            showErrorMessage("That is not a valid page number!");
        }
    }//GEN-LAST:event_update_page_pg_btnActionPerformed

//GEN-FIRST:event_save_details_btnActionPerformed
 
//GEN-LAST:event_save_details_btnActionPerformed

    private void remove_from_collection_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_from_collection_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remove_from_collection_btnActionPerformed

    private void collection_selectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collection_selectorActionPerformed

    }//GEN-LAST:event_collection_selectorActionPerformed

    private void add_book_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_book_btnActionPerformed

        try
        {
            if(checkChangesSaved()) // returns whether changes were made 
            {
                // ok to get full book details for update
                details = manager.getDBOperator().getFullBookDetails(details.getInt("book_id"));
                int added_book_id = manager.getDBOperator().addBookToUserBooks(details);
                switch(added_book_id)
                {
                    case 1:
                        System.out.println("Successfully added to your book collection!");
                        break;
                    
                    case 0:
                        System.out.println("Match found, already exists in your collection!");
                        break;
                }
            }
            else
            {
                showErrorMessage("Save changes before continuing!");
            }
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong when trying to query the book_id");
            e.printStackTrace();
        }
    }//GEN-LAST:event_add_book_btnActionPerformed

    private void edit_author_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_author_btnActionPerformed
        String new_value = getNewValue();
        setNewValue(book_author, new_value);
    }//GEN-LAST:event_edit_author_btnActionPerformed

    private void edit_name_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_name_btnActionPerformed
        // set book name with popup
        String new_value = getNewValue();
        setNewValue(book_name, new_value);
    }//GEN-LAST:event_edit_name_btnActionPerformed

    private void edit_users_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_users_btnActionPerformed
        // TODO add your handling code here:
        String new_value = getNewValue();
        if(checkNumericValue(new_value))
        {
            setNewValue(num_pages_label, new_value);
        }
  
    }//GEN-LAST:event_edit_users_btnActionPerformed

    private void setNewValue(JLabel label, String new_value)
    {
        if(new_value != null)
        {
            label.setText(new_value);
            checkChangesMade();
        }
    }
            
    private void change_cover_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_cover_btnActionPerformed
        img_file_chooser.setVisible(true);

        img_file_chooser.showOpenDialog(BookDetailsPanel);
        book_img_file = new File(img_file_chooser.getSelectedFile().getPath());
        if(book_img_file != null)
        {
            book_img.setIcon(new ImageIcon(book_img_file.getPath()));
        }
    }//GEN-LAST:event_change_cover_btnActionPerformed

    private void open_reading_notes_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_open_reading_notes_btnActionPerformed
        // open reading notes window & use overloaded method to give the specific book
    }//GEN-LAST:event_open_reading_notes_btnActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:
        if(checkChangesMade())
        {
            if(checkChangesSaved())
                this.setVisible(false);
                manager.editWindowVisibility(true, manager.getBookCollectionWindow());
        }
        else
        {
            showErrorMessage("You have unsaved changes!");
        }
    }//GEN-LAST:event_back_btnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

        
    private String getNewValue()
    {
        String new_value = book_details_edit_pane.showInputDialog("Please enter the new value:");
        if(new_value.isBlank() || new_value.isEmpty()) { 
            System.out.println("Value is a null value");
            showErrorMessage("Cannot enter a null value");
         return null;
        }
        return new_value;
    }
    
    private boolean checkNumericValue(String string_num_value)
    {
        try
        {
            int numeric_val = Integer.parseInt(string_num_value);
            return true;
        }
        catch(NumberFormatException e)
        {
            showErrorMessage("Enter an integer value!");
        }
        return false;
    }
    
    private void showErrorMessage(String message)
    {
        error_option_pane.showMessageDialog(null,message, "Error", JOptionPane.ERROR_MESSAGE);
    }
                
   
    private boolean checkChangesMade()
    {
      if(changes_made)
      {
          return true;
      }
      return false;
    }
    
    private boolean checkChangesSaved()
    {
        if(changes_saved)
        {
            return true;
        }
        return false;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BookDetailsPanel;
    private javax.swing.JButton add_book_btn;
    private javax.swing.JButton back_btn;
    private javax.swing.JLabel book_author;
    private javax.swing.JOptionPane book_details_edit_pane;
    private javax.swing.JLabel book_img;
    private javax.swing.JLabel book_name;
    private javax.swing.JButton change_cover_btn;
    private javax.swing.JButton change_num_pages_btn;
    private javax.swing.JComboBox<String> collection_selector;
    private javax.swing.JButton edit_author_btn;
    private javax.swing.JButton edit_name_btn;
    private javax.swing.JButton edit_users_btn;
    private javax.swing.JOptionPane error_option_pane;
    private javax.swing.JFileChooser img_file_chooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel num_pages;
    private javax.swing.JLabel num_pages_label;
    private javax.swing.JButton open_reading_notes_btn;
    private javax.swing.JProgressBar progress_bar;
    private javax.swing.JButton remove_from_collection_btn;
    private javax.swing.JButton save_details_btn;
    private javax.swing.JLabel shelf_name;
    private javax.swing.JButton update_page_pg_btn;
    private javax.swing.JLabel users_completed;
    private javax.swing.JOptionPane warning_option_pane;
    // End of variables declaration//GEN-END:variables
    private Book book;
    private File book_img_file;
    private WindowManager manager;
    private byte[] blob_file;
    private String old_shelf_type;
    private DefaultListModel<String> prev_shelf_list;
    private boolean changes_saved;
    private boolean changes_made;
    private boolean showUsersBooksButtons;
    private String previous_name;
}
