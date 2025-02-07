public class Stack 
{
    private String []stack;               //Declaration of stack String array and top variable.
    private int top;

    Stack(int size)             //Constructor to set size of stack String array.
    {
        stack = new String[size];
        top = -1;
    }

    boolean isFull()            //Method to retrun true if stack is full otherwise false.
    {
        if (top == stack.length-1)
            return true;
        else
            return false;
    }

    boolean isEmpty()               //Method to return true if stack is empty otherwise false.
    {
        if(top == -1)
            return true;
        else
            return false;
    }

    void push(String element)             //Method to push element at the top+1 index in stack String array.
    {
        if (isFull())
        {
            System.out.println("Stack is Full!");
            return;
        }

        stack[++top] = element;
    }

    String pop()              //Method to pop element from top index.
    {
        if (isEmpty())
        {
            return null;
        }
        else
            return stack[top--];
    }

    String peek()                 //Method that return the top index element.
    {
        if(isEmpty())
        {
            return null;
        }
        else
            return stack[top];
    }

    void display()              //Method that displays the stack element.
    {
        if (top == -1){
            System.out.println("Stack is Empty!");
            return;
        }
        System.out.print("Output : ");
        for(int i=0;i<=top;i++)
        {
            System.out.print(stack[i]);
        }
    }
}

