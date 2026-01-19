
package code_files;

public class Announcement {
    private int user_id;
    private String text;
    private String date;
    
    public Announcement(int user_id, String text, String date)
    {
        this.user_id = user_id;
        this.text = text;
        this.date = date;
    }
        
    public int getUserId()
    {
        return user_id;
    }
    
    public String getText()
    {
        return text;
    }
    
    public String getDate()
    {
        return date;
    }
    
}
