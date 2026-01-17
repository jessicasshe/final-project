package code_files;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Book {
    private int book_id;
    private String name;
    private String author;
    private int num_pages;
    private int total_users_read;
    private byte[] image_file;
    
    public Book(int book_id, String name, String author, int num_pages, int total_users_read, byte[] image_file)
    {
        this.book_id = book_id;
        this.name = name;
        this.author = author;
        this.num_pages = num_pages;
        this.image_file = image_file;
        this.total_users_read = total_users_read;
        // add prev shelf type as an attribute instead of in singlebookinfo; clearer relationship
       
    }
    
    public Book()
    {
        
    }
    
    
    // add getters and setters: 
    // Instead of passing in a NEW resultset, just edit the attribute values and pass in the Book as a parameter for saving/other actions
    
    public int getBookId()
    {
        return this.book_id;
    }
    
    public String getName()
    {
        return this.name;
    }
            
    public String getAuthor()
    {
        return this.author;
    }
            
    public int getNumPages()
    {
        return this.num_pages;
    }
            
    public int getTotalUsersRead()
    {
        return this.total_users_read;
    }
    
    public byte[] getImage()
    {
        return this.image_file;
    }
    
    public String setName(String name)
    {
        this.name = name;
        return this.name;
    }
    
    public String setAuthor(String author)
    {
        this.author = author;
        return this.author;
        
    }
    
    public int setNumPages(int num_pages)
    {
        this.num_pages = num_pages;
        return this.num_pages;
    }
    
    public int setTotalUsersRead(int total_users_read) 
    {
        this.total_users_read = total_users_read;
        return this.total_users_read;
       
    }
    
    public byte[] setImage(byte[] image_file) 
    {
        this.image_file = image_file;
        return this.image_file;
       
    }
    
    // public String getPrevShelfType 
    
    // public String getNewShelfType 
    
}
