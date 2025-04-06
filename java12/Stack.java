public class Stack{
    char []stack;               //Declaration of stack array and top variable.
    int top;

    Stack(int size)             //Constructor to set size of stack array.
    {
        stack = new char[size];
        top = -1;
    }

    boolean isFull() throws OverflowException            //Method to retrun true if stack is full otherwise false.
    {
        if (top == stack.length-1)
            throw new OverflowException();
        else
            return false;
    }

    boolean isEmpty() throws UnderflowException              //Method to return true if stack is empty otherwise false.
    {
        if(top == -1)
            throw new UnderflowException();
        else
            return false;
    }

    void push(char element) throws OverflowException            //Method to push element at the top+1 index in stack array.
    {
        isFull();
        
        stack[++top] = element;
    }

    char pop() throws UnderflowException              //Method to pop element from top index.
    {
        isEmpty();
        
        return stack[top--];
    }

    char peek() throws UnderflowException                 //Method that return the top index element.
    {
        isEmpty();
        
        return stack[top];
    }

    void display()              //Method that displays the stack element.
    {
        try
        {
            isEmpty();
        }
        catch(UnderflowException ufe)
        {
            System.out.println(ufe);
            return;
        }
        System.out.println("Current Stack : ");
        for(int i=0;i<=top;i++)
        {
            System.out.print(stack[i]+" ");
        }
        System.out.println("");
    }
}
