import java.util.*;

public class Job extends User
{
    //Instance variable
    private String title;
    private int positionAvailable;
    private String requirments;
    private String about;
    private String aboutRecruiters;
    private ArrayList<Resume> applicantData = new ArrayList<Resume>();  //To store the applicants reusme who applied to this.job
    private ArrayList<Resume> selectedApplicants = new ArrayList<Resume>();     //To store the selected applicants resume

    //Constructor that initializes instance variables
    public Job(String jobId, String title, int positionAvailable, String requirments, String about, String aboutRecruiters)
    {
        super(jobId, "null");
        this.title = title;
        this.positionAvailable = positionAvailable;
        this.requirments = requirments;
        this.about = about;
        this.aboutRecruiters = aboutRecruiters;
    }

    //Overriding toString method so that it prints content fo current job
    @Override
    public String toString()
    {
        String output = "";

        output += "Job Id : " + userId + "\n   Job title : " + title + "\n   Available Positions : " + positionAvailable + "\n   Job Requirments : " + requirments + "\n   About Job : " + about + "\n   About recruiter : " + aboutRecruiters;

        return output;
    }
    
    //Method that returns available postion of jobs
    public int getPositionAvailable()
    {
        return positionAvailable;
    }
    
    //Method that add resume to applicantDaga
    public void addApplicants(Resume resume)
    {
        applicantData.add(resume);
    }
    
    //Method that returns applicantData
    public ArrayList<Resume> getApplicants()
    {
        return applicantData;
    }
    
    //Method that adds given resume into selectedApplicants ArrayList
    public void addSelectedApplicants(Resume resume)
    {
        selectedApplicants.add(resume);
    }
    
    //Method that returns ArrayList of selectedApplicants
    public ArrayList<Resume> getSelectedApplicants()
    {
        return selectedApplicants;
    }
    
    //Method that returns if given resume is in selectedApplicants ArrayList
    public boolean containSelectedApplicants(Resume resume)
    {
        return selectedApplicants.contains(resume);
    }
    
    //Method that returns applicantDataSize
    public int getApplicantsSize()
    {
        return applicantData.size();
    }
}