public class Queue 
{
    Node front;                 //Instance Node variable front to point at the fornt of the queue list from where node is delted.
    Node rear;                  //Instance Node variable rear to point at the rear at the queue list at where new node is created.

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
            rear = n;
            front = rear;
        }
        else
        {
            rear.left = n;
            rear = rear.left;
        }
    }

    //Method that returns the deleted node data.
    public int dequeue()
    {
        if(isEmpty())
            return -1;

        int temp;
        temp = front.data;
        if(front.left == null)
        {
            front = rear = null;
        }
        else
            front = front.left;

        return temp;
    }

    //Method that returns the front node data.
    public int peek()
    {
        if (isEmpty())
            return -1;

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

        Node temp = front;

        System.out.print("Queue : ");
        while(temp != null)
        {
            if (temp.left != null)
            {
                System.out.print(temp.data + " -> ");
            }
            else
                System.out.print(temp.data);
            
            temp = temp.left;
        }
        System.out.println("");
    }
}
