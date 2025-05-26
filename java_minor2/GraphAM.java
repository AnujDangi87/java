import java.io.*;

public class GraphAM
{
    int[][] matrix;
    
    public GraphAM(int noV)
    {
        matrix = new int[noV][noV];
    }
    
    public GraphAM(int[][] aM)
    {
        matrix = new int[aM.length][aM.length];
        
        for(int i=0;i<aM.length;i++)
        {
            for(int j=0;j<aM.length;j++)
            {
                if(aM[i][j] == 0 || aM[i][j] == 1)
                    matrix[i][j] = aM[i][j];
                else
                {
                    matrix = null;
                    return;
                }
            }
        }
    }
    
    public GraphAM(String filename)
    {
        try(BufferedReader bf = new BufferedReader(new FileReader(filename)))
        {
            String s = bf.readLine();
            String[] sArr = s.split("[\s\n]");
            int v = Integer.parseInt(sArr[0]);
            s = bf.readLine();
            sArr = s.split("[\s\n]");
            int e = Integer.parseInt(sArr[0]);    
            matrix = new int[v][v];
            
            for(int i=0;i<e;i++)
            {
                String str = bf.readLine();
                String[] strArr = str.trim().split("[\s\n]");
                int a = Integer.parseInt(strArr[0]);
                int b = Integer.parseInt(strArr[1]);
                
                matrix[a][b] = 1;
                matrix[b][a] = 1;
            }
        }
        catch(IOException ioe)
        {
            System.out.println(ioe);
        }
    }
    
    public boolean isNullGraph()
    {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                if(matrix[i][j] == 1)
                    return false;
            }
        }
        return true;
    }
    
    public int getDegree(int v)
    {
        int degree = 0;
        
        for(int j=0;j<matrix.length;j++)
        {
            if(matrix[v][j] == 1)
            {
                degree++;
            }
        }
        
        return degree;
    }
    
    public GraphAM unionWith(GraphAM other)
    {
        GraphAM output = new GraphAM(matrix);
        
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                if( other.matrix[i][j] == 1)
                    output.matrix[i][j] = 1;
            }
        }
        
        return output;
    }
    
    public void display()
    {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                System.out.print(matrix[i][j] + " " );
            }
            System.out.println();
        }
        
    }
}