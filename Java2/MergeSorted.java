import java.util.Scanner;
public class MergeSorted {

    static int[] arr1 = new int[20];
    static int[] arr2 = new int[20];

    static void sortMerge(int l1, int l2, int []arr1, int []arr2)
    {
        int[] sarr = new int[l1+l2];                //Sorted merge array initialization.

        int i=0, j=0, count=0;

        while(i<l1 && j<l2)                 //Running while loop until one of two input array reach at its end.
        {
            if (arr1[i] <= arr2[j])         //Checking which of  arr first or array second element is smaller.
            {
                sarr[count] = arr1[i];      //Putting arr first element in output array at count index.
                i++;                        //increasing i.
            }
            else
            {
                sarr[count] = arr2[j];      //Putting arr second element in output array at count index.
                j++;                        //incrementing j.
            }
            count++;                    //incrmenting count.
        }
        while (j < l2)                  //Running while loop if second array is not at its end.
        {
            sarr[count] = arr2[j];
            j++;
            count++;
        }
        while(i < l1)                   //Running while loop if first array is not at its end.
        {
            sarr[count] = arr1[i];
            i++;
            count++;
        }
        for (int k=0;k<l1+l2;k++)
        {
            System.out.print(sarr[k] + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of first sorted array : ");
        int l1 = sc.nextInt();

        int[] arr1 = new int[l1];

        System.out.print("Enter the elements for first sorted array :  ");
        for (int i=0;i<l1;i++)              //Taking first sorted array input.
        {
            arr1[i] = sc.nextInt();
        }
        System.out.print("Enter the size of second sorted array : ");
        int l2 = sc.nextInt();

        int[] arr2 = new int[l2];

        System.out.print("Enter the elements for second sorted array :  ");
        for (int i=0;i<l2;i++)              //Taking second sorted array input.
        {
            arr2[i] = sc.nextInt();
        }
        sc.close();

        sortMerge(l1, l2, arr1, arr2);
    }
}
