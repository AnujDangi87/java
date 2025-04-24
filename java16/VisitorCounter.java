import java.util.HashSet;

public class VisitorCounter
{
    //Instance variable
    HashSet<Visitor> visitors;
    
    //Constructor
    public VisitorCounter()
    {
        visitors = new HashSet<Visitor>();
    }
    
    //Adding visitor if not there
    public void addVisitor(Visitor visitor)
    {
        if(visitor == null)
            return;
        else
        {
            visitors.add(visitor);
        }
    }
    
    //returns count of objects in visitors in HashSet
    public int countUniqueVisitors()
    {
        return visitors.size();
    }
    
    //Displays visitors in HashSet
    public void displayUniqueVisitors()
    {
        System.out.println(visitors);
    }
}