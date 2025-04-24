import java.util.Scanner;
import java.util.ArrayList;

public class UseGradeBook
{
    //Main menu method 
    public static void mainMenu()
    {
        System.out.println("1. Add grades to a Student");
        System.out.println("2. Calculate average grades of a Student");
        System.out.println("3. Retrieve a Student Grades");
        System.out.println("4. Display all student grades");
        System.out.println("5. Exit the program....");
        System.out.print("Enter your choice : ");
    }
    
    //Method that check useability of GradeBook class
    public static void useGradeBook()
    {
        int choice = 0;
        
        Scanner sc = new Scanner(System.in);
        GradeBook gb = new GradeBook();
        String id;
        
        mainMenu();
        
        while(choice != 5)
        {
            try                         //Input validation
            {
                choice = sc.nextInt();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            sc.nextLine();
            
            switch (choice)
            {
                case 1: System.out.print("\nEnter id of the Student : ");
                        id = sc.nextLine();
                        System.out.print("Enter grade : ");
                        gb.addGrade(id, sc.nextDouble());
                        break;

                case 2: System.out.print("\nEnter id of the Student : ");
                        id = sc.nextLine();
                        double average = gb.calculateAverageGrade(id);
                        if(average == -1)
                        {
                            System.out.println("Error, No grades!!");
                        }
                        else
                        {
                            System.out.println("Average garade of " + id +  " : " + average);
                        }
                        break;

                case 3: System.out.print("\nEnter id of the Student : ");
                        id = sc.nextLine();
                        ArrayList<Double> temp = gb.getStudentGrades(id);
                        
                        if(temp == null)
                        {
                            System.out.println("Error, No grades!!");
                        }
                        else
                            System.out.println("StudentId : " + id + ", Grades : " + temp); 
                        break;

                case 4: gb.displayAllStudentGrades();
                        break;
                
                case 5: System.out.println("Exiting the program....");
                        break;

                default: System.out.println("Error, wrong input. Try again");
                        break;
            }
            
            if(choice != 5)
            {
                System.out.println();
                mainMenu();
            }

        }
        
        sc.close();
    }
    
    public static void main(String[] args)
    {
        useGradeBook();
    }
}