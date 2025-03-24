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
}