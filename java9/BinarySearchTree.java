public class BinarySearchTree extends BinaryTree
{
    //Constructor
    public BinarySearchTree()
    {
        root = null;
    }

    //Insert Method that insert a node fulfilling bst property
    public void insert(Node root, int value)
    {
        if (root == null)
        {
            this.root = new Node(value);
            return;
        }

        if(root.left != null && root.data > value)
        {
            insert(root.left, value);
        }
        else if(root.right != null && root.data <= value)
        {
            insert(root.right, value);
        }
        else if(root.data > value)
        {
            root.left = new Node(value);
        }
        else if(root.data <= value)
        {
            root.right = new Node(value);
        }
    }

    //Search method that returns true when value is found
    public boolean search(Node root, int value)
    {
        if(root.data == value)
        {
            return true;
        }
        else if(root.data > value && root.left != null)
        {
            return search(root.left, value);
        }
        else if(root.data < value && root.right != null)
        {
            return search(root.right, value);
        }

        return false;
    }

    //Overrided delete method for bst
    public Node delete(Node root, int value)
    {
        if(root.data == value)
        {
            if(root.right == null && root.left == null)
            {
                root = null;
            }
            else if(root.right == null)
            {
                root.data = root.left.data;
                root.left = delete(root.left, root.left.data);
            }
            else
            {
                root.data = root.right.data;
                root.right = delete(root.right, root.data);
            }
        }
        else if(root.data > value && root.left != null)
        {
            root.left = delete(root.left, value);
        }
        else if(root.data < value && root.right != null)
        {
            root.right = delete(root.right, value);
        }

        return root;
    }

    //Returns left most node value
    public int finMin()
    {
        Node temp = root;

        while(temp.left != null)
        {
            temp = temp.left;
        }
        return temp.data;
    }

    //Returns right most node value.
    public int findMax()
    {
        Node temp = root;

        while(temp.right != null)
        {
            temp = temp.right;
        }
        return temp.data;
    }
}
