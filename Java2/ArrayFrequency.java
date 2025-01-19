import java.util.Scanner;

public class ArrayFrequency {

    static void arrFreq(char arr[])
    {
        int []outArr = new int[10];             //Initializing array to store output array.

        for (int i=0;i<arr.length;i++)
        {
            outArr[arr[i]-48]++;                //increasing outArr value as it is repeated in given arr.
        }
        System.out.print("Output : ");
        for (int i=0;i<10;i++)
        {
            if (outArr[i]>0)
            {
                System.out.print(i+":"+outArr[i]);
                if (i!=9 && outArr[i]>0)
                {
                    System.out.print(", ");
                }
            }
            
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the elements without any space or coma(as a string) : ");
        String s = sc.nextLine();               //Taking a string as user input.
        sc.close();

        char []arr = s.toCharArray();           //Converting string to its individual char array.

        arrFreq(arr);
        
    }
    
}
