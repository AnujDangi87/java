public class Job
{
    int id;
    String title;
    int positionAvailable;
    String requirments;
    String about;
    String aboutRecruiters;

    public Job(int id, String title, int positionAvailable, String requirments, String about, String aboutRecruiters)
    {
        this.id = id;
        this.title = title;
        this.positionAvailable = positionAvailable;
        this.requirments = requirments;
        this.about = about;
        this.aboutRecruiters = aboutRecruiters;
    }

    @Override
    public String toString()
    {
        String output = "";

        output += "Job Id : " + id + "\nJob title : " + title + "\nAvailable Positions : " + positionAvailable + "\nJob Requirments : " + requirments + "\nAbout Job : " + about + "\nAbout recruiter : " + aboutRecruiters;

        return output;
    }
}