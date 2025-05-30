public class Student
{
    String name;         //Name
    private int id;             //ex.16
    private String regno;       //ex. 23MCCE16
    private int[] marks;        //Marks for subject java, dsa, it.
    
    //Constructor to set instance variable according to menu driven
    public Student(String name, int id, String regno, int[] marks)
    {
        this.name = name;
        this.id = id;
        this.regno = regno;
        this.marks = new int[marks.length];
        
        //Copying the argument array
        for(int i=0;i<marks.length;i++)
        {
            this.marks[i] = marks[i];
        }
    }
    
    //Overriding the toString method to return a string representation of the Student.
    @Override
    public String toString()
    {
        String output = "----Student Report card----";
        output += "\nName : " + name + "\nId : " + id + "\nRegNo : " + regno;
        
        //Change this subjects String array to change/add/delete subjects.
        String[] subjects = {"Java", "Dsa", "It"};
        output += "\n--Grades--";
        
        //String array grades holds the corresponding grades to the subjects array.
        String[] grades = grades();
        
        for(int i=0;i<marks.length;i++)
        {
            output += "\n" + subjects[i] + " : " + grades[i];
        }
        
        return output;
    }
    
    //Overriding the equals method that reuturns true when the both two Objects are of Stuents class and all grades of then are same.
    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        
        Student other = (Student)obj;
        
        String[] s1Grades = this.grades();
        String[] s2Grades = other.grades();
        
        for(int i=0;i<marks.length;i++)
        {
            if(s1Grades[i] != s2Grades[i])
                return false;
        }
        
        return true;
    }
    
    
    //Wrong hashCode() Method
    @Override
    public int hashCode()
    {
        String[] grades = grades();
        int hashCode = 0;
        int power = 1;
        
        for(int i=0;i<grades.length;i++)
        {
            switch(grades[i])
            {
                case "A+": hashCode += power*1;
                           power *= 10;
                           break;
                           
                case "A": hashCode += power*2;
                           power *= 10;
                           break;
                           
                case "B+": hashCode += power*3;
                           power *= 10;
                           break;
                           
                case "B": hashCode += power*4;
                           power *= 10;
                           break;
                
                case "C": hashCode += power*5;
                           power *= 10;
                           break;
                           
                case "D": hashCode += power*6;
                           power *= 10;
                           break;
                
                case "F": hashCode += power*7;
                           power *= 10;
                           break;
            }
        }
        return hashCode;
    }
    
    /*@Override
    //Correct hashCode() Method
    public int hashCode()
    {
        String[] grades = grades();
        int hashCode = 0;
        int power = 1;
        int strToInt = 0;
        
        for(int i=0;i<grades.length;i++)
        {
            switch(grades[i])
            {
                case "A+": hashCode += power*1;
                           power *= 10;
                           break;
                           
                case "A": hashCode += power*2;
                           power *= 10;
                           break;
                           
                case "B+": hashCode += power*3;
                           power *= 10;
                           break;
                           
                case "B": hashCode += power*4;
                           power *= 10;
                           break;
                
                case "C": hashCode += power*5;
                           power *= 10;
                           break;
                           
                case "D": hashCode += power*6;
                           power *= 10;
                           break;
                
                case "F": hashCode += power*7;
                           power *= 10;
                           break;
            }
        }
        for(int i=0;i<regno.length();i++)
        {
            strToInt += ((int)regno.charAt(i));
            power *= power;
        }
        return (hashCode+strToInt);
    }*/
    
    //Helper method that returns String array of grades according the subjects in subject array.
    public String[] grades()
    {
        String[] grades = new String[marks.length];
        
        for(int i=0;i<marks.length;i++)
        {
            if( marks[i] > 84)
            {
                grades[i] = "A+";
            }
            else if( marks[i] > 74)
            {
                grades[i] = "A";
            }
            else if( marks[i] > 64)
            {
                grades[i] = "B+";
            }
            else if( marks[i] > 59)
            {
                grades[i] = "B";
            }
            else if( marks[i] > 49)
            {
                grades[i] = "C";
            }
            else if( marks[i] > 39)
            {
                grades[i] = "D";
            }
            else
            {
                grades[i] = "F";
            }
        }
        
        return grades;
    }
}
