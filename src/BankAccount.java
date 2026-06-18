import java.util.ArrayList;
public class BankAccount {
    private String name;
    private int accountNumber;
    private int pin;
    private double balance;
    private ArrayList<String> transactionHistory;
    public BankAccount(String name, int accountNumber, int pin, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        transactionHistory = new ArrayList<>();
        transactionHistory.add("Account Created with Balance : ₹" + balance);
    }
    public String getName() {
        return name;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public boolean validatePin(int enteredPin) {
        return pin == enteredPin;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited : ₹" + amount);
            System.out.println("Deposit Successful.");
        } else {
            System.out.println("Invalid Amount.");
        }
    }
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Amount.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient Balance.");
            return;
        }
        balance -= amount;
        transactionHistory.add("Withdrawn : ₹" + amount);
        System.out.println("Withdrawal Successful.");
    }
    public void changePin(int oldPin, int newPin) {
        if (pin == oldPin) {
            pin = newPin;
            transactionHistory.add("PIN Changed");
            System.out.println("PIN Changed Successfully.");
        } else {
            System.out.println("Wrong Old PIN.");
        }
    }
    public void showTransactionHistory() {
        System.out.println("\n===== Transaction History =====");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}