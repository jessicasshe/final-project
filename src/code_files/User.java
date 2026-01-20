package code_files;

public class User {
    // keep email and password incase the user wants to change their login info
    private int user_id;
    private String user_type;
    private String email;
    private String password;
    private String name;
    private String last_date_read;
    private int streak; // for setting the menu streak;
    
    
    public User(int id, String type, String email, String pass, String name, String last_date_read, int streak)
    {
        user_id = id;
        user_type = type;
        this.email = email;
        this.name = name;
        password = pass;
        this.last_date_read = last_date_read;
        this.streak = streak;
    }
    
    public int getStreak()
    {
        return streak;
    }
    
    public int setStreak(int streak)
    {
        this.streak = streak;
        return this.streak;
    }
    
    public String getLastDateRead()
    {
        return last_date_read;
    }
    
    public String setLastDateRead(String date)
    {
        last_date_read = date;
        return last_date_read;
    }
    
    public int getUserStreak()
    {
        return this.streak;
    }
    
    public int setUserStreak(int streak)
    {
        this.streak = streak;
        return this.streak;
    }
                
    
    public String getEmail()
    {
        return email;
        
    }
    
    public boolean isAdmin()
    {
        return user_type.equals("Administrator");
    }
            
    public String getPassword()
    {
        return password;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String setName(String name)
    {
        this.name = name;
        return this.name;
    }
            
            
    public String setPassword(String pass)
    {
        password = pass;
        return password;
    }
            
            
    public String setEmail(String email)
    {
        this.email = email;
        return this.email;
    }
    
    public int getUserId()
    {
        return user_id;
    }
    
    public String getUserType()
    {
        return user_type;
    }
    
    public int setUserId(int id)
    {
        user_id = id;
        return user_id;
    }
            
    public String setUserType(String type)
    {
        user_type = type;
        return user_type;
    }
    
    
    
}
