public class Event
{
    //Instance variable for event
    private String title;
    private String date;
    private String about;
    
    //Constructor that set instance variable
    public Event(String title, String date, String about)
    {
        this.title = title;
        this.date = date;
        this.about = about;
    }
    
    //toString method that prints content of event
    @Override
    public String toString()
    {
        return "Title : "+title+"\n   Date : "+date+"\n   About : "+  about;
    }
}
