import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;

class UseSLL
{
    static void displayMenu()
    {
        System.out.println("\n1.To insert element");
        System.out.println("2.To delete Node");
        System.out.println("3.To find maximum value in list");
        System.out.println("4.To see length of list");
        System.out.println("5.To display list");
        System.out.println("6.Create a New SLL");
        System.out.println("7.Save SLL to file");
        System.out.println("8.Load SLL from file");
        System.out.println("9.To exit the program");
        System.out.print("Enter your choice : ");
    }

    static void useSLL()
    {
        SLL list = new SLL();
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        displayMenu();

        while(choice != 9)
        {
            try{
                choice = sc.nextInt();
            }
            catch(InputMismatchException e)
            {
                choice = 0;
            }
            sc.nextLine();

            switch(choice)
            {
                case 1: System.out.print("Enter postion(Node will be added after that position)(for starting list enter 0) : ");
                        int pos = sc.nextInt();
                        System.out.print("Enter Data : ");
                        list.insertAfter(pos, sc.nextInt());
                        break;
                
                case 2: System.out.print("Enter postion(that position node will be deleted) : ");
                        list.deleteNode(sc.nextInt());
                        break;
                case 3: int max = list.Max();
                        if(max != -1)
                            System.out.println("Max of list : "+max);
                        break;
                
                case 4: int length = list.length();
                        if(length != -1)
                            System.out.println("Length of List : " + length);
                        break;

                case 5:list.displayList();
                        break;

                case 6: list = new SLL();               //Creating a new SLL object
                        System.out.println("New SLL object has been created");
                        break;

                case 7: saveSLL(sc, list);          //Saving sll object into user defined files
                        break;

                case 8: SLL temp = loadSLL(sc);         //Loading sll object from file to the current program
                        if(temp == null)
                        {
                            System.out.println("Please, Try again");
                        }
                        else
                        {
                            list = temp;
                            System.out.println("Successfully executed");
                            list.displayList();
                        }
                        break;

                case 9: System.out.println("Exiting the progam......");
                        break;

                default:    System.out.println("Error, wrong choice input, try agian!");
                            break;
            }
            displayMenu();
        }
        sc.close();
    }
    
    //Method to save Current SLL object into user defined file
    public static void saveSLL(Scanner sc, SLL list)
    {
        //Taking file name as input in which object will be written
        System.out.println("Enter file name to store sll object with .sll extension(if pressed enter default file.sll will be used) : ");
        String fileName = sc.nextLine();
        //Checking if user has given a file or not
        if(fileName.equals(""))
            fileName = "file.sll";
        else if(!fileName.endsWith(".sll"))         //If file extension is not .sll then print error
        {
            System.out.println("Error, wrong file extension");
            return;
        }
        
        //Creating a try with resource ObjectOutputStream variable to write a object in the given FileOuputStream
        try(ObjectOutputStream fos = new ObjectOutputStream(new FileOutputStream(fileName)))
        {
            //Writing the object
            fos.writeObject(list);
            System.out.println("SLL Object has been written to "+fileName);
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println("Error, file not found");
        }
        catch(IOException ioe)
        {
            System.out.println("Error, reading file");
        }
    }
    
    //Method to load all files with .sll extension and give user to choose which file to select to load itdf
    public static SLL loadSLL(Scanner sc)
    {
        //File to open the directory
        File file = null;
        File[] paths;           //File array to store all the files in the directory
        
            
            file = new File(".");
            FileFilter ff = null;
            
            paths = file.listFiles(ff);         //file.listFiles to list all the files in directory
            
            
            if( paths != null)
            {
                int i=0;
                System.out.println("----Files----");
                for(File path : paths)      //Printing all files in the directory
                {
                    if(path.getName().endsWith(".sll"))
                        System.out.println((++i) + ". " + path.getName());
                }
                
                File[] sllFile = new File[i];       //File array to store the files with .sll extension
                i=0;
                
                for(File path : paths)      //Copying the files with .sll extension
                {
                    if(path.getName().endsWith(".sll"))
                        sllFile[i++] = path;
                }
                
                //User choice for .sll file to load
                int choice;
                while(true)
                {
                    System.out.print("Enter file number to select(0 for none) : ");
                    if(sc.hasNextInt())
                    {
                        choice = sc.nextInt();
                        if(choice < 0)
                        {
                            System.out.println("Error file number cannot be negative");
                            continue;
                        }
                        else if(choice > sllFile.length)
                        {
                            System.out.println("Error file does not exist");
                            continue;
                        }
                        else if(choice == 0)
                        {
                            return null;
                        }
                        break;
                    }
                    else
                    {
                        System.out.println("Error, wrong input try again");
                    }
                }
                
                //ObjectInputStream to read the object and FileInputStream to store the file in the stream
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sllFile[choice-1])))
                {
                    SLL object = (SLL)ois.readObject();
                    
                    if(object == null)
                    {
                        System.out.println("No object in selected file");
                        return null;
                    }
                    else
                    {
                        return object;
                    }
                }
                catch(FileNotFoundException fnfe)
                {
                    System.out.println("Error, file not found");
                }
                catch(IOException ioe)
                {
                    System.out.println(ioe);
                }
                catch(ClassNotFoundException cnfe)
                {
                    System.out.println(cnfe);
                }
            }
            else
            {
                System.out.println("No files in current directory");
            }
            return null;
    }

    public static void main(String[] args)
    {
        useSLL();
    }
}