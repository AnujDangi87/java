public class User
{
    protected String userId;
    protected String password;
    
    public User(String userId, String password)
    {
        this.userId = userId;
        this.password = password;
    }
    
    public boolean validateUser(String password)
    {
        return this.password.equals(password);
    }
}
