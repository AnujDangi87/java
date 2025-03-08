public class Queue 
{
    NodeQueue front;                 //Instance Node variable front to point at the fornt of the queue list from where node is delted.
    NodeQueue rear;                  //Instance Node variable rear to point at the rear at the queue list at where new node is created.

    //Constructor that set front and rear as null.
    public Queue()
    {
        front = rear = null;
    }

    //Method that insert data at the rear node.
    public void enqueue(Node n)
    {
        if(front == null)
        {
            rear = new NodeQueue(n);
            front = rear;
        }
        else
        {
            rear.next = new NodeQueue(n);
            rear = rear.next;
        }
    }

    //Method that returns the deleted node data.
    public Node dequeue()
    {
        if(isEmpty())
            return null;

        Node temp;
        temp = front.data;
        if(front.next == null)
        {
            front = rear = null;
        }
        else
            front = front.next;

        return temp;
    }

    //Method that returns the front node data.
    public Node peek()
    {
        if (isEmpty())
            return null;

        return front.data;
    }

    //Method that retuns true if list is empty
    public boolean isEmpty()
    {
        if(front == rear && front == null)
            return true;
        else
          
            return false;
    }

    //Method that displays the queue
    public void display()
    {
        if(isEmpty())
        {
            System.out.println("Error, queue is Empty!");
            return;
        }

        NodeQueue temp = front;

        System.out.print("Queue : ");
        while(temp != null)
        {
            if (temp.next != null)
            {
                System.out.print(temp.data + " -> ");
            }
            else
                System.out.print(temp.data);
            
            temp = temp.next;
        }
        System.out.println("");
    }

    private class NodeQueue
    {
        public Node data;                //Instance int variable data that stores data for that particular node.
        public NodeQueue next;

        //Constructor that takes int d as argument and set data to d and left to null.
        public NodeQueue(Node d)
        {
            data = d;
            next = null;
        }
    }
}
