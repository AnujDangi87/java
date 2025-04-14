import java.util.*;

public class Admin extends User
{
    private ArrayList<Event> eventDataStore = new ArrayList<Event>();
    
    public Admin(String password)
    {
        super("admin", password);
    }
    
    public void useAdmin(Scanner sc)
    {
       System.out.print("\nPlease enter admin password(enter -1 to go back) : ");
       String checkPassword = sc.nextLine();
       
       while(true)
       {
           if(checkPassword.equals("-1"))
               return;
           if(validateUser(checkPassword))
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
           //Displaying userMenu
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
    
    public void adminMenu()
    {
        System.out.println("\n1.Add event");
        System.out.println("2.Manage listing");
        System.out.println("3.Go back to main menu");
        System.out.print("Enter your Choice : ");
    }
    
    public void addEvent(Scanner sc)
    {
        String title;
        String date;
        
        System.out.print("\nTitle of the event : ");
        title = sc.nextLine();
        
        System.out.print("Date(dd-mm-yyyy) : ");
        date = sc.nextLine();
        
        System.out.print("About event : ");
        eventDataStore.add(new Event(title, date, sc.nextLine()));
    }
    
    public void manageListing(Scanner sc)
    {
        if(showEvents())
        {
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
