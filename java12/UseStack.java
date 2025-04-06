import java.util.Scanner;

public class UseStack {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the stack : ");
        int size  = sc.nextInt();
        
        Stack obj = new Stack(size);                //Making obj as instance of Stack class and giving int size as constructor argument.
        int choice;
        
        System.out.println("1.To push(char) element.");             //Menu driven user input.
        System.out.println("2.To pop elemtent.");
        System.out.println("3.To Peek the top element.");
        System.out.println("4.To Display the current stack.");
        System.out.println("5.Is stack empty?");
        System.out.println("6.Is stack is full?");
        System.out.println("7.To exit the program.");
        System.out.print("Enter your choice : ");
        do
        {
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to push : ");
                    char element = sc.next().charAt(0);
                    try             //Pushing element at the top+1 index of stack.
                    {
                        obj.push(element);
                        System.out.println("Pushed : "+element);
                    }
                    catch(OverflowException ofe)
                    {
                        System.out.println(ofe);
                    }
                    
                    break;
                case 2:
                        try
                        {
                            System.out.println("Popped : "+obj.pop());
                        }
                        catch(UnderflowException ufe)
                        {
                            System.out.println(ufe);
                        }
                        
                    break;
                case 3:try//Peeking at the top index element.
                        {
                            System.out.println("Top element : "+obj.peek());
                        }
                        catch(UnderflowException ufe)
                        {
                            System.out.println(ufe);
                        }
                        break;
                case 4:
                    obj.display();              //Displaying the stack elements.
                    break;
                case 5: try//Print true if stack is empty.
                        {
                              obj.isEmpty();
                              System.out.println("false");
                        }
                        catch(UnderflowException ufe)
                        {
                            System.out.println("true");
                        }          
                        break;
                case 6:try          //Print true if stack is full.
                        {
                              obj.isFull();
                              System.out.println("false");
                        }
                        catch(OverflowException ofe)
                        {
                            System.out.println("true");
                        }          
                        break;
                case 7 : System.out.println("Exiting the program....");
                    break;
                default: System.out.println("Wrong input, try again");
                        break;
                        
            }
            if (choice != 7)
                System.out.print("Enter your choice : ");

        }while(choice != 7);
        sc.close();
        
    }
}
