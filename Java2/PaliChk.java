import java.util.Scanner;           //importing Scanner class.

public class PaliChk {              

    static void PalindromeChecker(String s)             //method to check if a given string is palindrome or not.
    {
        String reverse = "";                    //Initializing a string variable to store reverse of given string.
        s = s.replaceAll(" ", "");              //Removing all white spaces from given string.
        for (int i=0;i<s.length(); i++)             //Using for loop to store reverse of given string in reverse variable.
        {
            reverse = s.charAt(i) + reverse;                //Cancatinating char at i index of given string in reverse string at front of string.
        }

        if (s.equalsIgnoreCase(reverse.toLowerCase()))          //Checking if the given string and reverse string are equal or not(ignoring All case sensitve char).
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
        System.out.println(string);
    }
    
}
