import java.util.Scanner;
//This program contains two User menus.

//Comparison between composition and aggregation is given in readme file.
public class UseBag 
{
    //Static Method that displays the Main Menu of the program
    static void mainMenu()
    {
        System.out.println("1.Create a Bag");
        System.out.println("2.Add book to Bag");
        System.out.println("3.Search by keyword");
        System.out.println("4.Find book with most keyword Occurrences");
        System.out.println("5.To exit the program");
        System.out.print("Enter your choice : ");
    }

    //Static Method that displays second menu after Main menu.
    static void displayMenu2()
    {
        System.out.println("1.Insert Page");
        System.out.println("2.To go back to Main menu");
        System.out.print("Enter your choice : ");
    }

    //Staic Method that Check the useability of Bag object. 
    static void useBag()
    {
        int choice = 0;
        int current = -1;
        Bag []bag = new Bag[3];
        Scanner sc = new Scanner(System.in);
        mainMenu();

        while(choice != 5)
        {
            choice  = sc.nextInt();
            sc.nextLine();

            switch (choice)
            {
                case 1:
                        bag[++current] = new Bag();
                        System.out.println("Bag created.");
                        
                        break;
                case 2:
                        int choice2 = 0;
                        System.out.print("Enter Book name : ");
                        String name = sc.nextLine();
                        System.out.print("Enter author name : ");
                        Book book = new Book(name,sc.nextLine());
                        
                        System.out.println("");
                        displayMenu2();

                        while(choice2 != 2)
                        {
                            choice2 = sc.nextInt();
                            sc.nextLine();

                            switch (choice2){
                                case 1:
                                        System.out.print("Enter page text : ");
                                        String text = sc.nextLine();
                                        book.addPageText(text);
                                        break;
                                case 2: 
                                        System.out.println("Returning to Main menu");
                                        break;
                                default:
                                        System.out.println("Error, wrong input!");
                                        break;
                            }

                            if(choice2 != 2)
                                System.out.print("\nEnter your choice : ");
                        }

                        
                            bag[current].insertBook(book);

                        break;

                case 3:
                        System.out.print("Enter keyword : ");
                        Book []keybook = bag[current].searchBooksByKeyword(sc.nextLine());

                        if(keybook[0] == null)
                        {
                            System.out.println("Keyword not found.");
                            break;
                        }

                        for(int i=0;i<keybook.length-1;i++)
                        {   
                            System.out.println("Book : \""+ keybook[i].bookName +"\" by " + keybook[i].author);
                        }
                        
                        break;
                case 4:
                        System.out.print("Enter keyword : ");
                        String keyword = sc.nextLine();
                        Book mostOcc = bag[current].searchBookWithMostOccurrences(keyword);

                        if(mostOcc == null)
                        {
                            System.out.println("Keyword not found.");
                            break;
                        }

                        System.out.println("Book : \"" + mostOcc.bookName + "\" by " + mostOcc.author + " (has " + mostOcc.countKeywordOccurrences(keyword) +" occurrences)");
                        break;
                case 5:
                        System.out.println("Exiting the program.....");
                        break;
                default:
                        System.out.println("Error, wrong input!");
                        break;
            }
            
            if(choice != 5)
            {
                System.out.print("\nEnter your choice : ");
            }
        }
        sc.close();
    }

    
    public static void main(String[] args)
    {
        useBag();               //Calling useBag Method.
    }
}
