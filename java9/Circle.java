public class Circle extends Shape
{
    private double radius;          //Instance variable radius that stores the radius of the circle
    private double centerX;         //Instance variable centerX that stores the center x cordinates of the circle
    private double centerY;         //Instance variable centerY that stores the center y cordinates of the circle

    //Constructor that initialize radius, centerX, centerY
    public Circle(double radius, double centerX, double centerY)
    {
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    //Method that returns area of the circle.
    public double getArea()
    {
        return Math.PI*radius*radius;
    }

    //Method that returns perimeter of circle
    public double getPerimeter()
    {
        return 2*Math.PI*radius;
    }

    //Method that returns true if given argument point are inside the circle.
    public boolean isPointInside(double x, double y)
    {
        if(Math.pow((centerX-x), 2) + Math.pow((centerY-y), 2) < Math.pow(radius, 2))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
