import java.util.*;

public class UOHCarrerPlatform
{
    public static void mainMenu()
    {
        System.out.println("------You Are?------");
        System.out.println("1.Student/Alumni");
        System.out.println("2.Recruiter");
        System.out.println("3.Admin");
        System.out.println("4.Exit the program.");
        System.out.print("Enter your choice : ");
    }
    
    public static void useCarrerPlatform()
    {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        StudentAlumni applicant = new StudentAlumni();
        Recruiter recruiter = new Recruiter();
        
        while(choice != 4)
        {
            mainMenu();
            
            try
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
                case 1: applicant.useStudentAlumni(sc);
                        break;
                case 2: recruiter.useRecruiter(sc);
                        break;
                case 3:
                        break;
                case 4: System.out.println("Exiting the program....");
                        break;
                default:System.out.println("Error, wrong input. Try again!!");
                        break;
            }
            if(choice != 4)
            {
                System.out.println("");
            }
        }
    }
    
    public static void main(String[] args)
    {
        useCarrerPlatform();
    }
}
