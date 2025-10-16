class BankAccount {
    String accountNumber;
    String accountHolder;
    double balance;

    void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance (current): " + balance);
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        acc.accountNumber = "101";
        acc.accountHolder = "Hloworld";
        acc.balance = 5000.75;
        acc.displayBalance();
    }
}
