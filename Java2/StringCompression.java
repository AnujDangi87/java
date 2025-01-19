import java.util.Scanner;

public class StringCompression {

    static int stringComp(String string)
    {
        if (string.isEmpty())               //Error validation if given string is empty.
        {
            System.out.println("Error string is empty. Exiting the program....");
            return 0;
        }
        else
        {
            for (int i=0;i<string.length();i++)
            {
                if (string.codePointAt(i)<58 && string.codePointAt(i)!=32)           //Error validation if given string contains any numerical value.
                {
                    System.out.println("Error string contain numerical value. Exiting the program....");
                    return 0;
                }
            }
        }
        
        String output="";           //Initializing output string.
        int index, e;
        for (int i=0;i<string.length();i++)
        {
            index = i;              //To store the intial index of char where repeatation started.
            e = 1;                  //To store how many time a char is repeated.

            while((string.length()-1 != i && string.charAt(i) == string.charAt(i+1)))
            {
                i++;            //increase i to see if its next char is same or not.
                e++;            //increase e if a char is same.
            }
            if (e>1)
            {
                output = output + string.charAt(index) + e;             //adding compressed value in output.
            }
            else
                output = output + string.charAt(index);                 //adding simple index value if char is not repeated.

        }
        System.out.println("Compressed string : "+output);
        return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the string(to compress) : ");
        String string = sc.nextLine();
        sc.close();

        stringComp(string);
        
    }
    
}
