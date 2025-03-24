public class Stack extends ArrayLinearList
{
    //Instance variable top for stack semantic
    private int top;
    
    //Constructor
    public Stack(int[] arr)
    {
        super(arr);
        this.top = arr.length - 1;
    }
    
    //Overrided method that returns the stirng of all the elements of stack.
    @Override
    public String toString()
    {
        String output = "[ Top -> ";
        
        for(int i=top;i>0;i--)
        {
            output += arr[i] +", ";
        }
        output = output + arr[0] + " ]";
        
        return output;
    }
    
    //Overrided method that returns true if two stack are equal.
    @Override
    public boolean equals(Object other)
    {
        if (other == this)
            return true;
    
        if (other==null || this.getClass()!=other.getClass())
            return false;
            
        Stack obj = (Stack)other;
        
        if(this.top != obj.top)
        {
            return false;
        }
        
        for(int i=0;i<=this.top;i++)
        {
            if(this.arr[i] != obj.arr[i])
                return false;
        }
        
        return true;
    }
    
    //Overriding the inherited method that doesn't fulfill semantics of stack class
    public int get(int index)
    {
    System.out.println("Not accessible in Stack!");
    return -888;
    }
    
    //Overriding the inherited method that doesn't fulfill semantics of stack class
    public int remove(int index)
    {
        System.out.println("Not accessible in Stack!");
        return -888;
    }
    
    //Overriding the inherited method that doesn't fulfill semantics of stack class
    public void add(int index, int theElement)
    {
        System.out.println("Not accessible in Stack!");
        return;
    }
    
    //Overriding the inherited method that doesn't fulfill semantics of stack class
    public int indexOf(int theElement)
    {
        System.out.println("Not accessible in Stack!");
        return -888;
    }
    
    //Method that pushes element on top + 1 position
    public void push(int item)
    {
        super.add(++top, item);
    }
    
    //Method that pops the top element of stack
    public int pop()
    {
        return super.remove(top--);
    }
    
    //Method that returns the top most value
    public int peek()
    {
        return super.get(this.top);
    }
}