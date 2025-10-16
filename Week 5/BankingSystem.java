abstract class Account {
    public abstract void calculateInterest();
}

class Savings extends Account {
    public void calculateInterest() {
        System.out.println("Savings account interest calculated at 6%.");
    }
}

class Current extends Account {
    public void calculateInterest() {
        System.out.println("Current account interest calculated at 4%.");
    }
}

class Loan extends Account {
    public void calculateInterest() {
        System.out.println("Loan account interest calculated at 10%.");
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Account s = new Savings();
        Account c = new Current();
        Account l = new Loan();
        s.calculateInterest();
        c.calculateInterest();
        l.calculateInterest();
    }
}
