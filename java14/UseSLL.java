public class UseSLL 
{
    public static void useSLL()
    {
        //Taking generic type as String
        SLL<String> strList = new SLL<String>();
        
        try{
            strList.insertAt("hello", 0);
            strList.insertAt("ANUJ", 1);
            strList.insertAt("Chandan", 2);
            strList.insertAt("asdjf", 5);
        }
        catch(PositionNotExist pne){
            System.out.println(pne);
        }
        strList.display();
        try{
            strList.delete("Chandan");
            strList.delete("asdjf");
        }
        catch(ValueNotFound vnf)
        {
            System.out.println(vnf);
        }
        
        strList.display();
        
        //Taking generic type as Integer
        SLL<Integer> strInt = new SLL<Integer>();
        
        try{
            strInt.insertAt(1, 0);
            strInt.insertAt(2, 1);
            strInt.insertAt(3, 2);
            strInt.insertAt(4, 4);
        }
        catch(PositionNotExist pne){
            System.out.println(pne);
        }
        strInt.display();
        try{
            strInt.delete(1);
            strInt.delete(4);
        }
        catch(ValueNotFound vnf)
        {
            System.out.println(vnf);
        }
        
        strInt.display();
    }

    public static void main(String[] args) {
        useSLL();
    }
}

