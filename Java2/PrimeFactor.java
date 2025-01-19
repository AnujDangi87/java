import java.util.Scanner;

public class PrimeFactor {

    static int[] primeFactor(int num)
    {
        int j=0;                        //index value for output array.
        int []arr= new int[20];         //Output array
        
        while(num != 1)                 //Loop until num becomes 1.
        {
            for (int i=2; i<=num; i++)
            {
                if (num%i == 0)             //Checking if num is divided by i or not.
                {                           //if yes put i into output array as a prime factor.
                    arr[j] = i;
                    j++;                    //incrementing j.
                    num = num/i;            //divide num by i.
                    break;
                }
            }
        }
        arr[j]=-1;                      //putting -1 at last index of arr.
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.err.print("Enter the number of which you want to find prime factor : ");
        int num = sc.nextInt();
        sc.close();
        int []factor = primeFactor(num);
        for (int i=0;factor[i]!=-1;i++)
        {
            System.out.println(factor[i]+" ");
        }
        
    }
}
