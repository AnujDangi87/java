public class Triangle extends Shape
{
    //Instance variable to store vertices of triangle.
    private double[][] points;

    //Constructor to instialize points variable.
    public Triangle(double[][] points)
    {
        this.points = points;
    }

    //Method that returns area of the points.
    public double getArea()
    {
        double area = (((double)1/2)*(points[0][0]*(points[1][1] - points[2][1]) + points[1][0]*(points[2][1] - points[0][1]) + points[2][0]*(points[0][1] - points[1][1])));
        
        if(area < 0)
            return -1*area;
        return area;
    }

    //Method that returns perimeters of the points.
    public double getPerimeter()
    {
        double[] arr = length();

        return (arr[0]+arr[1]+arr[2]);
    }

    //Method that returns true when given points are right angle triangle.
    public boolean isRightAngleTriangle()
    {
        double[] arr = length();

        for(int i=0;i<3;i++)
        {
            if(Math.pow(arr[i%3], 2) == (Math.pow(arr[(i+1)%3], 2) + Math.pow(arr[(i+2)%3], 2)))
            {
                return true;
            }
        }
        return false;
    }

    //Helper mehtod that returns the array of lenght of each side of points.
    public double[] length()
    {
        double[] arr = new double[3];
        
        arr[0] = Math.sqrt(Math.pow((points[1][0]-points[0][0]), 2) + Math.pow(points[1][1]-points[0][1], 2));
        arr[1] = Math.sqrt(Math.pow((points[2][0]-points[1][0]), 2) + Math.pow(points[2][1]-points[1][1], 2));
        arr[2] = Math.sqrt(Math.pow((points[2][0]-points[0][0]), 2) + Math.pow(points[2][1]-points[0][1], 2));

        return arr;
    }

    //Method that returns true when given points is a isosceles Triangle.
    public boolean isIsoscelesTriangle()
    {
        double[] arr = length();

        for(int i=0;i<3;i++)
        {
            if( arr[i%3] == arr[(i+1)%3] && arr[(i+2)%3] != arr[(i+1)%3])
            {
                return true;
            }
        }
        return false;
    }

    //Method that returns true when given points is a equilateral triangle.
    public boolean isEquilateralTriangle()
    {
        double[] arr = length();

        if(arr[0] == arr[1] && arr[1] == arr[2])
        {
            return true;
        }
        return false;
    }
}
