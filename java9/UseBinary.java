import java.util.Scanner;

public class UseBinary
{

    static void mainMenu()
    {
        System.out.println("\n1.Binary Tree");
        System.out.println("2.Binary Dearch Tree");
        System.out.println("3.Exit the program....");
        System.out.print("Enter your choice : ");
    }
    //Use binary method to check useability of the BinaryTree and BinarySearchTree classes
    static void useBinary()
    {
        int choice = 0;

        Scanner sc = new Scanner(System.in);
        mainMenu();

        while(choice != 3)
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
                case 1: useBinaryTree(sc);
                        break;

                case 2: useBinarySearchTree(sc);
                        break;

                case 3: System.out.println("Exiting the program....");
                        break;

                default: System.out.println("Error, wrong input. Try again");
                        break;
            }
            if(choice != 3)
            {
                mainMenu();
            }
        }
        sc.close();
    }

    static void binaryTreeMenu()
    {
        System.out.println("\n1.Insert");
        System.out.println("2.Search");
        System.out.println("3.Delete");
        System.out.println("4.Inorder Traversal");
        System.out.println("5.Preorder Traversal");
        System.out.println("6.Postorder Traversal");
        System.out.println("7.Go back to main menu");
        System.out.print("Enter your choice : ");
    }
    //BinaryTree class useability
    static void useBinaryTree(Scanner sc)
    {
        int choice = 0;

        BinaryTree bt = new BinaryTree();
        binaryTreeMenu();

        while(choice != 7)
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
                case 1: System.out.print("Enter data(int) : ");
                        try                     
                        {
                            bt.insert(sc.nextInt());
                            System.out.print("Binary Tree : ");
                            bt.inOrderTraversal(bt.root);
                            System.out.println();
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error : " + e + ". Wrong input, try again");            //Error handling (input validation)
                            sc.next();
                        }
                        break;
                
                case 2: System.out.print("Enter value(int) : ");
                        try                     
                        {
                            System.out.println(bt.search(sc.nextInt()));
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error : " + e + ". Wrong input, try again");            //Error handling (input validation)
                            sc.next();
                        }
                        break;
                    
                case 3: System.out.print("Enter value(int) : ");
                        try
                        {
                            bt.root = bt.delete(bt.root, sc.nextInt());
                            System.out.print("Binary Tree : ");
                            bt.inOrderTraversal(bt.root);
                            System.out.println();
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error : " + e + ". Wrong input, try again");                     //Error handling (input validation)
                            sc.next();
                        }
                        break;
                
                case 4: System.out.print("Inorder : ");
                        bt.inOrderTraversal(bt.root);
                        System.out.println();
                        break;

                case 5: System.out.print("Preorder : ");
                        bt.preOrderTraversal(bt.root); 
                        System.out.println();
                        break;

                case 6: System.out.print("Postorder : ");
                        bt.postOrderTraversal(bt.root);
                        System.out.println();
                        break;

                case 7: System.out.println("\n----Main menu----");
                        break;

                default: System.out.println("Error, wrong input. Try again");
                        break;
            }

            if(choice != 7)
            {
                System.out.print("\nEnter your choice : ");
            }
        }
    }

    static void binarySearchTreeMenu()
    {
        System.out.println("\n1.Insert");
        System.out.println("2.Search");
        System.out.println("3.Delete");
        System.out.println("4.Find Minimum");
        System.out.println("5.Find Maximum");
        System.out.println("6.Display all traversal");
        System.out.println("7.Go back to main menu");
        System.out.print("Enter your choice : ");
    }
    //BinarySearchTree class useablity
    static void useBinarySearchTree(Scanner sc)
    {
        int choice = 0;

        BinarySearchTree bst = new BinarySearchTree();
        binarySearchTreeMenu();

        while(choice != 7)
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
                case 1: System.out.print("Enter data(int) : ");
                        try                     
                        {
                            bst.insert(bst.root, sc.nextInt());
                            System.out.print("Binary Search Tree : ");
                            bst.inOrderTraversal(bst.root);
                            System.out.println();
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error : " + e + ". Wrong input, try again");            //Error handling (input validation)
                            sc.next();
                        }
                        break;
                
                case 2: System.out.print("Enter value(int) : ");
                        try                     
                        {
                            System.out.println(bst.search(bst.root, sc.nextInt()));
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error : " + e + ". Wrong input, try again");            //Error handling (input validation)
                            sc.next();
                        }
                        break;
                    
                case 3: System.out.print("Enter value(int) : ");
                        try
                        {
                            bst.root = bst.delete(bst.root, sc.nextInt());
                            System.out.print("Binary Search Tree : ");
                            bst.inOrderTraversal(bst.root);
                            System.out.println();
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error : " + e + ". Wrong input, try again");                     //Error handling (input validation)
                            sc.next();
                        }
                        break;
                
                case 4: System.out.println("Min : " + bst.finMin());
                        break;

                case 5: System.out.println("Max : " + bst.findMax());
                        break;

                case 6: System.out.print("Inorder : ");
                        bst.inOrderTraversal(bst.root);
                        System.out.println();
                        System.out.print("Preorder : ");
                        bst.preOrderTraversal(bst.root); 
                        System.out.println();
                        System.out.print("Postorder : ");
                        bst.postOrderTraversal(bst.root);
                        System.out.println();
                        break;

                case 7: System.out.println("\n----Main menu----");
                        break;

                default: System.out.println("Error, wrong input. Try again");
                        break;
            }

            if(choice != 7)
            {
                System.out.print("\nEnter your choice : ");
            }
        }
    }

    public static void main(String[] args) {
        useBinary();
    }
}
