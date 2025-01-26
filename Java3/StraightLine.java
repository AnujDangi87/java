
/**
 * Write a description of class StraightLine here.
 *
 * @author (23MCCE16)
 * @version (26-01-25)
 */
class StraightLine{
    double a;           //Creating double variable to hold a, b and c of line equation.
    double b;
    double c;
    
    StraightLine(double a, double b, double c)              //Constructor with three argument as a, b and c to assign value to this.a, this.b and this.c.
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    boolean isParallelWith(StraightLine line1)              //Method to check if line is parallel with given object line1.
    {
        double slope1 = -1*(this.a/this.b);                 //For parallel slope of line1 and slope of line 2 should be equal.
        double slope2 = -1*(line1.a/line1.b);
        
        if (slope1 == slope2)
        {
            return true;
        }
        else
            return false;
    }
    
    boolean isPerpendicularWith(StraightLine line1)             //Method to check if line is perpendicular with given object line1.
    {
        double slope1 = -1*(this.a/this.b);                 //For perpendicular m1*m2 = -1
        double slope2 = -1*(line1.a/line1.b);   
        
        if (slope1*slope2 == -1)
        {
            return true;
        }
        else
            return false;
    }
    
    boolean isPointOnLine(double x1, double y1)             //Method to check if there exists point x1 and y1 on the line.
    {
        double slope = -1*(this.a/this.b);
        if ( y1 == ((slope*x1) - (this.c/this.b)))
            return true;
        else
            return false;
    }
    
    void display()              //Method to display the outputs.
    {
        if (this.b < 0 && this.c < 0)
            System.out.println("Line equation : " + this.a+"x "+""+this.b+"y " + this.c);
        else if(this.b == 0 && this.c == 0)
            System.out.println("Line equation : " + this.a+"x");
        else if(this.b ==0)
            System.out.println("Line equation : " + this.a+"x "+this.c);
        else if(this.c == 0)
            System.out.println("Line equation : " + this.a+"x "+""+this.b+"y");
        else if (this.b > 0 && this.c > 0)
            System.out.println("Line equation : " + this.a+"x +"+" "+this.b+"y +"+" "+this.c);
    }
    
}