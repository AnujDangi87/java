import java.util.Scanner;

public class UseStack {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the stack : ");
        int size  = sc.nextInt();
        
        Stack obj = new Stack(size);                //Making obj as instance of Stack class and giving int size as constructor argument.
        int choice;
        System.out.println("Choice you choice(int).");
        
        System.out.println("1.To push(char) element.");             //Menu driven user input.
        System.out.println("2.To pop elemtent.");
        System.out.println("3.To Peek the top element.");
        System.out.println("4.To Display the current stack.");
        System.out.println("5.Is stack empty?");
        System.out.println("6.Is stack is full?");
        System.out.println("7.To exit the program.");
        
        do
        {
            
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the element to push : ");
                    char element = sc.next().charAt(0);
                    System.out.println("Pushed : "+element);
                    obj.push(element);              //Pushing element at the top+1 index of stack.
                    
                    break;
                case 2:
                    char po = obj.pop();                //Poping the element at top index of stack.
                    if (po == '0')
                    {
                        System.out.println("Queue is Empty!");
                    }
                    else
                        System.out.println("Popped : "+po);
                    break;
                case 3:
                        if (obj.peek() == '0')
                        {
                            System.out.println("Queue is Empty!");
                        }
                        else
                        System.out.println("Top element : "+obj.peek());            //Peeking at the top index element.
                        break;
                case 4:
                    obj.display();              //Displaying the stack elements.
                    break;
                case 5:
                        System.out.println(obj.isEmpty());          //Print true if stack is empty.
                        break;
                case 6:
                        System.out.println(obj.isFull());           //Print true if stack is full.
                        break;
            
                default:
                    break;
            }

        }while(choice != 7);
        sc.close();
        
    }
}
