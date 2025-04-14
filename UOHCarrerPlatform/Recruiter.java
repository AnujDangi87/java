import java.util.*;

public class Recruiter
{
   private RecruiterDataStore recruiterData;        //Intance variable to store the recruiter data with its posted jobs
   private String recruiterId;          //Instance variable that holds the current program using recruiter id
   
   //Constructor that initializes recruiterData memory
   public Recruiter()
   {
       recruiterData = new RecruiterDataStore();        
   }

   //Menu for Recruiter
   public void recruiterMenu()
   {
       System.out.println("\n1.Add new job");
       System.out.println("2.Display/Select Applicants");
       System.out.println("3.Display Jobs");
       System.out.println("4.Go back to main menu");
       System.out.print("Enter your choice : ");
   }
   
   //Loging in and checkig if recruiter exists
   public void useRecruiter(Scanner sc)
   {
       //User will enter null if its his first time in this program and Program will asign him
        //A new recruiterId which he will have to remember to log in for next time(id will be
        //In format id:- REno;ex.RE4
       while(true)
       {
           System.out.print("\nPlease enter your Recruiter Id (enter null if none): ");
           recruiterId = sc.nextLine();
               
           if(recruiterId.equals("null"))       //If recruiterId is null create a new RecruiterId
           {
               System.out.println("First time recruiter. Creating RecruiterId-->");
               recruiterId = "RE" + recruiterData.recruiterCount++;
               System.out.println("Your id is : " + recruiterId);
               recruiterData.addRecruiter(recruiterId);
               
           }
           else
           {
               if(!recruiterData.containsRecruiter(recruiterId))        //If entered id is not found in DataStore
                {
                    System.out.println("Recruiter Not found, try Again");
                    continue;
                }
           }
           
           System.out.println("\nWelcome recruiter id : " + recruiterId);
           break;
       }
       
       int choice = 0;
       while(choice != 4)
       {
           //Displaying the recruiter menu
           recruiterMenu();
           try              //Input validation
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
               case 1: recruiterData.addJob(recruiterId, addJob(sc, recruiterId));      //Creating new job
                        break;
               case 2: selectJob(sc, recruiterId);          //Display and select applicants
                       break;
               case 3: displayJobs();       //Display the jobs
                       break;
               case 4: System.out.println("Going back to main menu....");
                       break;
               default: System.out.println("Error, wrong input Try Again");
                       break;
           }
           
       }
   }
   
   //Mehtod to add the job in the current recruiter DataStore
   public Job addJob(Scanner sc, String recruiterId)
   {
        int noOfJobs = recruiterData.getJobs(recruiterId).size();       //Variable to give the job a uniqe id
        String jobId = recruiterId +  "-" + (++noOfJobs);           //jobId ex-:RE1-4;
        String title;
        int positionAvailable;
        String requirments;
        String about;
        String aboutRecruiters;
        
        System.out.print("\nCreating new Job-->\nTitle of the job : ");
        title = sc.nextLine();
        
        System.out.print("Position available : ");
        while(true)         //Input validation for int position(> 0)
        {
            if(sc.hasNextInt())
            {
                positionAvailable = sc.nextInt();
                sc.nextLine();
                if(positionAvailable <= 0)
                {
                    System.out.println("Error, position available can't be negative or zero Try agian");
                    System.out.print("Position available : ");
                    continue;
                }
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
        
        //Returning the job created
        return new Job(jobId, title, positionAvailable, requirments, about, aboutRecruiters);
   }
   
   //Selecting the jobs after printing it to see its available applicants and selcct 
   public void selectJob(Scanner sc, String recruiterId)
   {
       //If there in no jobs then print no jobs
       if(displayJobs())
       {
           //If the user enters wrong job number then give IndexOutOfBound exception
           try{
               System.out.print("\nEnter Job number : ");
               int choice;
               while(true)          //Input validation for int job choice
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
                
                //Geting job of no choice posted by current recruiter
               Job job = recruiterData.getJobs(recruiterId).get(choice-1);
               System.out.println("");
               
               //Also getting all the student/alumni resume who applied for the choice job
               ArrayList<Resume> applicants = job.getApplicants();
               
               if(applicants.size() == 0)       //If there are no one who applied
                   System.out.println("<--No applicants for specified job-->");
                else
                {
                    //Printing applicants resume
                    for(int i=0;i<applicants.size();i++)
                   {
                       System.out.println((i+1)+". " + applicants.get(i));
                       System.out.println("");
                   }
                   
                   System.out.println("");
                   
                   //If all the position is already filled then print error
                   int size = job.getApplicantsSize();
                   if(size == job.getPositionAvailable())
                   {
                       System.out.println("All position are already selected can't select anymore");
                       return;
                   }
                   //If position available then give choice to choose the applicant resume
                   for(int i=size;i<job.getPositionAvailable();i++)
                   {
                       System.out.print("Enter "+(i) +"st Applicant number(enter -1 if none) : ");
                       int resumeChoice = sc.nextInt();
                       sc.nextLine();
                       if(resumeChoice == -1)
                       {
                           break;
                       }
                       
                       //If the choosen resume is already choosed then print error else insert into selectedApplicant data
                       if(!job.containSelectedApplicants(applicants.get(resumeChoice-1)))
                       {
                           job.addSelectedApplicants(applicants.get(resumeChoice-1));
                           applicants.get(resumeChoice-1).addGotJobOffer(job);
                       }
                       else{
                           System.out.println("--Applicant already selected, select another one--");
                           i--;
                        }
                   }
            }
            }catch(IndexOutOfBoundsException e)
            {
                System.out.println("Error, job does not exist Try again");
            }
       }
    }
   
    //Method that displays the all the jobs of current recruiter
   public boolean displayJobs()
   {
       //Geting the jobs from current recruiter DataBase
       ArrayList<Job> jobs  = recruiterData.getJobs(recruiterId);
       
       //If no jobs
       if(jobs.size() == 0)
        {
            System.out.println("\n<--You have no jobs added-->");
            return false;
        }
        
        System.out.println("\n<-----Jobs----->");
       
       for(int i=0;i<jobs.size();i++)
       {
           System.out.println((i+1)+". " + jobs.get(i));
           System.out.println("");
       }
       return true;
   }
}
