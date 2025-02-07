public class BankAccount 
{
    static int staticCounter = 1000;            //Static variable to hold the count of instances made.
    private String accountName;                 //Variable to store accountName;
    private String accountNumber = "";          //Variable to store accountNumber;
    private int pinNumber;                      //Private variable to store account pin number.
    private double depositAmount;               //Variable to store the account balance.
    private double interestRate;                //Variable to store intrest rate.

    //Constructor method to implement the given arguents and generate account number.
    BankAccount(String accountName, int pinNumber, double depositAmount, double interestRate)           
    {
        this.accountName = accountName;
        this.pinNumber = pinNumber;

        if (depositAmount <= 1000)
        {
            System.out.println("Error deposit amount should be greater than 1000.");
            return;
        }
        else
            this.depositAmount = depositAmount;

        this.accountNumber = "ACC" + ++staticCounter;
        this.interestRate = interestRate;
    }

    //Method that returns false if deposited amount is 0 otherwise increase the balance with the given amount and return true.
    boolean deposit(double amount)
    {
        if (amount <= 0)
        {
            System.out.println("Error, deposit amount must be positive!");
            return false;
        }
        else 
            depositAmount += amount;
        
        return true;
    }

    //Method that returns amount withdrawn if pin and have enough balance in account otherwise throws error(return 0).
    double withdraw(int pin, double amount)
    {
        if (pin == this.pinNumber && this.depositAmount >= amount)
        {
            this.depositAmount -= amount;
            return amount;
        }
        else if(pin != this.pinNumber)
        {
            System.out.println("Error, Incorrect Pin!");
        }
        else
            System.out.println("Error, Insuficient fund!");

        return 0;
    }

    //Method that print account details if pin is correct otherwise throws error.
    void displayAccount(int pin)
    {
        if ( pin != this.pinNumber)
        {
            System.out.println("Error, Incorrect pin number. Access Denied!");
            return;
        }
        
        System.out.println("----Account Details----");
        System.out.println("Name : " + accountName);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Balance : " + depositAmount);
        System.out.println("Intrest Rate : " + interestRate);
    }
    
    //Method that returns account Balance.
    double checkBalance()
    {
        return depositAmount;
    }
    
    //Method that returns account number;
    String accountNum()
    {
        return accountNumber;
    }
}
