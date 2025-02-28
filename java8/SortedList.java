public class SortedList extends List
{

    //Constructor in case of array as input
    public SortedList(int[] arr)
    {   
        for(int i=0;i<arr.length;i++)
        {
            insert(arr[i]);
        }
    }

    //Method that override the parent class using binary search to find element.
    public int find(int value)
    {
        int f = 0, l = size-1;
        int m;

        while(f<=l)
        {
            m = (f+l)/2;

            if(arr[m] == value)
            {
                return m;
            }
            else if(arr[m] > value)
            {
                l = m-1;
            }
            else 
            {
                f = m+1;
            }
        }
        return -1*f;
    }

    //Method that insert element at index value from find return.
    public void insert(int value)
    {
        int index = find(value);

        if(index <= 0)
        {
            index *= -1;
        }
        
        int[] tempArr = new int[++size];

        int j = 0;
        for(int i=0;i<size;i++)
        {
            if(index == i)
            {
                tempArr[i] = value;
                continue;
            }
            tempArr[i] = arr[j++];
        }

        arr = tempArr;
    }

    //Parent class delete method will look for latest decleared method that is child class find overrided method(binary search)    

    //Helper function that helps print Sorted list in display.
    public void displayHelper()
    {
        System.out.print("Sorted List : ");
    }
}
