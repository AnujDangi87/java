public class HeterogeneousStack{
    Object []stack;               //Declaration of Object type array and top variable.
    int top;

    HeterogeneousStack(int size)             //Constructor to set size of Object array.
    {
        stack = new Object[size];
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

    void push(Object element) throws OverflowException            //Method to push element at the top+1 index in stack array.
    {
        isFull();
        
        stack[++top] = element;
    }

    Object pop() throws UnderflowException              //Method to pop element from top index.
    {
        isEmpty();
        
        return stack[top--];
    }

    Object peek() throws UnderflowException                 //Method that return the top index element.
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
            if(stack[i].getClass().getName() == "java.lang.Integer")
            {
                System.out.println("Int : " + stack[i] );
            }
            else if(stack[i].getClass().getName() == "java.lang.String")
            {
                System.out.println("String : " + stack[i] );
            }
            else
                System.out.println(stack[i] );
                
            if(i != top)
                System.out.println();
        }
    }
}
