
/**
 * Write a description of class Greetings here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Greetings         
{
    String name;            //Storing name as String.
    LocalDate dob;          //LocalDate class varible.

    Greetings(String name, String dob)              //Using constructor and two argument to assign values to name and dob.
    {
        this.name = name;
        this.dob = LocalDate.parse(dob);            //Using LocalDate.parse(String) because dob is String  and this.dob is LocalDate.
    }
    
    void greetPerson()          //Method to greet to user acording to the local machine time.
    {
        LocalTime currTime = LocalTime.now();       //Creating currTime object from LocalTime and assigning LocalTime.now() the local time of machine.
        DateTimeFormatter forObj = DateTimeFormatter.ofPattern("HH");       //Creating forObj object from DateTimeFormatter class to format time to only hour.
        String formatedTime = currTime.format(forObj);          //Converting currTime to HH.

        int hour = Integer.parseInt(formatedTime);              //As formated output is in String using Integer.parseInt(String) to convert it to int.

        if (hour<12 && hour>=5)             //Comparing hour values to show greetings.
        {
            System.out.println("Good Morning, "+name);
        }
        else if(hour>=12 && hour<16)
        {
            System.out.println("Good Afternoon, "+name);
        }
        else if (hour>=16 && hour<19)
        {
            System.out.println("Good Evening, "+name);
        }
        else
            System.out.println("Good Night, "+name);
    }

    void birthdayGreeting()         //Method to Greet Birthday to user.
    {
        LocalDate date = LocalDate.now();           //Storing Local machine date in date.
        DateTimeFormatter forObj = DateTimeFormatter.ofPattern("MMdd");
        String forDate = date.format(forObj);           //Formatting date to only monthDate.

        int updDob = Integer.parseInt(dob.format(forObj));          //Formatting date to MMdd.

        int updDate = Integer.parseInt(forDate);            //Parsing string to int.


        if (updDate>=101 && updDate<updDob)             //Comparing Dob to CurrentDate to show greetings.
        {
            System.out.println("Advance Happy Birthday, "+name+"!");
        }
        else if(updDate>updDob && updDate<=1231)
        {
            System.out.println("Belated Happy Birthday, "+name+"!");
        }
        else if(updDate == updDob){
            System.out.println("Happy Birthday, "+name+"!");
        }
    }

    void calculateAge()             //Method to Calculate Age from Dob and current Date.
    {
        LocalDate date = LocalDate.now();           //Creating date as local machine Date.
        DateTimeFormatter forObj = DateTimeFormatter.ofPattern("MM");           //Formatting  date to month only.

        int dobM = Integer.parseInt(dob.format(forObj));            //dobM to store the The month of user birth.
        int curM = Integer.parseInt(date.format(forObj));           //curM to store the current month of the year.

        int curAgeY = date.compareTo(dob);          //To store the Current Age Year of the user.
        int curAgeM = 0;                            //To store the Current Age Month of the user.
        if(curM < dobM)
        {
            curAgeY--;
            curAgeM = 12 - (dobM - curM);
        }
        else if(curM >= dobM)
        {
            curAgeM = curM - dobM;
        }

        System.out.println("You are "+curAgeY+" years "+curAgeM+" months old.");

    }
}