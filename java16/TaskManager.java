import java.util.PriorityQueue;
import java.util.Iterator;
import java.util.Comparator;

public class TaskManager
{
    //Instance variable
    PriorityQueue<Task> pq;
    
    //Constructor
    public TaskManager()
    {
        //PriorityQueue that takes Comparator objet as argument to compare priority of queue
        pq = new PriorityQueue<Task>(new Comparator<Task>(){
            @Override
            public int compare(Task f, Task s)
            {
                return f.compareTo(s);
            }
        });
    }
    
    //to add task
    public void addTask(Task task)
    {
        if (task == null)
        {
            System.out.println("Error, given task is null!!");
            return;
        }
        else
        {
            pq.add(task);
        }
    }
    
    //To return highest priority task
    public Task getHighestPriorityTask()
    {
        if( pq.size() == 0)
            return null;
        else
        {
            return pq.poll();
        }
    }
    
    //To displays all tasks
    public void viewTasks()
    {
        if(pq.size() == 0)
        {
            System.out.println("Error, There are no Tasks!!");
            return;
        }
        
        //Using iterator class in collection framework
        Iterator it = pq.iterator();
        
        System.out.println("----Tasks----");
        int i=1;
        while(it.hasNext())
        {
            System.out.println((i++) + ". " + it.next());
        }
    }
}