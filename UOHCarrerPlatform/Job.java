import java.util.*;

public class Job
{
    String jobId;
    String title;
    int positionAvailable;
    String requirments;
    String about;
    String aboutRecruiters;
    ArrayList<Resume> applicantData = new ArrayList<Resume>();
    ArrayList<Resume> selectedApplicants = new ArrayList<Resume>();

    public Job(String jobId, String title, int positionAvailable, String requirments, String about, String aboutRecruiters)
    {
        this.jobId = jobId;
        this.title = title;
        this.positionAvailable = positionAvailable;
        this.requirments = requirments;
        this.about = about;
        this.aboutRecruiters = aboutRecruiters;
    }

    @Override
    public String toString()
    {
        String output = "";

        output += "Job Id : " + jobId + "\n   Job title : " + title + "\n   Available Positions : " + positionAvailable + "\n   Job Requirments : " + requirments + "\n   About Job : " + about + "\n   About recruiter : " + aboutRecruiters;

        return output;
    }
    
    public int getPositionAvailable()
    {
        return positionAvailable;
    }
    
    public void addApplicants(Resume resume)
    {
        applicantData.add(resume);
    }
    
    public ArrayList<Resume> getApplicants()
    {
        return applicantData;
    }
    
    public void addSelectedApplicants(Resume resume)
    {
        selectedApplicants.add(resume);
    }
    
    public ArrayList<Resume> getSelectedApplicants()
    {
        return selectedApplicants;
    }
}