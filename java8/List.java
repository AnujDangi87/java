public class List
{
    int[] arr;
    int size;

    //Constructor in case zero line argument
    public List()
    {
        this.arr = new int[50];
        this.size = 0;
    }

    //Single argument to copy given arr to this.arr and size to arr length.
    public List(int[] arr)
    {
        this.arr = new int[50];

        for(int i=0;i<arr.length;i++)
        {
            this.arr[i] = arr[i];
        }

        this.size = arr.length;
    }

    //Method to return index value of founded position otherwise -1.
    public int find(int value)
    {
        if(size == 0)
        {
            return -2;
        }
        //Using for loop to check through all elements
        for(int i=0;i<size;i++)
        {
            if(arr[i] == value)
            {
                return i;
            }
        }
        return -1;
    }

    //Method that inserts elements at size index.
    public void insert(int value)
    {
        if(size >= 50)
        {
            return;
        }
        
        this.arr[size++] = value;
    }

    //Method that deletes the given value using find Method.
    public void delete(int value)
    {
        if(size == 0)
        {
            return;
        }
        else
        {
            int index = find(value);

            if(index == -1)
            {
                System.out.println("Error, element not found!");
                return;
            }
            else
            {
                if(index != -2 && index != -3)
                {
                    size--;
                    for(int i=index;i<size;i++)
                    {
                        arr[i] = arr[i+1];
                    }
                }
            }
        }
    }

    //Method to display the list elements
    public void display()
    {
        if(size == 0)
        {
            System.out.println("Error, List is empty!");
            return;
        }

        displayHelper();

        for(int i=0;i<size;i++)
        {
            if(i == size-1)
            {
                System.out.print(arr[i]);
            }
            else
            {
                System.out.print(arr[i] + " -> ");
            }
        }
        System.out.println("");
    }

    //Helper function that helps to print List in display
    public void displayHelper()
    {
        System.out.print("List : ");
    }
}