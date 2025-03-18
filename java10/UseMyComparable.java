import java.util.Scanner;

public class UseMyComparable
{   
    //Method that displays menu driven main menu
    public static void mainMenu()
    {
        System.out.println("1.Ascending order");
        System.out.println("2.Desceding order");
        System.out.println("3.Prime order");
        System.out.println("4.Take array input agian");
        System.out.println("5.Display all order");
        System.out.println("6.Exit the program....");
        System.out.print("Enter your choice : ");
    }
    
    //Method that display the array data
    public static void display(int[] arr)
    {
        System.out.print("List : ");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    //Mehtod that use principle of substitution to perform sorting 
    public static void sortArray(int[] list, MyComparable comparator)
    {
        //Bubble sort
        for(int i=0;i<list.length;i++)
        {
            int j = i;
            while(j > 0)
            {
                if(comparator.compareTo(list[j-1], list[j]) == -1)
                {
                    int temp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = temp;
                    j--;
                }
                else
                {
                    break;
                }
            }
        }
    }
    
    //Method that takes input form user
    public static int[] arrayInput(Scanner sc)
    {
        System.out.print("Enter array (spaces between them) : ");
        String str = sc.nextLine().trim();
        String[] strArr = str.split(" ");
        int[] arr = new int[strArr.length];
        
        //Input validation
        try
        {
            for(int i=0;i<arr.length;i++)
            {
                    arr[i] = Integer.parseInt(strArr[i]);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error : " + e + ".\nWrong input,only integers is allowed. Enter any key to try again");            //Error handling (input validation)
            sc.next();
        }
        
        return arr;
    }
    
    //Method to check the useability of the Ascending, Descending and PrimeOrder class
    public static void useMyComparable(int[] arr, Scanner sc) 
    {
        int choice = 0;
        mainMenu();
        
        Ascending as = new Ascending();
        Descending ds = new Descending();
        PrimeOrder po = new PrimeOrder();
        
        while(choice != 6)
        {
            //Input validation
            try
            {
                choice = sc.nextInt();
                sc.nextLine();
            }
            catch(Exception e)
            {
                System.out.println("Error : " + e + ". Wrong input, try again");            //Error handling (input validation)
                sc.next();
            }

            switch (choice)
            {
                case 1: sortArray(arr, as);
                        display(arr);
                        break;

                case 2: sortArray(arr, ds);
                        display(arr);
                        break;
                        
                case 3: sortArray(arr, po);
                        display(arr);
                        break;
                        
                case 4: arr = arrayInput(sc);
                        break;

                case 5: sortArray(arr, as);
                        System.out.print("Ascending ");
                        display(arr);
                        
                        sortArray(arr, ds);
                        System.out.print("Descending ");
                        display(arr);
                        
                        sortArray(arr, po);
                        System.out.print("PrimeOrder ");
                        display(arr);
                        break;
                        
                case 6: System.out.println("Exiting the program....");
                        break;

                default: System.out.println("Error, wrong input. Try again");
                        break;
            }
            
            if(choice != 6)
            {
                System.out.print("\nEnter your choice : ");
            }
        }
        sc.close();
    }
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        //Input array
        int[] arr = arrayInput(sc);
        
         useMyComparable(arr, sc);
    }
}
