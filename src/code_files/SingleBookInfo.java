package code_files;

import java.sql.ResultSet;
import java.sql.SQLException;
import code_files.DBOperator;
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
    
    // how to represent the previous values incase user wants to reset details?
    // -> Save ann initial book object w initial attributes
    // if changes are made, just recreate the book object when saved instead of having isolated variables flowing around
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SingleBookInfo.class.getName());

    public SingleBookInfo(Book book, WindowManager manager, Validator validator, DBOperator db_operator){
        this.manager = manager;
        this.book = book; // initial details
        this.db_operator = db_operator;
        this.validator = validator;
        initComponents();
        configurePersonalButtons();
        configureBookDetails();
        img_file_chooser.setVisible(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        img_file_chooser = new javax.swing.JFileChooser();
        book_details_edit_pane = new javax.swing.JOptionPane();
        error_option_pane = new javax.swing.JOptionPane();
        warning_option_pane = new javax.swing.JOptionPane();
        single_book_option_pane = new javax.swing.JOptionPane();
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
        reset_btn = new javax.swing.JButton();

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

        book_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code_files/_.jpeg"))); // NOI18N

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
        edit_name_btn.setPreferredSize(new java.awt.Dimension(100, 20));
        edit_name_btn.addActionListener(this::edit_name_btnActionPerformed);

        edit_author_btn.setText("Edit");
        edit_author_btn.setPreferredSize(new java.awt.Dimension(100, 20));
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

        progress_bar.setBackground(new java.awt.Color(204, 204, 204));
        progress_bar.setForeground(new java.awt.Color(55, 10, 42));
        progress_bar.setPreferredSize(new java.awt.Dimension(240, 39));

        jLabel5.setText("Reading Progress");

        shelf_name.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
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

        reset_btn.setBackground(new java.awt.Color(89, 69, 69));
        reset_btn.setForeground(new java.awt.Color(255, 255, 255));
        reset_btn.setText("Reset Details");
        reset_btn.addActionListener(this::reset_btnActionPerformed);

        javax.swing.GroupLayout BookDetailsPanelLayout = new javax.swing.GroupLayout(BookDetailsPanel);
        BookDetailsPanel.setLayout(BookDetailsPanelLayout);
        BookDetailsPanelLayout.setHorizontalGroup(
            BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                        .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(change_cover_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                                .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(shelf_name, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(collection_selector, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                                                .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel8)
                                                    .addComponent(num_pages_label))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(num_pages, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(users_completed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                                                .addComponent(save_details_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(reset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(37, 37, 37)
                                                .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(add_book_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(remove_from_collection_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                                                .addGap(74, 74, 74)
                                                .addComponent(open_reading_notes_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addComponent(progress_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(65, 65, 65)
                                        .addComponent(update_page_pg_btn)))
                                .addGap(0, 10, Short.MAX_VALUE))
                            .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(book_author, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                                    .addComponent(book_name, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(change_num_pages_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(edit_users_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(edit_name_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(edit_author_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(book_img, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        BookDetailsPanelLayout.setVerticalGroup(
            BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(collection_selector, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(shelf_name, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(open_reading_notes_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(update_page_pg_btn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(progress_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(book_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edit_name_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(book_img, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(change_cover_btn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edit_author_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(book_author, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(users_completed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edit_users_btn))
                        .addGap(26, 26, 26)
                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(num_pages_label)
                            .addComponent(num_pages)
                            .addComponent(change_num_pages_btn))
                        .addGap(37, 37, 37)
                        .addGroup(BookDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(save_details_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(BookDetailsPanelLayout.createSequentialGroup()
                                .addComponent(add_book_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(remove_from_collection_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))))
        );

        collection_selector.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(BookDetailsPanel);
        BookDetailsPanel.setBounds(0, 0, 810, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    Hides the buttons if the user doesn't have it added in their collection
    */
    public void configurePersonalButtons()
    {
        if(!db_operator.ExistsInUsersBooks(book.getBookId()))
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
            user_book = db_operator.getUsersBooksDetails(book.getBookId());
            showUsersBooksButtons = true;
        }
    }
    
   
    public void configureProgressBar(int page_progress)
    {
        System.out.println("Setting page progress to " + page_progress + " out of " + book.getNumPages());
        progress_bar.setValue(page_progress);
    }
    
   /*
    Initializes all the details of the Book, from most recent table values.
    */
   public void configureBookDetails() 
    {
        // checking for correct values 
        System.out.println("Book id: " + book.getBookId());
        //System.out.println("Page progress: " + book.get("page_progress"));
        //System.out.println("Book name: " + details.getString("book_name"));
        //System.out.println("Number of pages: " + details.getInt("num_pages"));
        
        if(showUsersBooksButtons) 
        {
            collection_selector.setSelectedItem(user_book.getShelfType());
            progress_bar.setMinimum(0);
            progress_bar.setMaximum(user_book.getNumPages());
            configureProgressBar(user_book.getPageProgress());
        }

        book_name.setText(book.getName());
        book_author.setText(book.getAuthor());
        users_completed.setText(String.valueOf(book.getTotalUsersRead()));
        num_pages.setText(String.valueOf(book.getNumPages()));
        if(book.getImage() != null)
        {
            book_img.setIcon(new ImageIcon(book.getImage()));
        }
        else // for debugging purposes
        {
            System.out.println("No image found in database"); 
        }
        validator.setChangesMade(false); 
        System.out.println(validator.changesMade());// Initialize to false: No changes have been made
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
    @ param: prev shelf list reference , local new_user_book that was just used for updates & discarded later
    */
    private void update_collection_lists(String previous_shelf_type, UserBook new_user_book)
    {
        DefaultListModel<String> list = manager.getBookCollectionWindow().getListReference(new_user_book.getShelfType());

        int index = 0;
        if(previous_shelf_type.equals(new_user_book.getShelfType()))
        {
            index = list.indexOf(book.getName());
            list.setElementAt(book.getName(), index);
        }
        else
        {
            DefaultListModel<String> prev_list = manager.getBookCollectionWindow().getListReference(previous_shelf_type);
            
            System.out.println("Removing from: " + previous_shelf_type);
            index = prev_list.indexOf(book.getName().trim());
            prev_list.removeElement(index); // need previous name!
            System.out.println("Adding to: " + new_user_book.getShelfType());
            list.addElement(new_user_book.getName().trim());
        }
    }
    
        
        /* 
    Called when the user presses the Save Details button. 
    The book may or may not be added to the Users book collection. 
    Calls helper functions updateBooksColumns() (db_operator) to update Books columns -> ignored if no unique value was violated 
    
    updateUsersBooksColumns() (db+operator) to update UsersBooks -> ignored if no edits
    */
    
    private void save_details_btnActionPerformed(java.awt.event.ActionEvent evt) {  
        // Check if changes were made
        System.out.println(validator.getChangesMade());
        if(validator.changesMade() == true)
        {
            int result = manager.showConfirmMessage(single_book_option_pane, "Changes will be shared with all other club members. Proceed?");
            if(result == JOptionPane.OK_OPTION)
            {
                new_book = new Book(book.getBookId(), book_name.getText(), book_author.getText(), Integer.parseInt(num_pages.getText()), Integer.parseInt(users_completed.getText()), book.getImage());            
              
                int book_rows_updated = manager.getDBOperator().updateBooksColumns(new_book);
                
                if(book_rows_updated == 1)
                {
                    manager.showPlainMessage(single_book_option_pane, "Changes saved successfully!");
                    validator.setChangesSaved(true);
                }
                else if(book_rows_updated == 0)
                {
                    manager.showErrorMessage(single_book_option_pane, "Failed to save book information");
                }

                if(showUsersBooksButtons)
                {
                    new_user_book = new UserBook(db_operator.getUser(), new_book.getBookId(), new_book.getName(), new_book.getAuthor(), new_book.getNumPages(), new_book.getTotalUsersRead(), new_book.getImage(), progress_bar.getValue(), collection_selector.getSelectedItem().toString());
                    int users_books_rows_updated = manager.getDBOperator().updateUsersBooksColumns(new_user_book);
                    if(users_books_rows_updated == 1)
                    {
                        manager.showPlainMessage(single_book_option_pane, "UsersBooks columns updated successfully!");
                        update_collection_lists(user_book.getShelfType(), new_user_book);
                    }
                }
            }    
    }
    }
    
    private void img_file_chooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_img_file_chooserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_img_file_chooserActionPerformed

    private void change_num_pages_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_num_pages_btnActionPerformed
        getIntInput("Enter the number of pages:", num_pages);
        if(validator.getChangesSaved())
        {
            validator.setChangesSaved(false);
        }
    }//GEN-LAST:event_change_num_pages_btnActionPerformed

    private void update_page_pg_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_page_pg_btnActionPerformed
        String new_value = manager.showInputMessage(single_book_option_pane, "Enter the new page progress:");
        if(!validator.isEmpty(new_value) && validator.isNumeric(new_value)) // valid number
        {
            if(Integer.parseInt(new_value) > user_book.getNumPages()) // valid range
            {
               manager.showErrorMessage(single_book_option_pane, "Select a value within the range!");
            }
            else
            {
                configureProgressBar(Integer.parseInt(new_value));
                validator.setChangesMade(true);
            }
        }
        else
        {
            manager.showErrorMessage(single_book_option_pane, "That is not a valid page number!");
        }
    }//GEN-LAST:event_update_page_pg_btnActionPerformed

//GEN-FIRST:event_save_details_btnActionPerformed
 
//GEN-LAST:event_save_details_btnActionPerformed

    private void remove_from_collection_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_from_collection_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remove_from_collection_btnActionPerformed

    private void collection_selectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collection_selectorActionPerformed
        validator.setChangesMade(true);
        if(validator.changesSaved())
        {
            validator.setChangesSaved(false);
        }
        System.out.println("Changes were made to collection selector");
    }//GEN-LAST:event_collection_selectorActionPerformed

    private void add_book_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_book_btnActionPerformed
        int added_book_id = -2;
        String[] shelf_options = new String[] {"Reading", "To-Read", "Finished"};

        if(validator.changesMade())
        {
            if(!validator.changesSaved()) 
            {
                manager.showErrorMessage(single_book_option_pane, "Save changes before continuing!");
            }
            else
            {
                
                // Prompt user to select a shelf type
                String shelf_selected = single_book_option_pane.showInputDialog(null, "Choose a shelf:", "Input", JOptionPane.INFORMATION_MESSAGE, null, shelf_options, shelf_options[0]).toString();
                added_book_id = db_operator.addBookToUserBooks(new_book, shelf_selected);
            }
        }
        else
        {
             String shelf_selected = single_book_option_pane.showInputDialog(null, "Choose a shelf:", "Input", JOptionPane.INFORMATION_MESSAGE, null, shelf_options, shelf_options[0]).toString();
             added_book_id = db_operator.addBookToUserBooks(book, shelf_selected);
        }

        switch(added_book_id)
        {
            case 1:
                manager.showPlainMessage(single_book_option_pane,"Successfully added to your book collection!");
                break;
            case 0:
                manager.showErrorMessage(single_book_option_pane, "Match found, already exists in your collection!");
                break;
            default:
                manager.showErrorMessage(single_book_option_pane, "Could not add book to the collection");
        }
    }//GEN-LAST:event_add_book_btnActionPerformed

    private void edit_author_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_author_btnActionPerformed

        getStringInput("Enter the new author:", book_author);
        
        // check if they saved once already, and then go back to edit

    }//GEN-LAST:event_edit_author_btnActionPerformed

    private void getStringInput(String prompt, JLabel label)
    {
        String new_value = manager.showInputMessage(single_book_option_pane, prompt);
        if(!validator.isEmpty(new_value))
        {
            label.setText(new_value);
            validator.setChangesMade(true);
            
            if(validator.getChangesSaved() == true)
            {
                validator.setChangesSaved(false);
            }
        }
        else
        {
            manager.showErrorMessage(single_book_option_pane, "Enter a valid value!");
        }
    
    }      
    
    public void getIntInput(String prompt, JLabel label)
    {
        String new_value = manager.showInputMessage(single_book_option_pane, prompt);
        if(!validator.isEmpty(new_value) && validator.isNumeric(new_value))
        {
            label.setText(new_value);
            validator.setChangesMade(true);
        }
        else
        {
            manager.showErrorMessage(single_book_option_pane, "Enter a valid integer!");
        }
     
    }
    
    private void edit_name_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_name_btnActionPerformed
        // set book name with popup
        getStringInput("Enter the new name:", book_name);
        
    }//GEN-LAST:event_edit_name_btnActionPerformed

    private void edit_users_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_users_btnActionPerformed
        getIntInput("Enter the new number of users:", users_completed);
        if(validator.getChangesSaved())
        {
            validator.setChangesSaved(false);
        }
  
    }//GEN-LAST:event_edit_users_btnActionPerformed

            
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
        if(validator.changesMade() == true)
        {
            if(validator.changesSaved())
            {
                manager.editWindowVisibility(true, manager.getBookCollectionWindow());
            }
            else
            {
                manager.showErrorMessage(single_book_option_pane, "You have unsaved changes!");
            }
        }
        else
        {
            manager.setBookCollectionWindow(new BookCollection(manager, db_operator));
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_back_btnActionPerformed

    private void reset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_btnActionPerformed
        configureBookDetails();
        
    }//GEN-LAST:event_reset_btnActionPerformed


    

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
    private javax.swing.JButton reset_btn;
    private javax.swing.JButton save_details_btn;
    private javax.swing.JLabel shelf_name;
    private javax.swing.JOptionPane single_book_option_pane;
    private javax.swing.JButton update_page_pg_btn;
    private javax.swing.JLabel users_completed;
    private javax.swing.JOptionPane warning_option_pane;
    // End of variables declaration//GEN-END:variables
    private Book book;
    private Book new_book;
    private UserBook user_book;
    private UserBook new_user_book;
    private File book_img_file;
    private WindowManager manager;
    private byte[] blob_file;
    private boolean showUsersBooksButtons;
    private DBOperator db_operator;
    private Validator validator;
}
