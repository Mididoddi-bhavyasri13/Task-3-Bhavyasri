import java.util.ArrayList;
public class BankSystem {
    private ArrayList<BankAccount> accounts;
    public BankSystem() {
        accounts = new ArrayList<>();
    }
    public void createAccount(String name, int accountNumber, int pin, double balance) {
        if (findAccount(accountNumber) != null) {
            System.out.println("Account Number already exists!");
            return;
        }
        BankAccount account = new BankAccount(name, accountNumber, pin, balance);
        accounts.add(account);
        System.out.println("================================");
        System.out.println("Account Created Successfully!");
        System.out.println("Welcome " + name);
        System.out.println("================================");
    }
    public BankAccount findAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;}
        }
        return null;
    }
    public BankAccount login(int accountNumber, int pin) {
        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account Not Found!");
            return null;}
        if (account.validatePin(pin)) {
            System.out.println("\nLogin Successful!");
            System.out.println("Welcome " + account.getName());
            return account;
        } else {
            System.out.println("Invalid PIN!");
            return null;
        }
    }
    public void showAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No Accounts Available.");
            return;
        }
        System.out.println("\n===== Account List =====");
        for (BankAccount account : accounts) {
            System.out.println("-------------------------");
            System.out.println("Name : " + account.getName());
            System.out.println("Account Number : " + account.getAccountNumber());
            System.out.println("Balance : ₹" + account.getBalance());
        }
    }
}