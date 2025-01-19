import java.util.Scanner;

class ArrayRotation
{
    static void arrRot(int arr[], int k, int n)
    {
        int tempEle = arr[n-1];
        int temp;               //Temp variable to store temp values.

        for (int i=0;i<k;i++)           //substituting values after k indices.
        {
            temp = arr[i];
            arr[i] = arr[i+k];
            if ( n%2 != 0)
            {
                
                arr[n-1-i] = temp;
            }
            else
            {
                arr[n-k+i] = temp;
            }
            
        }
        if (n%2 != 0)
        {
            arr[n/2] = tempEle;
        }

        System.out.print("Rotated Elements are : ");
        for (int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of elements in array : ");
        int n = sc.nextInt();
        System.out.print("Enter array element : ");

        int[] arr = new int[n];

        for (int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the value of k : ");
        int k = sc.nextInt();
        sc.close();
        arrRot(arr, k, n);

        
    }
}