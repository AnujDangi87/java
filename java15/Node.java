import java.io.Serializable;

class Node implements Serializable
{
    int data;
    Node next;

    public Node(int data)
    {
        this.data = data;
    }

    public Node(int data, Node n)
    {
        this.data = data;
        this.next = n;
    }

    public boolean insertAfter(int pos, int currPos, int newData)
    {
        if(pos == currPos )
        {
            Node temp = new Node(newData, next);
            next = temp;
            return true;
        }
        else
        {
            if(next == null)
            {
                return false;
            }
            else
            {
                return next.insertAfter(pos, currPos+1, newData);
            }
        }
    }

    public int getMax(int currentMax)
    {
        if(currentMax <= this.data && next != null)
            return next.getMax(this.data);
        else if(next != null)
            return next.getMax(currentMax);
        else
        {
            if(currentMax < this.data)
                return this.data;
            else
                return currentMax;
        }

    }

    public int getLength(int currLength)
    {
        currLength++;
        if(next != null)
            return next.getLength(currLength);
        else
            return currLength;
    }

    public boolean deleteNode(int pos, int currPos)
    {
        if(next != null && next.deleteNode(pos, currPos+1))
        {
            next = next.next;
            return false;
        }
        
        if(pos == currPos && next != null) 
        {
            return true;
        }
        else
        {
            if (pos == currPos)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

    }

    public void display()
    {
        if(next != null)
        {
            System.out.print(data + " -> ");
            next.display();
        }
        else{
            System.out.print(data);
        }
    }
}