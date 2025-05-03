import java.util.Scanner;

class ArrayRotation
{
    static void arrRot(int arr[], int k, int n)
    {
        int[] outputArr = new  int[arr.length];
        for(int i=0;i<n;i++)
        {
            outputArr[i] = arr[(k+i)%n];
        }

        System.out.print("Rotated Elements are : ");
        for (int i=0;i<n;i++)
        {
            System.out.print(outputArr[i]+" ");
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