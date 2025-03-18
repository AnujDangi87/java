class ArrayLinearList{
    
    // Instance Variables
    int n;        // Acts as a pointer. Points to last element in the array
    int arr[];

    // Constructors

    public ArrayLinearList()
    {
        this.n = 0;
        this.arr = new int[100];    // Array Maximum SIZE is 100
    }

    public ArrayLinearList(int n, int ar[])
    {
        this.n = n;
        this.arr = new int[100];    // Array Maximum SIZE is 100
        
        for(int i = 0; i < n; i++)
        {
            this.arr[i] = ar[i];
        }
    }
    
    //Methods
    public boolean isEmpty()
    {
        if(this.n == 0 || this.arr == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public int size()
    {
        return n;
    }
    
    public int get(int index)
    {
        if(index >= n || index < 0)
        {
            System.out.println("\nIndex Out of Bound. -999 will be returned");
            return -999;
        }
        else
        {
            return arr[index];
        }
    }
    
    public int indexOf(int theElement)
    {
        for (int i = 0; i < n; i++)
        {
            if(arr[i] == theElement)
            {
                return i;
            }
        }
        System.out.println("\nElement Not Found. -1 will be Returned");
        return -1;
    }

    public int remove(int index)
    {
        if(index >= n || index < 0)
        {
            System.out.println("Index Out of Bound. -999 will be returned");
            return -999;
        }
        int k = arr[index];
        for(int i = index ; i < n; i++)
        {
            arr[i] = arr[i+1];
        } 
        this.n = n -1;
        return k; 
    }
    public void add(int index, int theElement)
    {
        if( n+1 >= 100)
        {
            System.out.println("Cannot Add Furthur Elements. Maximum Size is 100\n");
            return;
        }
        else if(index > n)
        {    
            System.out.println("Cannot add element at index "+index+ ". Array size is at "+n);
            return;
        }
        else
        {
            for (int i = n; i >= index + 1; i--)
            {
                arr[i] = arr[i - 1];
            }
            arr[index] = theElement;
            this.n = n + 1;            
            return;
        }
    }

    public String toString()
    {
        String s =  "[";
        
        for(int i = 0; i < n; i++)
        {
            if(i == n - 1)
            {
                s = s + arr[i] + " ";
                break;
            }
            s = s + arr[i] + ", ";
        }
        s = s + "]";        
        return s;    
    }
}
