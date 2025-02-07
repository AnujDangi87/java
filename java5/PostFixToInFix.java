import java.util.Scanner;

class PostFixToInFix
{
    static void postIn(String []st)
    {
        Stack stack = new Stack(st.length);         //Creaing Instance of the class Stack
        String newStr = "";                 //String variable to store the resolved output.
        String temp;                        //String variable to store pop String.

        for(int i=0;i<st.length;i++)
        {
            //Checking if String st has first element as arithmetic operator.
            if((st[i].charAt(0) == '+' || st[i].charAt(0) == '-' || st[i].charAt(0) == '/' || st[i].charAt(0) == '*' ))
            {   
                //Poping stack top most string.
                temp = stack.pop();
                //And converting post to infix.
                newStr = newStr + "(" + stack.pop() + st[i] + temp + ")";
                stack.push(newStr);
                newStr = "";
            }
            else
            {
                //Pushing element if its not a arithmetic operator.
                stack.push(st[i]);
            }
        }
        stack.display();
    }
    public static void main(String[] args) 
    {
        
        Scanner sc = new Scanner(System.in);

        //Taking the postFix expression as input and storing in String variable.
        System.out.print("Input String(with space) : ");
        String str = sc.nextLine();
        sc.close();

        //Creating String array to store individual String in Strings st separated by space(" ").
        String []st = str.split(" ");

        //Calling postIn method that prints Infix expression of the given Infix String.
        postIn(st);
    }
}