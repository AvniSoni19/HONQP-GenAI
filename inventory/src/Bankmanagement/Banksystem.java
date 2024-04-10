package Bankmanagement;

public class Banksystem {
    public static void main(String[] args) {
        // Creating a bank
        Bank bank = new Bank("MyBank");

        // Adding accounts to the bank
        bank.addAccount("12345", 1000, "Shivangi");
        bank.addAccount("67890", 500, "harsh"); // Provide account holder's name for this account

        Account account1 = bank.getAccount("12345");
        Account account2 = bank.getAccount("67890");

        account1.deposit(1000);
        account1.transferTo(account2, 100);

        // Displaying bank details
        bank.displayBankDetails();
    }
}
