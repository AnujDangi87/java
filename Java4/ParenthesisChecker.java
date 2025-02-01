import java.util.Scanner;

class ParenthesisChecker
{

    static boolean checkParenthesis(char []arr)             //Method to return true if String has ballanced parenthesis otherwise false.
    {
        if (arr.length%2 != 0)            //Checking for each open parenthesis there is close parenthesis.
        {
            return false;
        }

        String compliment = "(){}[]";           //Making a compliment String to check if its close char is present.

        Stack obj = new Stack(arr.length);            //Making obj instance of Stack Object giving string str length as constructor argument.

        for(int i=0;i<arr.length;i++)           //Validating if for each open braces there is close braces.
        {
            if (arr[i]=='(' || arr[i]=='[' || arr[i]=='{')
            {
                obj.push(arr[i]);
            }
            else if(arr[i]==')' || arr[i]==']' || arr[i]=='}')
            {
                for (int j=0;j<6;j=j+2)
                {
                    if(obj.peek() == compliment.charAt(j))
                    {
                        if (compliment.charAt(j+1) == arr[i])
                        {
                            obj.pop();
                            break;
                        }
                        else
                        {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string to check for its Parenthesis : ");
        String str = sc.nextLine();             //Taking string as input to check for its paranthesis.

        char []arr = str.toCharArray();             //Converting String str to char arr.
        sc.close();

        for(int i=0;i<arr.length;i++)               //Input validation.
        {
            if (!(arr[i]=='(' || arr[i]=='[' || arr[i]=='{' || arr[i]==')' || arr[i]==']' || arr[i]=='}'))
            {
                System.out.println("Error, wrong input string is not {},[],(). Exiting the program....");
                return;
            }
        }

        if(checkParenthesis(arr))               //Checking if checkParenthesis returns true or false.
        {
            System.out.println("Balanced");
        }
        else
            System.out.println("Unbalanced");
    }
}