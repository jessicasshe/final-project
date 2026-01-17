package code_files;

public class User {
    // keep email and password incase the user wants to change their login info
    private int user_id;
    private String user_type;
    private String email;
    private String password;
    private String name;
    
    public User(int id, String type, String email, String pass, String name)
    {
        user_id = id;
        user_type = type;
        this.email = email;
        this.name = name;
        password = pass;
    }
    
    public String getEmail()
    {
        return email;
        
    }
            
    public String getPassword()
    {
        return password;
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
