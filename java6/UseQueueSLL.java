import java.util.Scanner;

public class UseQueueSLL {

    //Static Method that displays user menu.
    static void displayMenu()
    {
        System.out.println("1.Enqueue (Add to the Queue)");
        System.out.println("2.Dequeue (Remove form front)");
        System.out.println("3.Peek (View front)");
        System.out.println("4.Is Queue Empty");
        System.out.println("5.Display queue");
        System.out.println("6.To exit the program");
        System.out.print("Enter your choice : ");
    }

    //Static Method for checking the useability of QueueSLL class.
    static void useQueueSLL()
    {
        int choice = 0;

        QueueSLL queue = new QueueSLL();
        Scanner sc = new Scanner(System.in);

        displayMenu();

        while(choice != 6)
        {
            choice = sc.nextInt();
            
            switch (choice)
            {
                case 1: System.out.print("Enter element(int) : ");
                        try
                        {
                            queue.enqueue(sc.nextInt());
                            queue.display();
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error : " + e + ". Wrong input, try again");                //Input validation.
                            sc.next();
                        }
                        
                        break;

                case 2: queue.dequeue();
                        queue.display();
                        break;

                case 3: if(queue.peek() != -1)
                            System.out.println("Front : "+queue.peek());
                        else
                            queue.display();
                        break;

                case 4: if(queue.isEmpty())         //Input validation.
                            System.out.println("Queue is Empty!");
                        else
                            System.out.println("Queue is not Empty!");
                        break;

                case 5: queue.display();
                        break;

                case 6: System.out.println("Exiting the program....");
                        break;

                default: System.out.println("Error, wrong input. Try again");
                        break;
            }

            if(choice != 6)
            {
                System.out.print("\nEnter your choice : ");
            }
        }
        sc.close();
    }
    public static void main(String[] args) {
        useQueueSLL();
    }
}
