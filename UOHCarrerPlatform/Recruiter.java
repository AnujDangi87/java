import java.util.*;

public class Recruiter
{
    static RecruiterDataStore recruiterData;
    
   public Recruiter()
   {
       recruiterData = new RecruiterDataStore();
   }
   
   public static void recruiterMenu()
   {
       System.out.println("1.Add new job");
       System.out.println("2.Display/Select Applicants");
       System.out.println("3.Go back to main menu");
       System.out.println("4.Exit the program");
       System.out.print("Enter your choice : ");
   }
   
   public static void useRecruiter(Scanner sc)
   {
       System.out.print("\nPlease enter your Recruiter Id (enter null if none): ");
       String recruiterId = sc.nextLine();
           
       if(recruiterId.equals("null"))
       {
           System.out.println("First time recruiter. Creating RecruiterId-->");
           recruiterId = "RE" + recruiterData.recruiterCount++;
           System.out.println("Your id is : " + recruiterId);
           recruiterData.addRecruiter(recruiterId);
           
       }
       
       System.out.println("\nWelcome recruiter id : " + recruiterId);
       
       int choice = 0;
       while(choice != 3 && choice != 4)
       {
           recruiterMenu();
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
               case 1: recruiterData.addJob(recruiterId, addJob(sc, recruiterId));
                        break;
               case 2: selectJob(sc, recruiterId);
                       break;
           }
       }
   }
   
   public static Job addJob(Scanner sc, String recruiterId)
   {
        int noOfJobs = recruiterData.getJobs(recruiterId).size();
        String jobId = recruiterId +  "-" + (++noOfJobs);
        String title;
        int positionAvailable;
        String requirments;
        String about;
        String aboutRecruiters;
        
        System.out.print("Title of the job : ");
        title = sc.nextLine();
        
        System.out.print("Position available : ");
        while(true)
        {
            if(sc.hasNextInt())
            {
                positionAvailable = sc.nextInt();
                sc.nextLine();
                break;
            }
            else
            {
                System.out.println("Error, Wrong input. Try again!!");
                System.out.print("Position available : ");
                sc.next();
            }
        }
        
        System.out.print("Job Requirments : ");
        requirments = sc.nextLine();
        
        System.out.print("About Job : ");
        about = sc.nextLine();
        
        System.out.print("About the recruiters : ");
        aboutRecruiters = sc.nextLine();
        
        
        
        return new Job(jobId, title, positionAvailable, requirments, about, aboutRecruiters);
   }
   
   public static void selectJob(Scanner sc, String recruiterId)
   {
       displayJobs(recruiterId);
       
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
        
       Job job = recruiterData.getJobs(recruiterId).get(choice-1);
       
       System.out.println("");
       
       ArrayList<Resume> applicants = job.getApplicants();
       
       if(applicants.size() == 0)
           System.out.println("<--No applicants for specified job-->\n");
        else
        {
            for(int i=0;i<applicants.size();i++)
           {
               System.out.println((i+1)+". " + applicants.get(i));
               System.out.println("");
           }
           
           System.out.println("");
           for(int i=0;i<job.getPositionAvailable();i++)
           {
               System.out.print("Enter "+(i+1) +"st Applicant number(enter -1 if none) : ");
               int resumeChoice = sc.nextInt();
               sc.nextLine();
               if(resumeChoice == -1)
               {
                   break;
               }
               job.addSelectedApplicants(applicants.get(resumeChoice-1));
               applicants.get(resumeChoice-1).addGotJobOffer(job);
               
           }
        }
       
    }
   
   public static void displayJobs(String recruiterId)
   {
       ArrayList<Job> jobs  = recruiterData.getJobs(recruiterId);
       
       for(int i=0;i<jobs.size();i++)
       {
           System.out.println((i+1)+". " + jobs.get(i));
           System.out.println("");
       }
       
   }
}
