
/**
 * Write a description of class FiniteSeries here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FiniteSeries implements Series
{
    //Instance variables
    private int[] arr;
    private int ind;
    private int start;
    
    //Constructor
    public FiniteSeries(int[] arr) 
    {
        this.arr = new int[arr.length];
        
        for(int i=0;i<arr.length;i++)
        {
            this.arr[i] = arr[i];
        }
        
        this.ind = this.start = 0;
    }
    
    //Overriding implemented interface abstract method
    public int getNext()
    {
        if( arr.length <= ind)
        {
            this.ind = this.start;
        }
        
        return this.arr[ind++];
    }
    
    //Overriding implemented interface abstract method
    public void reset()
    {
        this.start = this.ind = 0;
    }
    
    //Overriding implemented interface abstract method
    public void setStart(int i)
    {
        this.start = i;
        this.ind = i;
    }
}
