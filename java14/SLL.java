public class SLL<T>
{
    private Node<T> head;              //Instance Node variable head that stores the address of head of Single link list.

    //Constructor that sets head as null.
    public SLL()
    {
        head = null;
    }

    public void insertAt(T data, int pos) throws PositionNotExist
    {
        if(pos < 0)     //Throws a exeption if pos is given negative.
            throw new PositionNotExist();
        
        if (head == null && pos == 0)           //If head is null then allocate memory to head and use Node constructor to add T d.
        {
            head = new Node<T>(data);
            return;
        }
        
        Node<T> temp = head;
        Node<T> prev = null;
        
        for(int i=0;i<=pos;i++)         //Finding the pos to add the T data if not found throws exception
        {
            if(temp == null && i != pos)
                throw new PositionNotExist();
            
            if(i == pos)
            {
                if (temp == null)
                    prev.next = new Node<T>(data, null);
                else
                    temp.setData(data);
                return;
            }
            prev = temp;
            temp = temp.next;
        }
        
    }
    
    //Methods that delete all list which contains d as its T value.
    public void delete(T d) throws ValueNotFound
    {
         if(head == null)
             throw new ValueNotFound();
         
         Node<T> temp = head;
         Node<T> prev = null;
         
         while(temp != null) 
         {
             if( d == temp.data )
             {
                 if(temp == head)           //Deleting head
                 {
                     head = head.next;
                 }
                 else if(temp.next == null)     //Deleting last node of sll.
                 {
                     prev.next = null;
                 }
                 else           //Remaning nodes i.e. middle nodes between head and last node.
                 {
                     prev.next = temp.next;
                 }
                 return;
             }
             
             prev = temp;
             temp = temp.next;
         }
         
         //If value is not found throws ValueNotFound exception
         throw new ValueNotFound();
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
            Node<T> temp = head;

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
