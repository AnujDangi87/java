public class Node
{
    public int data;                //Instance int variable data that stores data for that particular node.
    public Node next;               //Instance Node varible that points to next Node.

    //Constructor that takes int d as argument and set data to d and next to null.
    public Node(int d)
    {
        data = d;
        next = null;
    }

    //Constructor that set data to d argument and Node next to Node n.
    public Node(int d, Node n)
    {
        data = d;
        next = n;
    }

    //Method that sets next Node to argument Node n.
    public void setNext(Node n)
    {
        next = n;
    }

    //Method that use Node object to insert at end
    public void insertAtEnd(int d)
    {
        if(next == null)
            next = new Node(d);
        else
            next.insertAtEnd(d);
    }

    //Method that use recursion to delete Nodes that contain that value
    public int deleteByValue(int d)
    {
        
        if( next != null && next.deleteByValue(d) == 1)
        {
            next = next.next;
        } 

        if(this.data == d) 
        {
            return 1;
        }
        else
            return 0;
    }

    //Method that uses Node object recursion to return sum.
    public int getSum()
    {
        if(next != null)
        {
            return this.data + next.getSum();
        }
        else
            return this.data;
    }
    
    //Method that display the list.
    public void display()
    {
        if(next != null)
        {
            System.out.print(this.data + " -> ");
            next.display();
        }
        else
            System.out.print(data);
    }
}
