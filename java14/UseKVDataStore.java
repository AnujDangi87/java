import java.lang.*;

public class UseKVDataStore
{
    public static void getFreqCount(String str)
    {
        str = str.trim();
        char[] charArray = str.toCharArray();
        
        Character[] keyArray =new Character[26];
        Integer[] valueArray = new Integer[26];
        
        KVDataStore<Character, Integer> kv = new KVDataStore<Character, Integer>(keyArray, valueArray);
        /*for all 26 char.
        for(int i=0;i<26;i++)
        {
            Character ch = (char) (97+i);
            
            kv.put(ch, 0);
        }*/
        
        for(int i=0;i<charArray.length;i++)
        {
            int count = 0;
            try{
                count = kv.get(charArray[i]);
                kv.put(charArray[i], ++count);
            }
            catch(EmptyDataStore eds){
                kv.put(charArray[i], 0);
            }
            catch(KeyNotFound knf){
                kv.put(charArray[i], 0);
            }
        }
        
        kv.displayTable();
    }
    
    public static void useKVDataStore()
    {
        String[] strKey = new String[10];
        String[] strVal = new String[10];
        KVDataStore<String, String> kvStr = new KVDataStore<String, String>(strKey, strVal);
        
        kvStr.put("23MCCE16", "Anuj Dangi");
        kvStr.put("23MCCE15", "Chandan");
        
        try
        {
            System.out.println(kvStr.get("23MCCE16"));
            System.out.println(kvStr.get("23MCCE08"));
        }
        catch(EmptyDataStore eds){
            System.out.println(eds);
        }
        catch(KeyNotFound knf){
            System.out.println(knf);
        }
        finally
        {
            kvStr.displayTable();
        }
        getFreqCount("Hello, How are You.Generic classes");
        
    }
    
    public static void main(String[] args)
    {
        useKVDataStore();
    }
}
