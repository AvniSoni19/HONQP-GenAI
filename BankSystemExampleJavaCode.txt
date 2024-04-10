import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

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

    public Account(String accountNumber, double initialBalance, String accountHolderName) {
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
                balance -= CHARGE_AMOUNT; // Apply charge for going below the minimum balance
            }
        }
    }

    public String generateTransactionId() {
    this.transactionId = this.accountHolderName.substring(this.accountHolderName.length() - 3).toLowerCase() + ++Account.counter;
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
                balance -= CHARGE_AMOUNT; // Apply charge for going below the minimum balance
            }
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("Name: " + accountHolderName);
        System.out.println("ID: " + generateTransactionId());
        System.out.println("Transaction History:");
        for (String transaction : transactions) {
            System.out.println("- " + transaction);
        }
    }
}

public class Bank {
    private String name;
    private Map<String, Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void addAccount(String accountNumber, double initialBalance, String accountHolderName) {
        if (!accounts.containsKey(accountNumber)) {
            Account account = new Account(accountNumber, initialBalance, accountHolderName);
            accounts.put(accountNumber, account);
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Account already exists with this account number.");
        }
    }

    public void removeAccount(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            accounts.remove(accountNumber);
            System.out.println("Account removed successfully.");
        } else {
            System.out.println("Account not found with this account number.");
        }
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void displayBankDetails() {
        System.out.println("Bank Name: " + name);
        System.out.println("Accounts:");
        for (Account account : accounts.values()) {
            System.out.println("------------------------------");
            account.displayAccountDetails();
            System.out.println("------------------------------");
        }
    }
}

public class Banksystem {
    public static void main(String[] args) {
        // Creating a bank
        Bank bank = new Bank("MyBank");

        // Adding accounts to the bank
        bank.addAccount("12345", 1000, "Shivangi");
        bank.addAccount("67890", 500, "Harsh"); // Provide account holder's name for this account

        Account account1 = bank.getAccount("12345");
        Account account2 = bank.getAccount("67890");

        account1.deposit(1000);
        account1.transferTo(account2, 100);

        // Displaying bank details
        bank.displayBankDetails();
    }
}
