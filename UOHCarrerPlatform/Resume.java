import java.util.*;

public class Resume extends User
{
    //Instance variable for student/alumni identification.
    private String name;
    private int age;
    private String phoneNo;
    private String skills;
    private String about;
    private ArrayList<Job> appliedJobs = new ArrayList<Job>();     //To store the applied Jobs of current user
    private ArrayList<Job> gotJobOffer = new ArrayList<Job>();      //To store the appliedJobs in which the user is selected
    
    //Constructor that initializes the instance variables.
    public Resume(String collegeId, String name, int age, String phoneNo, String skills, String about)
    {
        super(collegeId, "null");
        this.name = name;
        this.age = age;
        this.phoneNo = phoneNo;
        this.skills = skills;
        this.about = about;
    }
    
    //Overrided toString method that tell about the resume details
    @Override
    public String toString()
    {
        String output = "";
        
        output += "College ID : " + userId + "\n   Name : " + name + "\n   Age : " + age + "\n   Phone Number : " + phoneNo + "\n   Skills : " + skills + "\n   About : " + about;
        
        return output;
    }
    
    //Method that returns collegeId of the user
    public String getId()
    {
        return userId;
    }
    
    //Method that returns the name of the user
    public String getName()
    {
        return name;
    }
    
    //Method that add job to the applied appliedJobs
    public void addJob(Job job)
    {
        appliedJobs.add(job);
    }
    
    //Method that returns ArrayList of appliedJobs
    public ArrayList<Job> getJobs()
    {
        return appliedJobs;
    }
    
    //Method that add job to gotGotOffer ArrayList
    public void addGotJobOffer(Job job)
    {
        gotJobOffer.add(job);
    }
    
    //Mehtod that returns the gotGobOffer ArrayList
    public ArrayList<Job> getGotJobOffer()
    {
        return gotJobOffer;
    }
    
    //Method that checks if the given job is in applliedJobs or not
    public boolean containJob(Job job)
    {
        return appliedJobs.contains(job);
    }
}
