public class OverflowException extends Exception
{
    @Override
    public String toString()
    {
        return "Overflow exception, Stack is full!";
    }
}
