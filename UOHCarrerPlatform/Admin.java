import java.util.*;

public class Admin extends User
{
    //Inheriting User which has userName and password instance variable
    private ArrayList<Event> eventDataStore = new ArrayList<Event>();   //ArrayList varibale to hold event
    
    //Constructor that calls super method to setup userName, password
    public Admin(String password)
    {
        super("admin", password);
    }
    
    //To check useability of Admin Class
    public void useAdmin(Scanner sc)
    {
        //Taking password for verification
       System.out.print("\nPlease enter admin password(enter -1 to go back) : ");
       String checkPassword = sc.nextLine();
       
       while(true)      //Input validation
       {
           if(checkPassword.equals("-1"))       //Return if user enters -1
               return;
           if(validateUser(checkPassword))      //If entered password is same as userPassword then exit loop and execute next steps else start loop agian
           {
               break;
           }
           else
           {
               System.out.println("Error wrong password, Try again");
               System.out.print("Please enter admin password(enter -1 to go back) : ");
               checkPassword = sc.nextLine();
           }
       }
       
       
       System.out.println("\nWelcome Admin");
       
       int choice = 0;
       while(choice != 3)
       {
           //Displaying Admin menu
           adminMenu();
           try          //Input vaidation
            {
                choice = sc.nextInt();
            }
            catch(InputMismatchException ime)
            {
                choice = 0;
            }
            sc.nextLine();
            
           switch(choice)
           {
               case 1: addEvent(sc);    //Adds event
                       break;
               case 2: manageListing(sc);       //Manage listing
                       break;
               case 3: System.out.println("Going back to main menu....");
                       break;
               default: System.out.println("Error, wrong input Try agian");
                        break;
           }
       }
    }
    
    //Display menu driven for admin
    public void adminMenu()
    {
        System.out.println("\n1.Add event");
        System.out.println("2.Manage listing");
        System.out.println("3.Go back to main menu");
        System.out.print("Enter your Choice : ");
    }
    
    //Method that adds events
    public void addEvent(Scanner sc)
    {
        //Taking input for event instance variable
        String title;
        String date;
        
        System.out.print("\nTitle of the event : ");
        title = sc.nextLine();
        
        System.out.print("Date(dd-mm-yyyy) : ");
        date = sc.nextLine();
        
        System.out.print("About event : ");
        //Adding event into eventDataStore
        eventDataStore.add(new Event(title, date, sc.nextLine()));
    }
    
    //Method that manages events
    public void manageListing(Scanner sc)
    {
        //If there are events then show them else do nothing
        if(showEvents())
        {
            //Taking eventNo to delete it
            System.out.print("Enter Event number(-1 for none) : ");
            int eventNo;
            while(true)         //Input validation 
            {
                if(sc.hasNextInt())
                {
                    eventNo = sc.nextInt();
                    sc.nextLine();
                    if(eventNo == -1)
                    {
                        return;
                    }
                    break;
                }
                else
                {
                    System.out.println("Error, Wrong input. Try again!!");
                    System.out.print("Enter Event number : ");
                    sc.next();
                }
            }
            
            //Exception handling if given eventNo-1 is not in arrayList indexes
            try{
                eventDataStore.remove(eventNo-1);
                System.out.println("<--Event removed-->");
            }
            catch(IndexOutOfBoundsException e)
            {
                System.out.println("No Event of given Number");
            }
        }
    }
    
    //Method that prints events and if there is event then return true else false
    public boolean showEvents()
    {
        if(eventDataStore.size() == 0)
        {
            System.out.println("<--No Events-->");
            return false;
        }
        System.out.println("<---Events--->");
        for(int i=0;i<eventDataStore.size();i++)
        {
            System.out.println((i+1)+". "+eventDataStore.get(i));
        }
        System.out.println("");
        return true;
    }
}
