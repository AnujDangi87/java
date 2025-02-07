import java.util.Arrays;

class MaxHeap
{
    private int []heap;             //To store heap element
    private int size;               //To store how many elements are in heap;

    //Constructor method to initialize size and array.
    MaxHeap()
    {
        this.size = 0;       
        heap = new int[1];
    }

    //Method to insert given element in heap array.
    void insert(int element)
    {
        heap[size] = element;
        //Increasing the length of array to store the next insert element.
        heap = Arrays.copyOf(heap, heap.length+2);
        //Calling heapify method to check if max heap condition is fulfill or not.
        heapify(size);
        size++;
    }

    //Method to delete the root element
    int delete()
    {   
        //Error handling if the heap is empty.
        if (size == 0)
        {
            System.out.println("Error, heap is empty!");
            return -1;
        }
        else
        {
            //Swaping the root element of the heap with the last element of heap.
            int temp = heap[0];
            heap[0] = heap[size-1];
            size--;
            //Giving root index as input to check for max heap condition.
            heapify(0);
            return temp;
        }
    }

    //Method that check and arrange heap elements so that it follows max heap condition.
    void heapify(int index)
    {
        //If condtion to see if its heapify down.
        if (heap[index] < heap[(2*index) + 1] || heap[index] < heap[(2*index) + 2])
        {
            int largest = index;
            int l = (2*index) + 1;
            int r = (2*index) + 2;
            
            //If child of given index is larger in value than its parent than it swaps both value and gives that child index as recursive argument in heapify.
            if (heap[largest] < heap[l] && size > l)
                largest = l;
            if (heap[largest] < heap[r]  && size > r)
                largest = r;
            if(largest != index)
            {
                int temp = heap[largest];
                heap[largest] = heap[index];
                heap[index] = temp;
                heapify(largest);
            }
        }
        //If condition if its heapify up.
        else if( heap[(index-1)/2] < heap[index])
        {    
            //If index element is value is greater than its parent index value then it swaps both index value and gives parent index as argument for recursion heapify.
            int temp = heap[(index-1)/2];
            heap[(index-1)/2] = heap[index];
            heap[index] = temp;
            heapify((index-1)/2);   
        }
        else 
            return;
    }

    //Method that builds max heap array as taking array as argument.
    void build_heap(int []array)
    {
        //Inserting all elements of given array input.
        size = 0;
        for(int i=0;i<array.length;i++)
        {
            insert(array[i]);
        }
    }
    
    //Method to display heap elements.
    void display_heap()
    {
        if(size == 0)
        {
            System.out.println("Error, heap is empty!");
            return;
        }
        System.out.print("Heap : ");
        for(int i=0;i<size;i++)
        {
            System.out.print(heap[i] + " ");
        }
        System.out.println("");
    }

}