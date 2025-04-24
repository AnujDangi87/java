public class Visitor
{
    //Instance variables 
    private String name;
    private String ipAddress;
    
    //Constructor
    public Visitor(String name, String ipAddress)
    {
        this.name = name;
        this.ipAddress = ipAddress;
    }
    
    //Getter for name
    public String getName()
    {
        return name;
    }
    
    //Getter for ipAddress
    public String getIpAddress()
    {
        return ipAddress;
    }
    
    //Setter for name
    public void setName(String name)
    {
        this.name = name;
    }
    
    //Setter for ipAddress
    public void setIpAddress(String ipAddress)
    {
        this.ipAddress = ipAddress;
    }
    
    //Equals method reutrn true if ipaddress is same as current object
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
    
    //HashCode method that returns same hashcode for same ipaddress objects
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
    
    //toString method that defines a visitor
    @Override
    public String toString()
    {
        return "(Name : " + this.name + ", IpAddress : " + this.ipAddress + ")";
    }
}

