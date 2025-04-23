import java.util.HashMap;
import java.util.ArrayList;

public class GradeBook
{
    HashMap<String, ArrayList<Double>> gradeBook;
    
    public GradeBook()
    {
        gradeBook = new HashMap<String, ArrayList<Double>>();
    }
    
    public void addGrade(String studentId, double grade)
    {
        if (gradeBook.containsKey(studentId))
        {
            ArrayList<Double> temp = gradeBook.get(studentId);
            temp.add(grade);
        }
        else
        {
            ArrayList<Double> a = new ArrayList<Double>();
            a.add(grade);
            gradeBook.put(studentId, a);
        }
    }
    
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
    
    public ArrayList<Double> getStudentGrades(String studentId)
    {
        return gradeBook.get(studentId);
    }
    
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