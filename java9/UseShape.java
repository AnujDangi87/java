import java.util.Scanner;

public class UseShape
{
    static void mainMenu()
    {
        System.out.println("\n1.Triangle");
        System.out.println("2.Circle");
        System.out.println("3.Parallelogram");
        System.out.println("4.Exit the program....");
        System.out.print("Enter your choice : ");
    }

    //Method that takes Shape object as argument (it uses principle of substition - polymorphism)
    static void areaPerimeter(Shape s)
    {
        System.out.println("Area : "+s.getArea() + "\nPerimeter : "+s.getPerimeter());
        return;
    }

    //Static Method for checking the useability of Shape and its inherited  classes.
    static void useShape()
    {
        int choice = 0;

        Scanner sc = new Scanner(System.in);
        mainMenu();

        while(choice != 4)
        {
            try
            {
                choice = sc.nextInt();
                sc.nextLine();
            }
            catch(Exception e)
            {
                System.out.println("Error : " + e + ". Wrong input, try again");            //Error handling (input validation)
                sc.next();
            }

            switch (choice)
            {
                case 1: useTriangle(sc);
                        break;

                case 2: useCircle(sc);
                        break;

                case 3: useParallelogram(sc);
                        break;

                case 4: System.out.println("Exiting the program....");
                        break;

                default: System.out.println("Error, wrong input. Try again");
                        break;
            }
            if(choice != 4)
            {
                mainMenu();
            }
        }
        sc.close();
    }

    //Input mehthod for traingle that take input for traiangle class
    static double[][] inputTriangle(Scanner sc)
    {
        System.out.print("Enter initial coordinates(x1 y1 x2 y2 x3 y3(space between them)) : ");
        double[][] arr = new double[3][2];


        try
        {
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<2;j++)
                {
                    arr[i][j] = sc.nextDouble();
                }
                
            }
        }
        catch(Exception e)
        {
            System.out.println("Error : " + e + ".\nWrong input,only integers is allowed. Enter any key to try again");            //Error handling (input validation)
            sc.next();
        }
        return arr;
    }
    static void triangleMenu()
    {
        System.out.println("\n1.Display area and perimeter");
        System.out.println("2.Is triangle Right Angle Triangle");
        System.out.println("3.Is triangle Isosceles Triangle");
        System.out.println("4.Is triangle Equilateral Triangle");
        System.out.println("5.Enter coordinates again");
        System.out.println("6.Go back to main menu");
        System.out.print("Enter your choice : ");
    }

    static void useTriangle(Scanner sc)
    {
        int choice = 0;

        Triangle tra = new Triangle(inputTriangle(sc));
        triangleMenu();

        while(choice != 6)
        {
            try
            {
                choice = sc.nextInt();
                sc.nextLine();
            }
            catch(Exception e)
            {
                System.out.println("Error : " + e + ". Wrong input, try again");            //Error handling (input validation)
                sc.next();
            }
            
            switch (choice)
            {
                case 1: areaPerimeter(tra);
                        break;
                
                case 2: System.out.println(tra.isRightAngleTriangle());
                        break;
                    
                case 3: System.out.println(tra.isIsoscelesTriangle());
                        break;
                
                case 4: System.out.println(tra.isEquilateralTriangle());
                        break;

                case 5: tra = new Triangle(inputTriangle(sc));
                        triangleMenu();          
                        break;

                case 6: System.out.println("\n----Main menu----");
                        break;

                default: System.out.println("Error, wrong input. Try again");
                        break;
            }

            if(choice != 6 && choice != 5)
            {
                System.out.print("\nEnter your choice : ");
            }
        }
    }

    static void circleMenu()
    {
        System.out.println("\n1.Display area and perimeter");
        System.out.println("2.Is point inside the circle");
        System.out.println("3.Enter radius and center coordinates again");
        System.out.println("4.Go back to main menu");
        System.out.print("Enter your choice : ");
    }
    //Input mehthod for circle that take input for circle class
    static Circle inputCircle(Scanner sc)
    {
        System.out.print("Enter radius of Circle : ");
        double radius =  sc.nextDouble();
        System.out.print("Enter Center X : ");
        double x = sc.nextDouble();
        System.out.print("Enter Center Y : ");
        Circle c = new Circle(radius, x, sc.nextDouble());

        return c;
    }

    static void useCircle(Scanner sc)
    {
        int choice = 0;

        Circle circle = inputCircle(sc);
        circleMenu();

        while(choice != 4)
        {
            try
            {
                choice = sc.nextInt();
                sc.nextLine();
            }
            catch(Exception e)
            {
                System.out.println("Error : " + e + ". Wrong input, try again");            //Error handling (input validation)
                sc.next();
            }
            
            switch (choice)
            {
                case 1: areaPerimeter(circle);
                        break;

                case 2: System.out.print("Enter x coordinate of point : ");
                        double x = sc.nextDouble();
                        System.out.print("Enter y coordinate of point : ");
                        if(circle.isPointInside(x, sc.nextDouble()))
                        {
                            System.out.println("Given point is inside the circle.");
                        }
                        else
                        {
                            System.out.println("Given point is not inside the circle.");
                        }
                        break;

                case 3: circle = inputCircle(sc);
                        circleMenu();          
                        break;

                case 4: System.out.println("\n----Main menu----");
                        break;

                default: System.out.println("Error, wrong input. Try again");
                        break;
            }

            if(choice != 4 && choice != 3)
            {
                System.out.print("\nEnter your choice : ");
            }
        }
    }

    static void parallelogramMenu()
    {
        System.out.println("\n1.Display area and perimeter");
        System.out.println("2.Is Rectangle");
        System.out.println("3.Is Square");
        System.out.println("4.Enter values again");
        System.out.println("5.Go back to main menu");
        System.out.print("Enter your choice : ");
    }
    //Input mehthod for paralleleogram that take input for paralleleogram class
    static Parallelogram inputParallelogram(Scanner sc)
    {
        System.out.print("Enter length of side 1 : ");
        double s1 =  sc.nextDouble();
        System.out.print("Enter length of side 2: ");
        double s2 = sc.nextDouble();
        System.out.print("Enter angle (in degree):  ");
        Parallelogram p = new Parallelogram(s1, s2, sc.nextDouble());

        return p;
    }

    static void useParallelogram(Scanner sc)
    {
        int choice = 0;

        Parallelogram parallelogram = inputParallelogram(sc);
        parallelogramMenu();

        while(choice != 5)
        {
            try
            {
                choice = sc.nextInt();
                sc.nextLine();
            }
            catch(Exception e)
            {
                System.out.println("Error : " + e + ". Wrong input, try again");            //Error handling (input validation)
                sc.next();
            }
            
            switch (choice)
            {
                case 1: areaPerimeter(parallelogram);
                        break;

                case 2: if(parallelogram.isRectangle())
                        {
                            System.out.println("Rectangle");
                        }
                        else
                        {
                            System.out.println("Not a rectangle");
                        }
                        break;
                
                case 3: if(parallelogram.isSquare())
                        {
                            System.out.println("Square");
                        }
                        else
                        {
                            System.out.println("Not a square");
                        }
                        break;

                case 4: parallelogram = inputParallelogram(sc);
                        parallelogramMenu();     
                        break;

                case 5: System.out.println("\n----Main menu----");
                        break;

                default: System.out.println("Error, wrong input. Try again");
                        break;
            }

            if(choice != 5 && choice != 4)
            {
                System.out.print("\nEnter your choice : ");
            }
        }
    }
    public static void main(String[] args) {
        useShape();             //Main method to check Shape class.
    }
}

