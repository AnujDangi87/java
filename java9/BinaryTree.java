public class BinaryTree
{
    Node root;

    public BinaryTree()
    {
        this.root = null;
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

    public void inOrderTraversal(Node n)
    {
        if(n == null)
        {
            return;
        }
        inOrderTraversal(n.left);
        System.out.println(n.data);
        inOrderTraversal(n.right);
    }

    public void preOrderTraversal(Node n)
    {
        if(n == null)
        {
            return;
        }
        System.out.println(n.data);
        preOrderTraversal(n.left);
        preOrderTraversal(n.right);
    }

    public void postOrderTraversal(Node n)
    {
        if(n == null)
            return;
        postOrderTraversal(n.left);
        postOrderTraversal(n.right);
        System.out.println(n.data);
    }
}
