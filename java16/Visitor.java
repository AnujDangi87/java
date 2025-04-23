public class Visitor
{
    private String name;
    private String ipAddress;
    
    public Visitor(String name, String ipAddress)
    {
        this.name = name;
        this.ipAddress = ipAddress;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getIpAddress()
    {
        return ipAddress;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj == this)
        {
            return true;
        }
        
        if(obj == null || this.getClass() != obj.getClass())
        {
            return false;
        }
        
        Visitor other = (Visitor)obj;
        
        return this.ipAddress.equals(other.ipAddress);
    }
    
    @Override
    public int hashCode()
    {
        int code = 0, power = 1;
        for(int i=0;i<ipAddress.length();i++)
        {
            if( ipAddress.charAt(i) >= 48 && ipAddress.charAt(i) < 58)
            {
                code += (int)ipAddress.charAt(i)*power;
                power *= 10;
            }
            if(ipAddress.charAt(i) == '.')
                code *= 10;
        }
        return code;
        
        /*Another way(better way)
           return ipAddress.hashCode();*/
    }
    
    @Override
    public String toString()
    {
        return "(Name : " + this.name + ", IpAddress : " + this.ipAddress + ")";
    }
}

