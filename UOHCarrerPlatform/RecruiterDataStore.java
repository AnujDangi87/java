import java.util.ArrayList;
import java.util.HashMap;

//In this class all variables are static so that it can be assessed without object creation
public class RecruiterDataStore
{
    static int recruiterCount = 1;
    static private HashMap<String, ArrayList<Job>> dataStore = new HashMap<String, ArrayList<Job>>();   //HashMap that stores RecruiterId as key and its job ArrayList as its key
    
    //Method that add Recruiter in dataStore
    public void addRecruiter(String recruiterId)
    {
        dataStore.put(recruiterId, new ArrayList<Job>());
    }
    
    //Method that check if the RecruiterId is in DataStore or not
    public boolean containsRecruiter(String recruiterId)
    {
        return dataStore.containsKey(recruiterId);
    }
    
    //Method that add job in ArrayList<job> according to its recruiterID
    public void addJob(String recruiterId, Job job)
    {
        dataStore.get(recruiterId).add(job);
    }
    
    //Static Method that returns DataStore variable reference 
    public static HashMap<String, ArrayList<Job>> allJobs()
    {
        return dataStore;
    }
    
    //Mehtod that returns the ArrayList jobs according to given RecruiterID
    public ArrayList<Job> getJobs(String recruiterId)
    {
        return dataStore.get(recruiterId);
    }
    
}
