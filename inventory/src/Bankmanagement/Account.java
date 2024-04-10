package Bankmanagement;


import java.util.ArrayList;
import java.util.List;

public class Account {
    private static final double MIN_BALANCE = 100;
    private static final double CHARGE_AMOUNT = 10;
    private Account account;
    private String accountNumber;
    private double balance;
    private List<String> transactions;
    private String accountHolderName; // New field for the account holder's name
    private String transactionId;
    private static int counter = 001;



    public Account(String accountNumber, double initialBalance,String accountHolderName) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.accountHolderName = accountHolderName; // Initialize the account holder's name
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposit: +" + amount);
    }

    public void withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            transactions.add("Withdrawal: -" + amount);
        } else {
            if (amount > MIN_BALANCE)
                System.out.println("Insufficient fund");
            else {
                transactions.add("Failed Withdrawal: Insufficient funds. A charge of $" + CHARGE_AMOUNT + " has been applied.");
                balance -= CHARGE_AMOUNT; // Apply charge for going below minimum balance

            }
        }
    }
    public String generateTransactionId() {
        this.transactionId = this.accountHolderName.substring(0, 3).toUpperCase() + ++Account.counter;
        return this.transactionId;
    }



    public void transferTo(Account recipient, double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            recipient.deposit(amount);
            transactions.add("Transfer to " + recipient.getAccountNumber() + ": -" + amount);
        } else {
            if (amount > MIN_BALANCE)
                System.out.println("Insufficient fund");
            else {
                transactions.add(
                        "Failed Transfer: Insufficient funds. A charge of $" + CHARGE_AMOUNT + " has been applied.");
                balance -= CHARGE_AMOUNT; // Apply charge for going below minimum balance
            }
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("Name: "+accountHolderName);
        System.out.println("id "+ generateTransactionId());
        System.out.println("Transaction History:");
        for (String transaction : transactions) {
            System.out.println("- " + transaction);
        }
    }
}

