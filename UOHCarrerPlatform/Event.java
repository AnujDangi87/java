public class Event
{
    private String title;
    private String date;
    private String about;
    
    public Event(String title, String date, String about)
    {
        this.title = title;
        this.date = date;
        this.about = about;
    }
    
    @Override
    public String toString()
    {
        return "Title : "+title+"\n   Date : "+date+"\n   About : "+  about;
    }
}
