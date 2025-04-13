import java.util.ArrayList;
import java.util.HashMap;

public class StudentAlumniDataStore
{
    HashMap<String, Resume> dataStore = new HashMap<String, Resume>();
    
    public StudentAlumniDataStore()
    {
        
    }
    
    
    public void addResume(Resume resume)
    {
        dataStore.put(resume.getId(), resume);
    }
    
    public Resume getResume(String id)
    {
        return dataStore.get(id);
    }
}
