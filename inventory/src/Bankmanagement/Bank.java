package Bankmanagement;

import java.util.HashMap;
import java.util.Map;

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
