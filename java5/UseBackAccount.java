import java.util.Scanner;

//There are two menu in this program first is main menu and second comes after creation of account.
public class UseBackAccount {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        BankAccount coustmer1;              //Making reference of BankAccount.
        //Menu Driven display
        System.out.println("----------------Welcome to xyz bank-----------------");
        
        System.out.println("1.New Account");
        System.out.println("2.To exit the bank");
        System.out.print("Enter your choice : ");
        int choice1 = 0;
        while(choice1 != 2)
        {
            //Taking choice for menu driven as input for user.
            choice1 = sc.nextInt();
            //Eating the new line character.
            sc.nextLine();
            switch(choice1)
            {
                case 1 : 
                        //Taking user input for Second Menu.
                        System.out.print("Enter your Name : ");
                        String name = sc.nextLine();
                        System.out.print("Enter your Pin Number(four digits) : ");
                        int accountPin = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter your deposit Amount : ");
                        double damount = sc.nextDouble();
                        System.out.print("Enter current interest rate : ");
                        double interest = sc.nextDouble();

                        //Creating instance and giving arguments for constructor.
                        coustmer1 = new BankAccount(name, accountPin, damount, interest);

                        System.out.println("Your Account Number is : " + coustmer1.accountNum());
                        System.out.println("");

                        //Second menu driven.
                        System.out.println("1.To deposit money in Account");
                        System.out.println("2.To withdraw amount");
                        System.out.println("3.To display account");
                        System.out.println("4.To go to previous menu");
                        System.out.print("Enter your choice : ");

                        int choice2 = 0;
                        while(choice2 != 4)
                        {

                            choice2 = sc.nextInt();
                            sc.nextLine();
                            switch(choice2)
                            {
                                case 1 : 
                                        System.out.print("Enter the amount to deposit : ");
                                        if(coustmer1.deposit(sc.nextDouble()))
                                        {
                                            System.out.println("New balance : " + coustmer1.checkBalance());
                                        }
                                        break;
                                case 2 :
                                        System.out.print("Enter the amount to be withdrawn : ");
                                        double amount = sc.nextDouble();
                                        System.out.print("Enter Account Pin : ");
                                        int pin = sc.nextInt();
                                        
                                        if(coustmer1.withdraw(pin, amount) != 0)
                                        {
                                            System.out.println("Withdrawn amount : " + amount);
                                        }
                                        break;
                                case 3 : 
                                        System.out.print("Enter account pin : ");
                                        coustmer1.displayAccount(sc.nextInt());
                                        break;
                                case 4 :
                                        System.out.println("Going to main menu.");
                                        break;
                            }
                            if (choice2 != 4)
                                System.out.print("\nEnter your choice : ");
                        }
                        break;
                case 2: 
                        System.out.println("Exiing the bank.....");
                        break;
            }
            if (choice1 != 2)
                System.out.print("\nEnter your choice : ");
        }
        sc.close();
    }
}
