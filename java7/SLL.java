public class SLL {
    private Node head;              //Instance Node variable head that stores the address of head of Single link list.

    //Constructor that sets head as null.
    public SLL()
    {
        head = null;
    }

    //Methods that inset int d in the beginning of the Single link list
    public void insertAtBegin(int d)
    {   
        if(head == null )
            head = new Node(d);
        else
        {
            head = new Node(d, head);
        }
    }

    //Method that deletes node form begining.
    public int deleteAtBegin()
    {
        if (head == null)
        {
            return -1;
        }
        else
        {
            int temp = head.data;
            head = head.next;
            return temp;
        }
    }

    //Methods that inserts data at the ending of list.
    public void insertAtEnd(int d)
    {
        if(head == null)
        {
            head = new Node(d);
        }
        else
            head.insertAtEnd(d);
    }

    //Methods that delete all list which contains d as its data value.
    public void deleteByValue(int d)
    {
        if(head == null)
        {
            return;             //If list is empty return.
        }
        else if(head.deleteByValue(d) == 1)
        {
            head = head.next;
        }
    }

    //Method that uses Node object recursion to return sum of link
    public int getSum()
    {
        if(head == null)
            return -1;
        else
            return head.getSum();
    }

    //Methods that displays the remaining list.
    public void display()
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
