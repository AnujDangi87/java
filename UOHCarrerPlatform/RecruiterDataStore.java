import java.util.ArrayList;
import java.util.HashMap;

public class RecruiterDataStore
{
    static int recruiterCount = 1;
    static HashMap<String, ArrayList<Job>> dataStore = new HashMap<String, ArrayList<Job>>();
    
    public void addRecruiter(String recruiterId)
    {
        dataStore.put(recruiterId, new ArrayList<Job>());
    }
    public void addJob(String recruiterId, Job job)
    {
        ArrayList<Job> temp = dataStore.get(recruiterId);
        temp.add(job);
    }
    
    public static HashMap<String, ArrayList<Job>> allJobs()
    {
        return dataStore;
    }
    
    public ArrayList<Job> getJobs(String recruiterId)
    {
        return dataStore.get(recruiterId);
    }
    
}
