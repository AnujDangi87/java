import java.util.Scanner;

public class SquareCube{

    static void generateSquareCubeTable(int n)
    {
        int square = n*n, cube = n*n*n;
        System.out.println("Square : "+square+", Cube : "+cube);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n : ");
        int n = sc.nextInt();
        sc.close();

        if ( n <= 0)
        {
            System.out.println("Error, value of n is less than or equal to 0. Exiting the program...");
        }
        else
        {
            for (int i=1; i<=n;i++)
            {
                generateSquareCubeTable(i);
            }
        }
    }
}
