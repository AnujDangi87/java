public class UnderflowException extends Exception
{
    //Overrided method that returns error string
    @Override
    public String toString()
    {
        return "Underflow Exception, Stack is empty!";
    }
}
