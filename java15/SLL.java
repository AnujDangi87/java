import java.io.Serializable;

class SLL implements Serializable
{
    Node head;

    public SLL()
    {
        this.head = null;
    }

    public void insertAfter(int position, int data)
    {
        if(position < 0)
        {
            System.out.println("Error, given position can't be negative");
            return;
        }
        if(head == null && position != 0)
        {
            System.out.println("Error, list is empty and your are inserting element in wrong postition.");
            return;
        }
        else if(head == null && position == 0)
        {
            head = new Node(data);
            displayList();
            return;
        }
        else if(head != null && position == 0)
        {
            head = new Node(data, head);
            displayList();
        }
        else
        {
            if(head.insertAfter(position, 1, data))
            {
                displayList();
            }
            else
            {
                System.out.println("Error, given position is greater then list total positions");
                return;
            }
        }
    }

    public int Max()
    {
        if(head != null)
            return head.getMax(head.data);
        else
            displayList();
        return -1;
    }

    public int length()
    {
        if(head != null)
        {
            return head.getLength(0);
        }
        else
            displayList();
        return -1;
    }

    public void deleteNode(int position)
    {
        if(head == null && position != 0)
        {
            System.out.println("Error, list is empty and your are deleting element in wrong postition.");
            return;
        }
        else if(position <= 0)
        {
            System.out.println("Error, given position can't be neagtive or zero");
            return;
        }
        else
        {
            if(head.deleteNode(position, 1))
            {
                head = head.next;
                displayList();
            }
            else
            {
                displayList();
                return;
            }
        }
    }

    public void displayList()
    {
        if(head == null)
        {
            System.out.println("Error, list is empty!");
            return;
        }
        else
        {
            System.out.print("List : ");
            head.display();
            System.out.println("");
        }
    }
}