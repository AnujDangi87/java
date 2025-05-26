import java.util.Scanner;

public class UseGraph
{
    public static void menu()
    {
        System.out.println("1. Graph 1");
        System.out.println("2. Graph 2");
        System.out.println("3. Union of Graph1 and Graph2");
        System.out.println("4. Exit the program");
        System.out.print("Enter your choice : ");
    }
    
    public static void graphMenu()
    {
        System.out.println("1. Undirected graph");
        System.out.println("2. getDegree");
        System.out.println("3. isNullGraph");
        System.out.println("4. Go back to main menu");
        System.out.print("Enter your choice : ");
    }
    
    public static void useGraph()
    {
        GraphAM a = new GraphAM("graph.txt");
        GraphAM b = new GraphAM("graph1.txt");
        
        Scanner sc = new Scanner(System.in);
        
        int choice = 0;
        menu();
        
        while(choice != 4)
        {
            choice = sc.nextInt();
            
            switch(choice)
            {
                case 1: graph(a, sc);
                        break;
                case 2: graph(b, sc);
                        break;
                case 3: System.out.println("Union Graph : ");
                        a.unionWith(b).display();
                        break;
                case 4: System.out.println("Exiting the program....");
                        break;
                default: System.out.println("Wrong input, try again");
                        break;
            }
            if(choice != 4)
            {
                System.out.println("");
                menu();
            }
        }
    }
    
    public static void graph(GraphAM graph, Scanner sc)
    {
        int choice = 0;
        
        System.out.println("");
        graphMenu();
        
        while(choice != 4)
        {
            choice = sc.nextInt();
            
            switch(choice)
            {
                case 1: graph.display();
                        break;
                case 2: System.out.print("Enter vertice to get its degree : ");
                        System.out.println("Degree : " + graph.getDegree(sc.nextInt()));
                        break;
                case 3: System.out.println(graph.isNullGraph());
                        break;
                case 4: System.out.println("---Main Menu---");
                        break;
                default: System.out.println("Wrong input, try again");
                        break;
            }
            if(choice != 4)
            {
                System.out.println("");
                graphMenu();
            }
        }
    }
    
    public static void main(String[] args)
    {
        useGraph();
    }
}