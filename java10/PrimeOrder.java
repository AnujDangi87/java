public class PrimeOrder implements MyComparable
{
    //Method returns 1 if first largest prime factor is greater then second, -1 its opposite
    public int compareTo(int first, int second)
    {
        int primeFirst = 1, primeSecond = 1;
        
        int copyFirst = first;
        int copySecond = second;
        
        for(int j=2;j<=first;j++)
        {
            for(int i=2;i<=copyFirst;i++)
            {
                if(copyFirst%i == 0)
                {
                    copyFirst /= i;
                    if(i >= primeFirst)
                        primeFirst = i;
                    break;
                }
            }
        }
        for(int j=2;j<=second;j++)
        {
            for(int i=2;i<=copySecond;i++)
            {
                if(copySecond%i == 0)
                {
                    copySecond /= i;
                    if(i >= primeSecond)
                        primeSecond = i;
                    break;
                }
            }
        }
        
        if(primeFirst == primeSecond)
        {
            return 0;
        }
        else
        {
            if(primeFirst > primeSecond)
                return 1;
            else
                return -1;
        }
        
    }
}
