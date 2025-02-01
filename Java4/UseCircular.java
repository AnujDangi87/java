import java.util.Scanner;

public class UseCircular {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);                
        System.out.print("Enter the size of the queue : ");             
        int size  = sc.nextInt();               //Taking size of queue as user input.
        
        CircularQueue obj = new CircularQueue(size);                //Making obj as instance of CircularQueue class.
        int choice;               
        System.out.println("Choice you choice(int).");              //Menu driven input.
        System.out.println("1.To Enqueue element.");
        System.out.println("2.To Dequeue elemtent.");
        System.out.println("3.To Display the queue element.");
        System.out.println("4.To exit the program.");

        do
        {
            
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the element to enqueue : ");  
                    int element = sc.nextInt();
                    System.out.println("Enqueued : "+element);
                    obj.enqueue(element);               //Enqueue the element.
                    
                    break;
                case 2:
                    int deqe = obj.dequeue();           //Dequeue the element.
                    if (deqe == -1) 
                    {
                        System.out.println("Queue is Empty!");
                    }
                    else
                    System.out.println("Dequeued : "+deqe);
                    break;
                case 3:
                    obj.display();              //Displaying the queue elements.
                    break;
            
                default:
                    break;
            }

        }while(choice != 4);
        sc.close();
        
    }
}
