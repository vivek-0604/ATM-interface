import java.util.Scanner;
import java.util.ArrayList;

class user{
    public String name;
    public String username;
    public String password;
    public String accountNo;
    float balance = 0f; 
    ArrayList<String> transactionHistory = new ArrayList<String>();
    Scanner sc = new Scanner(System.in);
    public boolean check_password(String password)
    {
        if (password.length() < 8){
            return false;
        }
        return true;
    }
    

    public void setPassword() {
        while (true) {
            System.out.print("Enter the password :");
            this.password = sc.nextLine();
            System.out.println();
            if (check_password(password)) {
                System.out.println("Password Set SucessFully !");
                break;
            } else
                System.out.println("Password Not follow the criteria...");
        }
    }
   
    public void sign_up() {
        System.out.print("Enter your Name: ");
        name = sc.nextLine();
        System.out.print("Enter your Username: ");
        username = sc.nextLine();
        System.out.println();
        System.out.println();
        setPassword();
        System.out.println();
        System.out.print("Enter your Account No: ");
        accountNo = sc.nextLine();

        System.out.println();

    }
    public Boolean sign_in() {
        System.out.println();
        System.out.println("Login Using Your Username and Password..!");
        Boolean isLogin = false;
        while (!isLogin) {
            System.out.print("Enter your username: ");
            String user = sc.nextLine();
            System.out.print("Enter your Password: ");
            String pass = sc.nextLine();

            if (user.equals(username) && pass.equals(password)) {
                System.out.println();
                System.out.println("Successfully Login..!");
                isLogin = true;
            } else {
                System.out.println();
                System.out.println("Invaild Username OR Password");
                isLogin = false;
            }
        }
        return isLogin;
    }
}
class atm extends user{
public float checkBalance() {
        return balance;

    }
        public void withdraw()
    {
        System.out.println("Enter the amount to withdraw:");
        Scanner sc = new Scanner(System.in);
        int amount=sc.nextInt();
        if(amount>checkBalance())
        {
            System.out.println("Insufficient Balance...!");
            String history ="Failed due to Insuficient Balance.";
            transactionHistory.add(history);
        }
        else
        {
            balance=balance-amount;
            System.out.println("Withdraw Successfully...");
            String history = "Rs." + amount + " is WithDraw";
            transactionHistory.add(history);
        }

        //menu();
    }
     public void trans_History() {
        System.out.println();
        System.out.println("Your Account Transaction Histoty :");
        for (int i = 0; i < transactionHistory.size(); i++) {
            System.out.println(transactionHistory.get(i));
        }
        System.out.println();
    }
    public void deposit()
    {
        System.out.println("Enter the amount :");
        Scanner sc = new Scanner(System.in);
        int amount=sc.nextInt();
        balance= balance+ amount;
        System.out.println("Money Deposited Successfully...");
         String history = "Rs." + amount + " is Deposited";
        transactionHistory.add(history);
    }
    public void transfer() {
        System.out.println();
        sc.nextLine();
        System.out.print("Enter Receipent's Name: ");
        String receipent = sc.nextLine();
        System.out.print("\nEnter amount to transfer : ");
        float amount = sc.nextFloat();

        if (balance < amount) {
            System.out.println("Transfer is Failed");
            System.out.println("Not Sufficient Balance to Transfer");
        } else {
            balance -= amount;
            System.out.println("SuccessFully Transfered to " + receipent);
            String history = "Rs." + amount + " is Transfered to " + receipent;
            transactionHistory.add(history);

        }
    }
    
        
       
}

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        user atmUser = new user();
        System.out.println();
        System.out.println("Welcome To ATM");
        System.out.println();
        System.out.println("Register To YourSelf");
        atmUser.sign_up();
        atmUser.sign_in();
        atm ATM = new atm();
        while (true) {
            System.out.println();
            System.out.println();
            System.out.println("1. Check Your Balance ");
            System.out.println("2. Withdraw  ");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction History ");
            System.out.println();
            System.out.print("Enter Your Choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\n Your Account Balance : " + ATM.checkBalance());
                    break;
                case 2:
                    ATM.withdraw();
                    break;
                case 3:
                    ATM.deposit();
                    break;
                case 4:
                    ATM.transfer();
                    break;
                case 5:
                    ATM.trans_History();
                    break;
                default:
                    System.out.println("Invaild Choice Please Enter Correct Choice");
                    break;
            }

        }

    }
    
}
