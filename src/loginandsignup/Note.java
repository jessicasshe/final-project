
package loginandsignup;


public class Note {
    private User user; 
    private Book book;
    private String last_edited_date;
    private int chapter;
    private String text;
    
    public Note(User user, Book book, String date, int chap_num, String content)
    {
        this.user = user;
        this.book = book;
        last_edited_date = date;
        chapter = chap_num;
        text = content;
    }
    
    public User getUser()
    {
        return user;
    }
        
    public Book getBook()
    {
        return book;
    }

    public String getLastEditedDate()
    {
        return last_edited_date;
    }
    
    public int getChapterNum()
    {
        return chapter;
    }

    public String getText()
    {
        return text;
    }

    public User setUser(User user)
    {
        this.user = user;
        return this.user;
    }
        
    public Book setBook(Book book)
    {
        this.book = book;
        return this.book;
    }

    public String setLastEditedDate(String date)
    {
        last_edited_date = date;
        return last_edited_date;
    }
    
    public int setChapterNum(int chapter)
    {
        this.chapter = chapter;
        return this.chapter;
    }

    public String setText(String text)
    {
        this.text = text;
        return this.text;
    }
}
