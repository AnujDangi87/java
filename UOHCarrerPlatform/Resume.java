import java.util.*;

public class Resume
{
    String collegeId;       //Instance variable for student/alumni identification.
    String name;
    int age;
    String phoneNo;
    String skills;
    String about;
    ArrayList<Job> jobs = new ArrayList<Job>();
    ArrayList<Job> gotJobOffer = new ArrayList<Job>();
    
    //Constructor that initializes the instance variables.
    public Resume(String collegeId, String name, int age, String phoneNo, String skills, String about)
    {
        this.collegeId = collegeId;
        this.name = name;
        this.age = age;
        this.phoneNo = phoneNo;
        this.skills = skills;
        this.about = about;
    }
    
    @Override
    public String toString()
    {
        String output = "";
        
        output += "College ID : " + collegeId + "\n   Name : " + name + "\n   Age : " + age + "\n   Phone Number : " + phoneNo + "\n   Skills : " + skills + "\n   About : " + about;
        
        return output;
    }
    
    public String getId()
    {
        return collegeId;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void addJob(Job job)
    {
        jobs.add(job);
    }
    
    public ArrayList<Job> getJobs()
    {
        return jobs;
    }
    
    public void addGotJobOffer(Job job)
    {
        gotJobOffer.add(job);
    }
    
    public ArrayList<Job> getGotJobOffer()
    {
        return gotJobOffer;
    }
    
    public boolean containJob(Job job)
    {
        return jobs.contains(job);
    }
}
