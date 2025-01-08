import java.util.Scanner;

public class MarksAnalysis {

    static float[] analyzeMarks(int[]  marks)
    {
        float max=marks[0], min=marks[0], sum=0;
        
        for (int i=1; i < marks.length; i++)
        {
            if (marks[i] > max)
            {
                max = marks[i];
            }
        }

        for (int i=1; i< marks.length; i++)
        {
            if (marks[i] < min)
            {
                min = marks[i];
            }
        }

        for (int i=0; i< marks.length; i++)
        {
            sum = sum + marks[i];
        }
        float []arr = {max, min, sum/marks.length};
        return arr;
        
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter no of Students(n) : ");
        int n = sc.nextInt();
        if ( n <= 0)
        {
            sc.close();
            System.out.println("Error, no of student is less than or equal to 0. Exiting the program....");
        }
        else
        {
            int []marks = new int[n];
            System.out.print("Enter the marks of student : ");
            for (int i=0;i<n;i++)
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
