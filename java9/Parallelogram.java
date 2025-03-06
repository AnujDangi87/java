public class Parallelogram extends Shape
{
    private double base;
    private double height;
    private double side1;
    private double side2;
    private double angle;

    public Parallelogram(double side1, double side2, double angle)
    {
        this.base = side1;
        this.side1 = side1;
        this.side2 = side2;
        this.angle = angle;

        if(angle <= 90)
        {
            this.height = side2*Math.sin(angle);
        }
        else
        {
            this.height = side2*Math.sin(180-angle);
        }
    }

    public double getArea()
    {
        return base*height;
    }

    public double getPerimeter()
    {
        return ((2*side1) + (2*side2));
    }

    public boolean isRectangle()
    {
        if(angle == 90)
        {
            return true;
        }
        return false;
    }

    public boolean isSquare()
    {
        if(angle == 90 && side1 == side2)
        {
            return true;
        }
        return false;
    }
}
