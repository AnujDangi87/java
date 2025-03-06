public class Node
{
    public int data;                //Instance int variable data that stores data for that particular node.
    public Node left;               //Instance Node varible that points to left Node.
    public Node right;

    //Constructor that takes int d as argument and set data to d and left to null.
    public Node(int d)
    {
        data = d;
        left = null;
        right = null;
    }

    //Constructor that set data to d argument and Node left to Node n.
    public Node(int d, Node n)
    {
        data = d;
        left = n;
        right = null;
    }
    public Node(int d, Node left, Node right)
    {
        data = d;
        this.left = left;
        this.right = right;
    }

    public void setChild(Node left, Node right)
    {
        this.left = left;
        this.right = right;
    }
    
}
