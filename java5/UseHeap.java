import java.util.Arrays;
import java.util.Scanner;

public class UseHeap 
{
    //Method to display the user menu.
    static void displayMenu()           
    {
        System.out.println("1.Insert");
        System.out.println("2.Delete");
        System.out.println("3.Build Heap(array)");
        System.out.println("4.Heap sort");
        System.out.println("5.Display heap");
        System.out.println("6.Exit");
        System.out.print("Enter your choice : ");
    }

    //Mehtod to implement the MaxHeap methods.
    static void heap()
    {
        Scanner sc = new Scanner(System.in);
        //Creating heap as instance of MaxHeap class.
        MaxHeap heap = new MaxHeap();

        int choice = 0;
        //Menu driven loop.
        while( choice != 6)
        {
            //Taking user choice.
            choice = sc.nextInt();
            //Eating the new line character.
            sc.nextLine();
            switch (choice)
            {
                case 1 :
                        System.out.print("Enter element to insert : ");
                        //Input validation for int element.
                        try 
                        {
                            heap.insert(sc.nextInt());
                        } 
                        catch (Exception e) 
                        {
                            System.out.println("Wrong input, Error : " + e);
                        }
                        //Eating next line character after taking int as input.
                        sc.nextLine();
                        //Displying the output.
                        heap.display_heap();
                        break;
                case 2 :
                        int temp = heap.delete();
                        //Error handling.
                        if(temp == -1)
                        {
                            break;
                        }
                        else
                        {
                            System.out.println("Output : " + temp);
                            heap.display_heap();
                        }

                        break;
                case 3 :
                        System.out.print("Enter array element(with spaces) : ");
                        //Taking string of the input.
                        String strBuild = sc.nextLine();
                        //Input validation to check if string is empty or not.
                        if(strBuild == "")
                        {
                            System.out.println("Error, array can't be empty!");
                            break;
                        }
                        //Calling stringToArray to convert string input into integer array.
                        int arrayBuild[] = stringToArray(strBuild);
                        //Giving int array as input for build_heap method.
                        heap.build_heap(arrayBuild);
                        heap.display_heap();
                        break;
                case 4 :System.out.print("Enter array element(with spaces) for sorting : ");
                        String strSort = sc.nextLine();
                        //Input validation
                        if(strSort == "")
                        {
                            System.out.println("Error, array can't be empty!");
                            break;
                        }
                        //Calling stringToArray to convert string input into integer array.
                        int arraySort[] = stringToArray(strSort);
                        heapSort(arraySort);
                        break;
                case 5 :
                        heap.display_heap();
                        break;
                
                case 6:
                        System.out.println("Exiting the program....");
                        break;
                default:
                        //Menu driven input validation.
                        System.out.println("Wrong input, please try agian!");
                        break;
            }
            if(choice != 6)
                System.out.print("\nEnter your choice : ");
        }
        sc.close();
    }

    //Method that converts string input into integer array and returns an int type array.
    static int[] stringToArray(String str)
    {
        //Removing starting and ending spaces.
        str = str.trim();
        //Using String library split method to convert input string into string array after each space.
        String []arr = str.split(" ");
        int []arrayInt = new int[arr.length];

        //Validating if string each element is int or not.
        for(int i=0;i<arr.length;i++)
        {
            try 
            {
                //Converting string converted array into int arrray using parsing.
                arrayInt[i] = Integer.parseInt(arr[i]);
            }
            catch (Exception e) 
            {
                System.out.println("Wrong input, Error : " + e);
            }      
        }

        return arrayInt;
    }

    //Method that sort given array into sorted array using heapify.
    static void heapSort(int []array)
    {
        MaxHeap heap = new MaxHeap();

        heap.build_heap(array);

        int []output = new int[array.length];

        System.out.print("Sorted Output : ");
        for(int i=0;i<array.length;i++)
        {
            output[array.length-i-1] = heap.delete();
        }
        //Using Arrays.toString method that converts the given array into string and returns it.
        System.out.println(Arrays.toString(output));
    }
    public static void main(String[] args) 
    {
        //Calling displayMenu and heap method.
        displayMenu();
        heap();

    }
}
