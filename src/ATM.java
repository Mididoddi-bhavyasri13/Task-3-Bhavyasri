import java.util.Scanner;
public class ATM {
    private BankSystem bankSystem;
    private Scanner sc;
    public ATM() {
        bankSystem = new BankSystem();
        sc = new Scanner(System.in);
    }
    public void start() {
        int choice;
        do {
            System.out.println("\n=================================");
            System.out.println("        ATM MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Show All Accounts");
            System.out.println("4. Exit");
            System.out.print("Enter Your Choice : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    loginMenu();
                    break;
                case 3:
                    bankSystem.showAllAccounts();
                    break;
                case 4:
                    System.out.println("\nThank You for Using ATM Management System!");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } 
        while (choice != 4);
    }
    private void createAccount() {
        System.out.println("\n===== CREATE ACCOUNT =====");
        sc.nextLine();
        System.out.print("Enter Your Name : ");
        String name = sc.nextLine();
        System.out.print("Enter Account Number : ");
        int accountNumber = sc.nextInt();
        System.out.print("Create PIN : ");
        int pin = sc.nextInt();
        System.out.print("Initial Deposit : ");
        double balance = sc.nextDouble();
        bankSystem.createAccount(name, accountNumber, pin, balance);
    }
    private void loginMenu() {
        System.out.println("\n===== LOGIN =====");
        System.out.print("Account Number : ");
        int accountNumber = sc.nextInt();
        System.out.print("PIN : ");
        int pin = sc.nextInt();
        BankAccount account = bankSystem.login(accountNumber, pin);
        if (account != null) {
            userMenu(account);
        }
    }
    private void userMenu(BankAccount account) {
        int choice;
        do {
            System.out.println("\n=================================");
            System.out.println("Welcome " + account.getName());
            System.out.println("=================================");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Change PIN");
            System.out.println("6. Logout");
            System.out.print("Enter Choice : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Amount : ");
                    double deposit = sc.nextDouble();
                    account.deposit(deposit);
                    break;
                case 2:
                    System.out.print("Enter Amount : ");
                    double withdraw = sc.nextDouble();
                    account.withdraw(withdraw);
                    break;
                case 3:
                    System.out.println("Current Balance : ₹" + account.getBalance());
                    break;
                case 4:
                    account.showTransactionHistory();
                    break;
                case 5:
                    System.out.print("Enter Old PIN : ");
                    int oldPin = sc.nextInt();
                    System.out.print("Enter New PIN : ");
                    int newPin = sc.nextInt();
                    account.changePin(oldPin, newPin);
                    break;
                case 6:
                    System.out.println("Logged Out Successfully.");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 6);
    }
}
