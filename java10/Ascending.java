public class Ascending implements MyComparable
{
    //Method that returns 0 when both arguments are equal, if first is greater then second returns -1 else returns 1
    public int compareTo(int first, int second)
    {
        if(first == second)
            return 0;
        else if(first < second)
            return 1;
        else 
            return -1;
    }
    
}
