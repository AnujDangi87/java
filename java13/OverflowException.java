public class OverflowException extends Exception
{
    //Overrided method that returns error string
    @Override
    public String toString()
    {
        return "Overflow exception, Stack is full!";
    }
}
