import java.util.Scanner;

public class UseTaskManager
{
    //Main menu method 
    public static void mainMenu()
    {
        System.out.println("1. Add Task");
        System.out.println("2. Retrive Task");
        System.out.println("3. Display Tasks");
        System.out.println("4. Exit the program....");
        System.out.print("Enter your choice : ");
    }
    
    //Method that check useability of TaskManager class
    public static void useTaskManager()
    {
        int choice = 0;
        
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        
        mainMenu();
        
        while(choice != 4)
        {
            try                         //Input validation
            {
                choice = sc.nextInt();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            sc.nextLine();
            
            switch (choice)
            {
                case 1: System.out.print("\nEnter id : ");
                        String id = sc.nextLine();
                        System.out.print("Enter description : ");
                        String description = sc.nextLine();
                        System.out.print("Enter priority(high-1, medium-2, low-3) : ");
                        int priority;
                        while(true)
                        {
                            if(sc.hasNextInt())     //Error handling
                            {
                                priority = sc.nextInt();
                                sc.nextLine();
                                if(priority <= 0 || priority >= 4)
                                {
                                    System.out.println("Error, only integer(> 0 & < 4). Try again!!");
                                    System.out.print("Enter priority(high-1, medium-2, low-3) : ");
                                    continue;
                                }
                                break;
                            }
                            else
                            {
                                System.out.println("Error, only integer(> 0 & < 4). Try again!!");
                                System.out.print("Enter priority(high-1, medium-2, low-3) : ");
                                sc.nextLine();
                            }
                        }
                        manager.addTask(new Task(id, description, priority));
                        break;

                case 2: Task priorityTask = manager.getHighestPriorityTask();
                        if(priorityTask == null)
                        {
                            System.out.println("Error, No Tasks!!");
                        }
                        else
                            System.out.println("\nRetrived Task : " + priorityTask);
                        break;
                        
                case 3: manager.viewTasks();
                        break;
                
                case 4: System.out.println("Exiting the program....");
                        break;

                default: System.out.println("Error, wrong input. Try again");
                        break;
            }
            
            if(choice != 4)
            {
                System.out.println();
                mainMenu();
            }

        }
        
        sc.close();
    }
    
    public static void main(String[] args)
    {
        useTaskManager();
    }
}