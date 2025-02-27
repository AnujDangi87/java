public class RightAngleTriangle extends Triangle
{
    int coor[][];

    public boolean pyTh(int coord[][])
    {
        double[] arr = length(coord);

        for(int i=0;i<3;i++)
        {
            if(Math.pow(arr[i%3], 2) == (Math.pow(arr[(i+1)%3], 2) + Math.pow(arr[(i+2)%3], 2)))
            {
                return true;
            }
        }
        return false;
    }

    public double[] length(int coord[][])
    {
        double[] arr = new double[3];
        
        arr[0] = Math.sqrt(Math.pow((coord[1][0]-coord[0][0]), 2) + Math.pow(coord[1][1]-coord[0][1], 2));
        arr[1] = Math.sqrt(Math.pow((coord[2][0]-coord[1][0]), 2) + Math.pow(coord[2][1]-coord[1][1], 2));
        arr[2] = Math.sqrt(Math.pow((coord[2][0]-coord[0][0]), 2) + Math.pow(coord[2][1]-coord[0][1], 2));

        return arr;
    }
    public RightAngleTriangle(int coord[][])
    {
        super(coord);
        
        if(pyTh(coord))
        {
            this.coor = coord;
        }
        else
        {
            this.coor = new int[][]{{-1,-1},{-1, -1},{-1,-1}};
        }

        System.out.println(area(coord));
        System.out.println(super.perimeter());
    }

    public double area(int[][] coord)
    {

        if(!pyTh(coord))
        {
            return super.area();
        }
        double arr[] = length(coord);

        int index;

        if(arr[0] > arr[1])
        {
            index = 0;
        }
        else
        {
            index = 1;
        }

        if( arr[index] < arr[2])
        {
            index = 2;
        }

        return (((double)1/2)*arr[(index+1)%3]*arr[(index+2)%3]);

    }
}
