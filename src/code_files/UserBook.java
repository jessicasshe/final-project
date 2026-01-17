
package code_files;

/*
Subclass of Books --> Joined with Books but with its own attributes 
Relationships to User: User HAS A UserBook , or UserBook HAS A User (Can't exist without a user, so needs a ref to it)

*/
public class UserBook extends Book {
    private User user; // access user_id
    private int page_progress;
    private String shelf_type; 
    
    public UserBook(User user, int book_id, String name, String author, int num_pages, int total_users_read, byte[] image_file, int page_progress, String shelf_type)// UserBook belongs to a user & needs a reference
    {
       super(book_id, name, author, num_pages, total_users_read, image_file);
       this.page_progress = page_progress;
       this.shelf_type = shelf_type;
       this.user = user;
    }
 
    public int getPageProgress()
    {
        return page_progress;
    }
    
    public String getShelfType()
    {
        return shelf_type;
    }
    
    public int setPageProgress(int pg)
    {
        page_progress = pg;
        return page_progress;
    }
    
    public String setShelfType(String shelf_type)
    {
       this.shelf_type = shelf_type;
       return this.shelf_type;
    }
  

}
