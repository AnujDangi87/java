import java.util.Scanner;           //importing Scanner class.

public class PaliChk {              

    static void PalindromeChecker(String s)             //method to check if a given string is palindrome or not.
    {
        s = s.replaceAll(" ", "");              //Removing all white spaces from given string.
        s = s.toLowerCase();

        boolean value = true;
        int start = 0, end = s.length()-1;

        while(start<end)
        {
            if(s.charAt(start) != s.charAt(end))
            {
                value = false;
                break;
            }
            start++;
            end--;
        }
        if (value)          //Checking if the given string and reverse string are equal or not(ignoring All case sensitve char).
        {
            System.out.println("Palindrome");
        }
        else
            System.out.println("Not Palindrome");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string to check if its a palindrome or not : ");

        String string = sc.nextLine();
        sc.close();

        PalindromeChecker(string);

    }
    
}
