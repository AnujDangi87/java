import java.util.Scanner;

public class MatrixTranspose {

    static void matixTranspose(int [][]matrix, int rows, int col){
        int temp;
        for (int i=0;i<rows;i++)
        {
            for(int j=0;j<col;j++)
            {
                if (i<j && i!=j)                //Replacing row elements with its colomn elments.
                {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the no of rows : ");
        int rows = sc.nextInt();
        System.out.print("Enter the no of columns : ");
        int col = sc.nextInt();

        int[][] matrix = new int[rows][col];
        System.out.println("Enter the elements of array row wise : ");
        for (int i=0;i<rows;i++)
        {
            for (int j=0;j<col;j++)
            {
                matrix[i][j] = sc.nextInt();                    //Taking two dimensional array as input.
            }
        }
        sc.close();
        matixTranspose(matrix, rows, col);
        System.out.println("Transpose of given matrix : ");
        for (int i=0;i<rows;i++)
        {
            for (int j=0;j<col;j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
