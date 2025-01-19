import java.util.Scanner;

public class BinarySearch {

    static int binarySearch(int n, int []arr, int k){
        int first = 0;              //first as initial index.
        int last = n-1;             //last as final index.
        int mid;
        while(first <= last)
        {
            mid = (first+last)/2;               //Taking mid as mid of first and last.
            
            if (arr[mid] == k)                  //checking if arr value at mid is equal to finding target or not.
            {
                return mid;
            }
            else if (arr[mid] > k)              //If not then checking target is smaller than arr mid value or not.
            {
                last = mid-1;                   //If yes changing last=mid-1 and first = 0;
            }
            else
            {
                first = mid+1;                  //If not changing first = mid+1 and last = n-1;
            }
        }
        return -1;                              //Returning -1 if target was not in the sorted array.
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of sorted array : ");
        int n = sc.nextInt();

        int []arr = new int[n];
        System.out.print("Enter sorted array element : ");
        for (int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the target element : ");
        int k = sc.nextInt();
        sc.close();

        System.out.println("index of target : "+binarySearch(n, arr, k));
    }
}
