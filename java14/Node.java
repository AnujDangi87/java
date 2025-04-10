public class Node<T>
{
    public T data;                //Instance int variable data that stores data for that particular node.
    public Node<T> next;               //Instance Node varible that points to next Node.

    //Constructor that takes T d as argument and set data to d and next to null.
    public Node(T d)
    {
        data = d;
        next = null;
    }

    //Constructor that set data to d argument and Node next to Node n.
    public Node(T d, Node<T> n)
    {
        data = d;
        next = n;
    }

    //Method that sets next Node to argument Node n.
    public void setNext(Node<T> n)
    {
        next = n;
    }
    
    //Method that sets data to given argument d value.
    public void setData(T d)
    {
        data = d;
    }
}