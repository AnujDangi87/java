public class BinaryTree
{
    Node root;

    public BinaryTree(Node root)
    {
        this.root = root;
    }

    public void insert(int value)
    {
        if(root == null)
        {
            root = new Node(value);
        }
        else
        {
            Node n = root;

            while(n != null)
            {
                if(n.left == null)
                {
                    n.left = new Node(value);
                    break;
                }
                else if(n.right == null)
                {
                    n.right = new Node(value);
                    break;
                }

            }
        }
    }
}
