import java.util.Scanner;

public class StringPermutation {

    static void swap(char arr[], int first, int second)             //Method to swap elements of an array 
    {
        char temp;
        temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static void strPerm(int pos, char arr[])                        //Method to print and permuate the combination.
    {
        if (pos >= arr.length)                                      //Printing the output as the base condition of recursion.
        {
            for(int i=0;i<arr.length;i++)
            {
                System.out.print(arr[i]);
            }
            System.out.print("  ");
        }
        for (int i=pos;i<arr.length;i++)                            //Fixing a position and then giving recursion its next fixing position.
        {
            swap(arr, i, pos);
            strPerm(pos+1, arr);
            swap(arr, i, pos);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string(to find its possible permutation) : ");
        String s = sc.nextLine();
        sc.close();

        if (s.isEmpty())
        {
            System.out.println("Error string is empty, exiting the program....");
        }
        else
        {
            char []arr = s.toCharArray();                              //Converting string to array.

            strPerm(0, arr);
        }
    }
    
}
