class Table5Thread extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("5 x " + i + " = " + (5 * i));
        }
    }
}

class Table10Thread extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("10 x " + i + " = " + (10 * i));
        }
    }
}

public class MultiplicationTables {
    public static void main(String[] args) {
        Thread t5 = new Table5Thread();
        Thread t10 = new Table10Thread();
        t5.start();
        t10.start();
    }
}
