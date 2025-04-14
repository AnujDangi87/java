import java.util.*;

public class StudentAlumni
{
   private StudentAlumniDataStore userData;     //Instance StudentAlumniDataStore variable to Store Student/Alumni data
   private String userId;           //Instance variable to store current Student/Alumni using program.
   
   //Constructor that allocate memory to userData variable.
   public StudentAlumni()
   {
       userData = new StudentAlumniDataStore();
   }
   
   //Method that display user Menu for Student/Alumni
   public void userMenu()
   {
       System.out.println("\n1.Display and apply for Jobs");
       System.out.println("2.Display applied jobs/see job update");
       System.out.println("3.Go back to Main Menu");
       System.out.print("Enter your choice : ");
   }
   
   //Method that perfoms Student/Alumni program
   public void useStudentAlumni(Scanner sc)
   {
       System.out.print("\nPlease enter your College Id : ");
       userId = sc.nextLine();
           
       if(userData.getResume(userId) == null)       //Checking if currentUser has before used this program or not
       {
           System.out.println("");
           System.out.println("First time user Creating Resume-->");
           createUser(sc);
           
       }
       
       System.out.println("\nWelcome " + userData.getResume(userId).getName());
       
       int choice = 0;
       while(choice != 3)
       {
           //Displaying userMenu
           userMenu();
           try          //Input vaidation
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
               case 1: displayJobs(sc);     //Displays the job to apply
                       break;
               case 2: if(!displayAppliedJobs())        //Display the applied jobs with its status
                       {
                           System.out.println("\n<--No applied Jobs right now-->");
                       }
                       break;
               case 3: System.out.println("Going back to main menu....");
                       break;
               default: System.out.println("Error, wrong input Try agian");
                        break;
           }
       }
   }
   
   //Create Student/Alumni resume if its there first time using the program
   public void createUser(Scanner sc)
   {
        String name;
        int age;
        String phoneNo;
        String skills;
        String about;
        
        System.out.print("Enter name : ");
        name = sc.nextLine();
        
        System.out.print("Enter age : ");
        while(true)         //Input validation 
        {
            if(sc.hasNextInt())
            {
                age = sc.nextInt();
                sc.nextLine();
                if(age <= 0)
                {
                    System.out.println("Age cannot be less than or equal to 0");
                    System.out.print("Enter your age : ");
                    continue;
                }
                break;
            }
            else
            {
                System.out.println("Error, Wrong input. Try again!!");
                System.out.print("Enter your age : ");
                sc.next();
            }
        }
        
        boolean value = true;
        phoneNo = "null";
        while(value)        //Validatin phone number 
        {
            System.out.print("Enter phone number : ");
            phoneNo = sc.nextLine();
            
            if(phoneNo.length() == 10)  //phone number should be 10 digits
            {
                if(phoneNo.charAt(0) != '0')        //should not have first digit 0
                {
                    for(int i=0;i<phoneNo.length()-1;i++)
                    {
                        value = true;
                        if(phoneNo.charAt(i+1) >= 48 && phoneNo.charAt(i+1) < 58)
                            value = false;
                    }
                    if(value == true)   //have a char between digits in phone number
                        System.out.println("Error, phone number should only contain digits");
                }
                else{
                    System.out.println("Error, phone number first digit should not be zero");
                }
            }
            else
            {
                System.out.println("Error, phone number must be of ten digits");
            }
            
        }
        
        System.out.print("Your skills : ");
        skills = sc.nextLine();
        
        System.out.print("Tell about yourself : ");
        about = sc.nextLine();
        
        userData.addResume(new Resume(userId, name , age, phoneNo, skills, about));     //Adding resume into dataStore
   }
   
   //Method that helps to apply for jobs
   public void applyJobs(Scanner sc, HashMap<String, ArrayList<Job>> jobData)
   {
        System.out.print("\nEnter Job number(enter -1 if none) : ");
        int choice;
        while(true)     //input validation
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
        
        if(choice == -1)        //If user don't want to select any job
        {
            return;
        }
        
        int k=1;        //Variable that increase as we read jobs in datastore
       for(int j=1;j<=jobData.size();j++){
           ArrayList<Job> jobs = jobData.get("RE"+j);   //Get jobs of recruiter 
           
           for(int i=0;i<jobs.size();i++)
           {
               if(k == choice)      //If the job is allign with the choice job of user
               {
                   Resume resume = userData.getResume(userId);      //get the resume
                   
                   if(!resume.containJob(jobs.get(i)))      //check if job is already applied or not
                   {
                       resume.addJob(jobs.get(i));          //Add job to resume appliedJob store
                       jobs.get(i).addApplicants(resume);       //Add resume to job applicantData store
                       
                       System.out.println("<--Request sent successfully-->");
                       return;
                   }
                   else {
                       System.out.println("--Request already sent--");
                       return;
                    }
               }
               k++;
           }
        }
        //Will reach to this line if there is no job of specified choice
        System.out.println("No job of given number\n");
    }
   
    //Method that displays the jobs with increasing order of recruiter and jobs
   public void displayJobs(Scanner sc)
   {
       HashMap<String, ArrayList<Job>> jobData = RecruiterDataStore.allJobs();      //Get the job data form RecruiterDataStore
       
       //If there is no jobs in DataStore
       if(jobData.size() == 0)
       {
           System.out.println("\n<--Sorry, there is no jobs right now-->");
           return;
       }
       System.out.println("<----Jobs---->");
       int k=1;
       for(int j=1;j<=jobData.size();j++){
           ArrayList<Job> jobs = jobData.get("RE"+j);       //Get the jobs according to recruiter id
           
           //Prints the job
           for(int i=0;i<jobs.size();i++)
           {
               System.out.println((k++)+". " + jobs.get(i));
           }
        }
       
        //call applyJobs to select the jobs and apply
        applyJobs(sc, jobData);
   }
   
   //Method that displays the Applied jobs by student/alumni
   public boolean displayAppliedJobs()
   {
       ArrayList<Job> appliedJobs = userData.getResume(userId).getJobs();   //Get all the jobs from the resume appliedJobs dataStore
       ArrayList<Job> gotJobOffer = userData.getResume(userId).getGotJobOffer();        //Get the jobs which in which the user has been selected
       
       //If there is  no jobs applied
       if(appliedJobs.size() == 0)
        {
            return false;
        }
       
       System.out.println("");
       //Display the applied jobs
       for(int i=0;i<appliedJobs.size();i++)
       {
           System.out.println((i+1)+". " + appliedJobs.get(i));
           if( gotJobOffer.contains(appliedJobs.get(i)))    //Checks if the appliedJob is in gotJobOffer means the user has been selected or not
           {
               System.out.println("   Got Job Offer : Yes");
           }
           else
           {
               System.out.println("   Got Job Offer : No");
           }
           System.out.println();
       }
       
       return true;
   }
}
