public class Parallelogram extends Shape
{
    //Instance variables
    private double base;
    private double height;
    private double side1;
    private double side2;
    private double angle;       //In degrees

    //Constructor
    public Parallelogram(double side1, double side2, double angle)
    {
        this.base = side1;
        this.side1 = side1;
        this.side2 = side2;
        this.angle = angle;

        if(angle <= 90)
        {
            this.height = side2*Math.sin(Math.toRadians(angle));        //changing degree to radian for sin function.
        }
        else
        {
            this.height = side2*Math.sin(Math.toRadians(180-angle));
        }
    }

    //Method that returns area of the parallelogram
    public double getArea()
    {
        return base*height;
    }

    //Method that returns perimeter of the parallelogram
    public double getPerimeter()
    {
        return ((2*side1) + (2*side2));
    }

    //Method that returns true if given parallelogram forms a rectangle
    public boolean isRectangle()
    {
        if(angle == 90)
        {
            return true;
        }
        return false;
    }

    //Method that returns true if given parallelogram forms a square
    public boolean isSquare()
    {
        if(angle == 90 && side1 == side2)
        {
            return true;
        }
        return false;
    }
}
