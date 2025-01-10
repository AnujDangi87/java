import java.util.Scanner;           //Importing Scanner class.

public class MarksAnalysis {

    static float[] analyzeMarks(int[]  marks)           //Method to find Average, Maximum and Minimum marks of student.
    {
        float max=marks[0], min=marks[0], sum=0;
        
        for (int i=1; i < marks.length; i++)            //To find Maxmimum marks.
        {
            if (marks[i] > max)
            {
                max = marks[i];
            }
        }

        for (int i=1; i< marks.length; i++)         //To find Minimum marks.
        {
            if (marks[i] < min)
            {
                min = marks[i];
            }
        }

        for (int i=0; i< marks.length; i++)             //To calculate total sum  of marks.
        {
            sum = sum + marks[i];
        }
        float []arr = {max, min, sum/marks.length};             //Returning array.
        return arr;
        
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter no of Students(n) : ");
        int n = sc.nextInt();
        if ( n <= 0)                    //Input validation.
        {
            sc.close();
            System.out.println("Error, no of student is less than or equal to 0. Exiting the program....");
        }
        else
        {
            int []marks = new int[n];
            System.out.print("Enter the marks of student : ");
            for (int i=0;i<n;i++)              //Taking marks of student using for loop.
            {
                marks[i] = sc.nextInt();
            }
            sc.close();

            float[] ans = analyzeMarks(marks);

            System.out.println("Maximum : "+ans[0]);
            System.out.println("Minimum : "+ans[1]);
            System.out.println("Average : "+ans[2]);
        }
    }
}
