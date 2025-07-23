
import java.util.Scanner;
  
public class Main {
    static BankAccount[] account = new BankAccount[10];
    static int accountCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {  // Loop for menu
            System.out.println("""
                    \nPlease Choose:
                    1 > Create a new Account
                    2 > Existing Account
                    3 > Close the program
                    """);
            System.out.print("Enter your option: ");
            int option = sc.nextInt();  

            if (option == 1) {  
                if (accountCount < account.length) {
                    BankAccount newAcc = new BankAccount();
                    newAcc.AccountCreate(sc);

                    while (!newAcc.validateUniqueAccountNumber(newAcc.accountNumber, account)) {
                        newAcc.generateAccountNumber();
                    }

                    account[accountCount++] = newAcc;

                    System.out.println("\nAccount created successfully!");
                    newAcc.DisplayAccountDetails();
                } else {
                    System.out.println("Maximum accounts reached.");
                }

            } else if (option == 2) {  
                System.out.print("Enter your account number: ");
                String accNum = sc.next();

                BankAccount found = null;

                for (int i = 0; i < accountCount; i++) {
                    if (account[i] != null && account[i].accountNumber.equals(accNum)) {
                        found = account[i];
                        break;
                    }
                }

                if (found != null) {
                    boolean s = true;
                    while (s) {
                        System.out.println("""
                            \nChoose an operation:
                            1 > Credit Money
                            2 > Debit Money
                            3 > Check Balance
                            4 > View Account Details
                            5 > Back to Main Menu
                            """);

                        System.out.print("Enter your choice: ");
                        int op = sc.nextInt();

                        
                        switch (op) {
                            case 1:
                                found.creditBalance(accNum, sc);
                                break;
                            case 2:
                                found.debitBalance(accNum, sc);
                                break;
                            case 3:
                                found.checkBalance();
                                break;
                            case 4:
                                found.DisplayAccountDetails();
                                break;
                            case 5:
                                s = false;
                                break;
                            default:
                                System.out.println("Invalid option.");
                        }
                    }
                } else {
                    System.out.println("Account not found. Please create an account first.");
                }

            } else if (option == 3) {
                System.out.println("Exiting program. Thank you!");
                break;  
            } else {
                System.out.println("Invalid input. Please enter 1, 2 or 3.");
            }
        }

        sc.close();
    }
}

    
        
       
 
class BankAccount{   //BankAccount class
    String holderName;
    String email;
    String phone;
    String accountNumber;
    String ifscCode;
    String branchName;
    String bankName;
    double balance = 1000.0;
    void AccountCreate(Scanner sc){
      
       System.out.print("Enter holder name: ");
       holderName = sc.next();
       System.out.print("Enter email: ");
       email = sc.next();
       System.out.print("Enter phone: ");
       phone = sc.next();
       generateAccountNumber();  
       System.out.print("Enter IFSC code: ");
       ifscCode = sc.next();
       System.out.print("Enter branch name: ");
       branchName = sc.next();
       System.out.print("Enter bank name: ");
       bankName = sc.next();
    }

    void DisplayAccountDetails() {     //Method to display account details
        System.out.println("Bank Account Details:");
        System.out.println("Account Holder Name: " + holderName);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("IFSC Code: " + ifscCode);
        System.out.println("Branch Name: " + branchName);
        System.out.println("Bank Name: " + bankName);
    }
    
        public String generateAccountNumber()  //generateAccountNumber
    {
        int RandomDigit = (int)(Math.random() * 9000) + 1000;
        this.accountNumber = holderName + RandomDigit;
        return accountNumber;
    }
       public void creditBalance(String accountNumber,Scanner sc)  //creditBalance method
    {
        
        System.out.println("Enter the amount to credit:");
        
        double creditBalance = sc.nextDouble();
        if(creditBalance > 0){
            balance +=  creditBalance;
            System.out.println( creditBalance +" credited successfully to account: " + accountNumber);
        }else{
            System.out.println("Invalid amount. Please enter a valid amount to credit.");
        }
        
        System.out.println("After crediting, the balance is: " + balance);
    }
       public void debitBalance(String accountNumber,Scanner sc)  //debitBalance method
    {
        
        System.out.println("Enter the amount to debit:");
        int debitBalance = sc.nextInt();
        if(debitBalance > 0 && balance > debitBalance){
            balance -= debitBalance;
            System.out.println(debitBalance+" debited successfully from account: " +accountNumber);
        }else{
            System.out.println("Invalid amount. Please enter a valid amount to debit.");
        }
        
        System.out.println("After debiting, the balance is: " + balance);
    }
    public void checkBalance()  //checkBalanace method
    {
        System.out.println("The amount in the your account is: " +balance);
    }
     public boolean validateUniqueAccountNumber(String accountNumber, BankAccount[] account) { //validateAccountNumber
    for (int i = 0; i < account.length; i++) {
        if (account[i] != null && account[i].accountNumber.equals(accountNumber)) {
            return false; 
        }
     }
    return true; 
    }
    public boolean validatePresenceAccountNumber(String accountNumber, BankAccount[] account) //ValidatePresenceAccountNumber
    {
        for(int i = 0; i < account.length;i++){
           if(account [i] != null && account[i].accountNumber.equals(accountNumber))
              return true;
        }
        return false;
    }
}