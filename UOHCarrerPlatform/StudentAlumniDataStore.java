import java.util.ArrayList;
import java.util.HashMap;

//Class that holds the Student/Alumni Data
public class StudentAlumniDataStore
{
    //Instance variable that stores Student/Alumni id as key and its resume as value;
    private HashMap<String, Resume> dataStore;
    
    //Constructor that create a object of dataStore;
    public StudentAlumniDataStore()
    {
        dataStore = new HashMap<String, Resume>();
    }
    
    //Method that adds resume in dataStore
    public void addResume(Resume resume)
    {
        dataStore.put(resume.getId(), resume);
    }
    
    //Method that return resume of given userId
    public Resume getResume(String id)
    {
        return dataStore.get(id);
    }
}
