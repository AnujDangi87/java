import java.util.Scanner;

public class ReverseWord {

    static void revWrd(String s)
    {

        String[] str = s.split(" ");            //Using split inbuilt method to return substrings after each space in string array variable str.

        for (int i=str.length-1;i>=0;i--)
        {
            System.out.print(str[i]+" ");           //Printing reverse of array str
        }
        /* 
        s = s.trim();                           //Another long method only for two words.
        int index = s.lastIndexOf(" ");
        String output = "";

        for(int i=index+1;i<s.length();i++)
        {
            output = output + s.charAt(i);
        }
        output = output + " ";
        for (int i=0;i<index;i++)
        {
            output = output + s.charAt(i);
        }
        System.out.println(output);*/
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the string(to reverse it) : ");
        String s = sc.nextLine();
        sc.close();
        
        if (s.isEmpty())
            System.out.println("Error, String is empty. Exiting the program....");
        else
            revWrd(s);
    }
    
}
