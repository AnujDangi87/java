public class Page {
    private String text;            //Instance String variable text to store text of the page.

    //Constructor to set the variable String text to the argument text.
    Page(String text)
    {
        this.text = text;
    }

    //Method that returns stroed String text.
    public String getText()
    {
        return text;
    }
    
    //Method that returns the no of occcurrences of String keyword in text.
    public int countKeywordOccurrences(String keyword)
    {
        int count = 0;

        String []str = text.trim().split(" ");          //First removing starting and trailing spaces using trim() function and then using split() to create a String array for each word.

        for(int i=0;i<str.length;i++)           //Checking if keyword matches with String word in text and then increasing count by 1.
        {
            if(str[i].equalsIgnoreCase(keyword))
            {
                count++;
            }
        }

        return count;
    }
}
