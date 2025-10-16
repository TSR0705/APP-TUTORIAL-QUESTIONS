import java.util.*;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accNum, String accHolder, double bal) {
        accountNumber = accNum;
        accountHolderName = accHolder;
        balance = bal;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn. Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient balance or Invalid amount!");
        }
    }

    public void transfer(BankAccount toAccount, double amount) {
        if (amount > 0 && balance >= amount) {
            this.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transferred " + amount + " to " + toAccount.accountHolderName);
        } else {
            System.out.println("Transfer failed!");
        }
    }

    public void display() {
        System.out.println("Account: " + accountNumber + " Name: " + accountHolderName + ", Balance: " + balance);
    }
}

public class BankManagement {
    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>();
        BankAccount acc1 = new BankAccount("101", "Alice", 5000);
        BankAccount acc2 = new BankAccount("102", "Bob", 3000);
        accounts.add(acc1);
        accounts.add(acc2);
        acc1.deposit(1000);
        acc2.withdraw(500);
        acc1.transfer(acc2, 2000);
        System.out.println("Accounts:");
        for (BankAccount acc : accounts) {
            acc.display();
        }
    }
}
