public class Triangle
{
    protected int ver[][];

    public Triangle(int coordinates[][])
    {
        ver = coordinates;
    }

    public double area()
    {
        return (((double)1/2)*(ver[0][0]*(ver[1][1] - ver[2][1]) + ver[1][0]*(ver[2][1] - ver[0][1]) + ver[2][0]*(ver[0][1] - ver[1][1])));
    }

    public double perimeter()
    {
        double l1 = Math.sqrt(Math.pow((ver[1][0]-ver[0][0]), 2) + Math.pow(ver[1][1]-ver[0][1], 2));
        double l2 = Math.sqrt(Math.pow((ver[2][0]-ver[1][0]), 2) + Math.pow(ver[2][1]-ver[1][1], 2));
        double l3 = Math.sqrt(Math.pow((ver[2][0]-ver[0][0]), 2) + Math.pow(ver[2][1]-ver[0][1], 2));

        return (l1+l2+l3);
    }
}
