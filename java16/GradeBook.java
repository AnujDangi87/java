import java.util.HashMap;
import java.util.ArrayList;

public class GradeBook
{
    //Instance HashMap variable that store student as its key and ArrayList grades as its grades
    HashMap<String, ArrayList<Double>> gradeBook;
    
    //Constructor that allocates memory to gradeBook variable
    public GradeBook()
    {
        gradeBook = new HashMap<String, ArrayList<Double>>();
    }
    
    //Method that add grade to a student grade ArrayList
    public void addGrade(String studentId, double grade)
    {
        //add directly if id is present
        if (gradeBook.containsKey(studentId))
        {
            ArrayList<Double> temp = gradeBook.get(studentId);
            temp.add(grade);
        }
        else        //Create a key and the  add grades
        {
            ArrayList<Double> a = new ArrayList<Double>();
            a.add(grade);
            gradeBook.put(studentId, a);
        }
    }
    
    //Method that calculate after retreiving the ArrayList grades
    public double calculateAverageGrade(String studentId)
    {
        if( !gradeBook.containsKey(studentId))
        {
            return -1;
        }
        else
        {
            ArrayList<Double> temp = gradeBook.get(studentId);
            double average = 0;
            
            for(int i=0;i<temp.size();i++)
            {
                average += temp.get(i);
            }
            
            return average/temp.size();
        }
    }
    
    //Methods that returns ArrayList of Grades
    public ArrayList<Double> getStudentGrades(String studentId)
    {
        return gradeBook.get(studentId);
    }
    
    //Method that prints all student in hashMap with its grades
    public void displayAllStudentGrades()
    {
        if ( gradeBook.size() == 0)
        {
            System.out.println("Error, No Student in GradeStore");
            return;
        }
        
        System.out.println("----Student GradeBook----");
        gradeBook.forEach( (k ,v) -> {
            System.out.println("-> StudentId : " + k + ", Grades : " + v);
        } );
    }
}