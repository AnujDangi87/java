public class RightAngleTriangle extends Triangle
{
    //Using single argument to check pythagoras theorem and then initialize ver array.
    public RightAngleTriangle(int coordinates[][])
    {   
        if(pyTh(coordinates))
        {
            System.out.println("Given triangle is a right angel triangle");
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<2;j++)
                    this.ver[i][j] = coordinates[i][j];
            }
        }
        else
        {
            System.out.println("Not a right angle triangle, all vertices are set to '-1'");
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<2;j++)
                    this.ver[i][j] = -1;
            }
        }
    }

    //Method that returns true if given 2D array is of right angle triangle coordinates.
    public boolean pyTh(int coord[][])
    {
        double[] arr = length(coord);

        for(int i=0;i<3;i++)
        {
            if(arr[i] != 0 &&(Math.pow(arr[i%3], 2) == (Math.pow(arr[(i+1)%3], 2) + Math.pow(arr[(i+2)%3], 2))))
            {
                return true;
            }
        }
        return false;
    }

    //Method that returns arr of all length of vertices of triangle
    public double[] length(int coord[][])
    {
        double[] arr = new double[3];
        
        arr[0] = Math.sqrt(Math.pow((coord[1][0]-coord[0][0]), 2) + Math.pow(coord[1][1]-coord[0][1], 2));
        arr[1] = Math.sqrt(Math.pow((coord[2][0]-coord[1][0]), 2) + Math.pow(coord[2][1]-coord[1][1], 2));
        arr[2] = Math.sqrt(Math.pow((coord[2][0]-coord[0][0]), 2) + Math.pow(coord[2][1]-coord[0][1], 2));

        return arr;
    }
    
    //Method that overrides its parent area method and uses 1/2*base*height.
    public double area(int[][] coord)
    {
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

    //Permiter is same as in parent class.
}
