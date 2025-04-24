public class Task
{
    //Instance variable
    private String id;
    private String description;
    private int priority;//1-high, 2-medium, 3-low
    
    //Constructor
    public Task(String id, String description, int priority)
    {
        this.id = id;
        this.description = description;
        this.priority = priority;
    }
    
    //Getter for id
    public String getId()
    {
        return this.id;
    }
    
    //Getter for description
    public String getDescription()
    {
        return this.description;
    }
    
    //Getter for priority
    public int getPriority()
    {
        return this.priority;
    }
    
    //Setter for id
    public void setId(String id)
    {
        this.id = id;
    }
    
    //Setter for description
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    //Setter for priority
    public void setPriority(int priority)
    {
        this.priority = priority;
    }
    
    //Method for Comparator class
    public int compareTo(Task other)
    {
        if (other.priority < this.priority)
            return 1;
        else if(other.priority > this.priority)
            return -1;
        return 0;
    }
    
    //toString Method that returns Sting of details of Task object
    @Override
    public String toString()
    {
        return "Id : " + id + ", Description : " + description + ", Priority : " + priority;
    }
}