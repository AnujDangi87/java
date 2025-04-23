import java.util.HashSet;
import java.util.Iterator;

public class VisitorCounter
{
    HashSet<Visitor> visitors;
    
    public VisitorCounter()
    {
        visitors = new HashSet<Visitor>();
    }
    
    public void addVisitor(Visitor visitor)
    {
        if(visitor == null)
            return;
        else
        {
            visitors.add(visitor);
        }
    }
    
    public int countUniqueVisitors()
    {
        return visitors.size();
    }
    
    public void displayUniqueVisitors()
    {
        System.out.println(visitors);
    }
}