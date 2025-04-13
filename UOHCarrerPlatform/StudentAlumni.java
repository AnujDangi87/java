import java.util.*;

public class StudentAlumni
{
   static StudentAlumniDataStore userData = new StudentAlumniDataStore();
   
   public static void userMenu()
   {
       System.out.println("1.Display and apply for Jobs");
       System.out.println("2.Display applied jobs");
       System.out.println("3.Go back to Main Menu");
       System.out.println("4.Exit the program");
       System.out.print("Enter your choice : ");
   }
   
   public static int useStudentAlumni(Scanner sc)
   {
       System.out.print("Please enter your College Id : ");
       String userId = sc.nextLine();
           
       if(userData.getResume(userId) == null)
       {
           System.out.println("First time user Creating Resume-->");
           createUser(sc, userId);
           
       }
       
       System.out.println("Welcome " + userData.getResume(userId).getName());
       
       int choice = 0;
       while(choice != 3 && choice != 4)
       {
           try
            {
                choice = sc.nextInt();
            }
            catch(InputMismatchException ime)
            {
                choice = 0;
                sc.next();
            }
            
           switch(choice)
           {
               case 1: applyJobs(sc);
                       break;
               case 2: displayAppliedJobs(userId);
                       break;
               case 3: System.out.println("Going back to main menu....");
                       return 1;
               case 4: System.out.println("Exiting the program....");
                       return 0;
           }
       }
       return 0;
   }
   
   public static void createUser(Scanner sc,String userId)
   {
        String name;
        int age;
        String phoneNo;
        String skills;
        String about;
        
        System.out.print("Enter name : ");
        name = sc.nextLine();
        
        System.out.print("Enter age : ");
        while(true)
        {
            if(sc.hasNextInt())
            {
                age = sc.nextInt();
                break;
            }
            else
            {
                System.out.println("Error, Wrong input. Try again!!");
                System.out.print("Enter your age : ");
                sc.next();
            }
        }
        
        System.out.print("Enter phone number : ");
        phoneNo = sc.nextLine();
        
        System.out.print("Your skills : ");
        skills = sc.nextLine();
        
        System.out.print("Tell about yourself : ");
        about = sc.nextLine();
        
        Resume resume = new Resume(userId, name , age, phoneNo, skills, about);
        userData.addResume(resume);
   }
   
   public static void applyJobs(Scanner sc)
   {
       displayJobs();
       
       System.out.print("\nEnter Job number : ");
       int choice;
       while(true)
        {
            if(sc.hasNextInt())
            {
                choice = sc.nextInt();
                break;
            }
            else
            {
                System.out.println("Error, Wrong input. Try again!!");
                System.out.print("Enter Job number : ");
                sc.next();
            }
        }
        
        
   }
   
   public static void displayJobs()
   {
       HashMap<String, ArrayList<Job>> jobData = RecruiterDataStore.allJobs();
       int k=1;
       for(int j=1;j<=jobData.size();j++){
           ArrayList<Job> jobs = jobData.get("RE"+j);
           
           for(int i=0;i<jobs.size();i++)
           {
               System.out.println((k++)+". " + jobs.get(i));
               System.out.print("   ");
           }
        };
       
   }
   
   public static void displayAppliedJobs(String userId)
   {
       ArrayList<Job> appliedJobs = userData.getResume(userId).getJobs();
       ArrayList<Job> gotJobOffer = userData.getResume(userId).getGotJobOffer();
       
       for(int i=0;i<appliedJobs.size();i++)
       {
           System.out.println((i+1)+" " + appliedJobs.get(i));
           if( gotJobOffer.contains(appliedJobs.get(i)))
           {
               System.out.println("Got Job Offer : Yes");
           }
           else
           {
               System.out.println("Got Job Offer : No");
           }
           System.out.println();
       }
   }
}
