package loginandsignup;

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
    
    private String getEmail()
    {
        return email;
        
    }
            
    private String getPassword()
    {
        return password;
    }
            
            
    private String setPassword(String pass)
    {
        password = pass;
        return password;
    }
            
            
    private String setEmail(String email)
    {
        this.email = email;
        return this.email;
    }
    
    private int getUserId()
    {
        return user_id;
    }
    
    private String getUserType()
    {
        return user_type;
    }
    
    private int setUserId(int id)
    {
        user_id = id;
        return user_id;
    }
            
    private String setUserType(String type)
    {
        user_type = type;
        return user_type;
    }
    
    
    
}
