public class Triangle
{
    protected int ver[][];

    public Triangle()
    {
        this.ver = new int[3][2];
    }

    //Constructor that copyies coordinates in instance variable in ver.
    public Triangle(int coordinates[][])
    {
        this.ver = new int[3][2];

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<2;j++)
                this.ver[i][j] =coordinates[i][j];
        }

    }

    //Method that returns area of the trianle.
    public double area()
    {
        double area = (((double)1/2)*(ver[0][0]*(ver[1][1] - ver[2][1]) + ver[1][0]*(ver[2][1] - ver[0][1]) + ver[2][0]*(ver[0][1] - ver[1][1])));
        
        if(area < 0)
            return -1*area;
        return area;
    }

    //Method that returns the perimeter(sum of length of sides of triangle)
    public double perimeter()
    {
        double l1 = Math.sqrt(Math.pow((ver[1][0]-ver[0][0]), 2) + Math.pow(ver[1][1]-ver[0][1], 2));
        double l2 = Math.sqrt(Math.pow((ver[2][0]-ver[1][0]), 2) + Math.pow(ver[2][1]-ver[1][1], 2));
        double l3 = Math.sqrt(Math.pow((ver[2][0]-ver[0][0]), 2) + Math.pow(ver[2][1]-ver[0][1], 2));

        return (l1+l2+l3);
    }
}
