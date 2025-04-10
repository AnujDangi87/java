public class KVDataStore<T, V>
{
    private T[] keyArray;           //Instance variables T array to store keys, V array to store value, length to total length of arrays, top to store the last inserted index.
    private V[] valueArray;
    private int length;
    private int top;
    
    //Two argument constructor
    public KVDataStore(T[] kArray, V[] vArray) throws IllegalArgumentException
    {
        if(kArray.length != vArray.length)      //first checks that if array length is equal of both kArray and vArray if not throw an exception.
        {
            throw new IllegalArgumentException();
        }
        else
        {       //Initializing the instance variables.
            keyArray = kArray;
            valueArray = vArray;
            this.length = keyArray.length;
            this.top = -1;
        }
    }
    
    //Method that add key and its value.
    public void put(T a, V b)
    {
        boolean found = false;
        //if key is already existing then update its value field.
        for(int i=0;i<=top;i++)
        {
            if( keyArray[i].equals(a) )
            {
                valueArray[i] = b;
                found = true;
            }
        }
        
        //If not add new key and value field at top+1 index.
        if(found == false)
        {
            keyArray[top + 1] = a;
            valueArray[top + 1] = b;
            top++;
        }
    }
    
    //Method that returns the value field using its key field.
    public V get(T a) throws EmptyDataStore, KeyNotFound
    {
        if( top == -1 )         //If array is empty throw an exception
        {
            throw new EmptyDataStore();
        }
        
        //Search for its key field and if found return its value field.
        for(int i=0;i<=top;i++)
        {
            if( keyArray[i].equals(a) )
            {
                return valueArray[i];
            }
        }
        
        throw new KeyNotFound();
    }
    
    //Method that display the key : value fields.
    public void displayTable()
    {
        for(int i=0;i<=top;i++)
        {
            System.out.println(keyArray[i] + " : " + valueArray[i]);
        }
    }
}
