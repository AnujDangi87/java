public class Page {
    private String text;

    Page(String text)
    {
        this.text = text;
    }

    public String getText()
    {
        return text;
    }

    public int countKeywordOccurrences(String keyword)
    {
        int count = 0;

        String []str = text.trim().split(" ");

        for(int i=0;i<str.length;i++)
        {
            if(str[i].equalsIgnoreCase(keyword))
            {
                count++;
            }
        }

        return count;
    }
}
