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
            return;
        }
        
        Queue q = new Queue();
        q.enqueue(root);

        while(!q.isEmpty())
        {
            Node temp = q.dequeue();

            if(temp.left == null)
            {
                temp.left = new Node(value);
                break;
            }
            else{
                q.enqueue(temp.left);
            }

            if(temp.right == null)
            {
                temp.right = new Node(value);
                break;
            }
            else
            {
                q.enqueue(temp.right);
            }
        }
    }

    public boolean search(int value)
    {
        if(root == null)
        {
            System.out.println("Error, tree is empty!");
            return false;
        }
        
        Queue q = new Queue();
        q.enqueue(root);

        while(!q.isEmpty())
        {
            Node temp = q.dequeue();

            if (temp.data == value)
                return true;

            if(temp.left != null)
                q.enqueue(temp.left);

            if(temp.right != null)
                q.enqueue(temp.right);
        }
        return false;
    }

    public Node delete(Node root, int value)
    {
        if (root == null) return null;

        // Use a queue to perform BFS
        Queue q = new Queue();
        q.enqueue(root);
        Node target = null;

        // Find the target node
        while (!q.isEmpty()) {
            Node curr = q.dequeue();

            if (curr.data == value) {
                target = curr;
                break;
            }
            if (curr.left != null) q.enqueue(curr.left);
            if (curr.right != null) q.enqueue(curr.right);
        }
        if (target == null) return root;

        // Find the deepest rightmost node and its parent
        Node lastNode = null;
        Node lastParent = null;
        Queue q1 = new Queue();
        Queue parentQueue = new Queue();
        q1.enqueue(root);
        parentQueue.enqueue(null);

        while (!q1.isEmpty()) {
            Node curr = q1.dequeue();
            Node parent = parentQueue.dequeue();

            lastNode = curr;
            lastParent = parent;

            if (curr.left != null) {
                q1.enqueue(curr.left);
                parentQueue.enqueue(curr);
            }
            if (curr.right != null) {
                q1.enqueue(curr.right);
                parentQueue.enqueue(curr);
            }
        
        }

         // Replace target's value with the last node's value
         target.data = lastNode.data;

         // Remove the last node
         if (lastParent != null) {
             if (lastParent.left == lastNode) lastParent.left = null;
             else lastParent.right = null;
         } else {
             return null;
         }
         return root;
     }
 
     // In-order traversal
     static void inorder(Node root) {
         if (root == null) return;
         inorder(root.left);
         System.out.print(root.data + " ");
         inorder(root.right);
    }

    public void inOrderTraversal(Node n)
    {
        if(n == null)
        {
            return;
        }
        inOrderTraversal(n.left);
        System.out.print(n.data + " ");
        inOrderTraversal(n.right);
    }

    public void preOrderTraversal(Node n)
    {
        if(n == null)
        {
            return;
        }
        System.out.print(n.data + " ");
        preOrderTraversal(n.left);
        preOrderTraversal(n.right);
    }

    public void postOrderTraversal(Node n)
    {
        if(n == null)
            return;
        postOrderTraversal(n.left);
        postOrderTraversal(n.right);
        System.out.print(n.data + " ");
    }
}
