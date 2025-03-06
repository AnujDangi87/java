public class Circle extends Shape
{
    private double radius;
    private double centerX;
    private double centerY;

    public Circle(double radius, double centerX, double centerY)
    {
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public double getArea()
    {
        return Math.PI*radius*radius;
    }

    public double getPerimeter()
    {
        return 2*Math.PI*radius;
    }

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
