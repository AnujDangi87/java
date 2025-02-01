public class Stack {
    char []stack;               //Declaration of stack array and top variable.
    int top;

    Stack(int size)             //Constructor to set size of stack array.
    {
        stack = new char[size];
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

    void push(char element)             //Method to push element at the top+1 index in stack array.
    {
        if (isFull())
        {
            System.out.println("Stack is Full!");
            return;
        }

        stack[++top] = element;
    }

    char pop()              //Method to pop element from top index.
    {
        if (isEmpty())
        {
            return '0';
        }
        else
            return stack[top--];
    }

    char peek()                 //Method that return the top index element.
    {
        if(isEmpty())
        {
            return '0';
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
        System.out.println("Current Stack : ");
        for(int i=0;i<=top;i++)
        {
            System.out.print(stack[i]+" ");
        }
        System.out.println("");
    }
}
