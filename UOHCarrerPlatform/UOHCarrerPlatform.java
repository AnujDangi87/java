import java.util.*;

public class UOHCarrerPlatform
{
    //Main menu for menu driven
    public static void mainMenu()
    {
        System.out.println("------You Are?------");
        System.out.println("1.Student/Alumni");
        System.out.println("2.Recruiter");
        System.out.println("3.Admin");
        System.out.println("4.Display Events");
        System.out.println("5.Exit the program.");
        System.out.print("Enter your choice : ");
    }
    
    //Method that check the useability of CarrerPlatform
    public static void useCarrerPlatform()
    {
        int choice = 0;
        Scanner sc = new Scanner(System.in);        //Scanner Class Object for reading
        StudentAlumni applicant = new StudentAlumni();          //StudentAlumni class object to perfom student/alumni related tasks
        Recruiter recruiter = new Recruiter();      //Recruiter class object to perform Recruiter related tasks
        Admin admin = new Admin("admin");
        
        //loop to keep switching between student/alumni, recruiter, admin using user menu driven
        while(choice != 5)
        {
            mainMenu();     //displaying main menu
            
            try     //Input validation for choice int variable
            {
                choice = sc.nextInt();
            }
            catch(InputMismatchException ime)
            {
                choice = 0;
            }
            sc.nextLine();      //Eating nextLine char in Buffer
            
            switch(choice)
            {
                case 1: applicant.useStudentAlumni(sc);         //For student/alumni
                        break;
                case 2: recruiter.useRecruiter(sc);             //For Recruiter
                        break;
                case 3: admin.useAdmin(sc);                        //For Alumni
                        break;
                case 4: admin.showEvents();
                        break;
                case 5: System.out.println("Exiting the program....");
                        break;
                default:System.out.println("Error, wrong input. Try again!!");
                        break;
            }
            if(choice != 5)
            {
                System.out.println("");
            }
        }
        sc.close();
    }
    
    public static void main(String[] args)
    {
        //Run useCarrerPlatform to use UOHCarrerPlatform
        useCarrerPlatform();
    }
}
