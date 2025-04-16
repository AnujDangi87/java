public class User
{
    //Instance variable for user
    protected String userId;
    protected String password;
    
    //Constructor that sets userId and password
    public User(String userId, String password)
    {
        this.userId = userId;
        this.password = password;
    }
    
    //Method to validate user with given password
    public boolean validateUser(String password)
    {
        return this.password.equals(password);
    }
}
