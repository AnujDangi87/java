import java.util.Scanner;

public class StringOccurenceCheck {

    static void subCheck(String s, String ss)
    {
        
        String output="Found at indices : ";           //Initializing output string.
        int index, e;
        for (int i=0;i<s.length();i++)
        {
            index = i;              //To store the intial index of char where repeatation started.
            e = 0;                  //To store how many time a char is repeated.

            while((i!=s.length() && e != ss.length()) && s.charAt(i) == ss.charAt(e))
            {
                i++;            //increase i to see its next string char and substring char is same or not.
                e++;            //increase e if a char is same.
            }
            if (e==ss.length())
            {
                output = output + index +" ";             //adding index value in output.
            }
            else if(e!=0)
            {
                i = i-e;
            }
            

        }
        System.out.println(output);
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the string : ");
        String s = sc.nextLine();

        if (s.isEmpty())                //Input validation.
        {
            System.out.println("Error, string is empty. Exiting the program....");
        }
        else
        {
            System.out.print("Enter the substring : ");
            String ss = sc.nextLine();

            if (ss.isEmpty())               //Input validation.
            {
                System.out.println("Error, substring is empty. Exiting the program....");
            }
            else
                subCheck(s, ss);
        }
        sc.close();
        
    }
}
