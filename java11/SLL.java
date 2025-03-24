public class SLL 
{
    private Node head;              //Instance Node variable head that stores the address of head of Single link list.

    //Constructor that sets head as null.
    public SLL()
    {
        head = null;
    }
    
    //Constructor that copy a already existing Single link list.
    public SLL(SLL sll)
    {
        Node temp = sll.head;
        Node copy = new Node(temp.data);
        temp = temp.next;
        this.head = copy;
        
        
        while(temp != null)
        {
            copy.next = new Node(temp.data);
            copy = copy.next;
            temp = temp.next;
        }
    }
    
    //Overrided method toString that returns the string for single link list
    @Override
    public String toString()
    {
        if( head == null)
        {
            return "Single Link List is empty";
        }
        else
        {
            Node temp = head;
            String output = "";
            
            while(temp.next != null)
            {
                output = output + temp.data + " -> ";
                temp = temp.next;
            }
            output = output + temp.data;
            return output;
        }
    }
    
    //Overrided method equlas that returns if two SLL object has all node same data.
    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
            return true;
    
        if (obj == null || this.getClass()!=obj.getClass())
            return false;
            
        SLL other = (SLL)obj;
        
        Node tempThis = head;
        Node tempOther = other.head;
        
        boolean value = true;
        
        while(tempThis != null && tempOther != null)
        {
            if(tempThis.data != tempOther.data)
                value = false;
                
            tempThis = tempThis.next;
            tempOther = tempOther.next;
        }
        
        if(tempThis == null && tempOther == null && value == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //Methods that inset int d in the beginning of the Single link list
    public void insertAtBegin(int d)
    {
        if (head == null)           //If head is null then allocate memory to head and use Node constructor to add int d.
        {
            head = new Node(d);
        }
        else
        {
            head = new Node(d, head);           //If head is not null means list is not empty so allcoate a new Node memory and set d as data and head as next Node assing this Node to head.
        }
    }

    //Method that deletes node form begining.
    public int deleteAtBegin()
    {
        if(head == null)
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
        Node temp = head;

        while(temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = new Node(d);
    }

    //Methods that delete all list which contains d as its data value.
    public void deleteByValue(int d)
    {
        if(head == null)
        {
            return;             //If list is empty return.
        }
        else
        {
            Node temp = head;
            Node prev = null;
            Node next = head.next;

            //Checks for three case when value found at head other is value found at ending of list and last is value found in middle of list.
            while(temp != null)
            {
                if(temp.data == d)
                {
                    if(temp != head)
                    {
                        prev.next = next;
                    }
                    else
                    {
                        head = head.next;
                    }
                }
                else
                {
                    prev = temp;
                }

                if(next != null)
                {
                    next = next.next;
                }
                else
                    next = null;

                temp = temp.next;
            }
        }
        
    }

    //Methods that returns sum of the remaining data of list.
    public int getSum()
    {
        if(head == null)
        {
            return -1;
        }
        else
        {
            Node temp = head;
            int sum = 0;

            while(temp != null)
            {
                sum += temp.data;

                temp = temp.next;
            }

            return sum;
        }
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
            Node temp = head;

            System.out.print("List : ");
            while(temp != null)
            {
                if(temp.next != null)
                    System.out.print(temp.data + " -> ");
                else
                    System.out.print(temp.data);
                
                temp = temp.next;
            }
            System.out.println("");
        }
    }
}