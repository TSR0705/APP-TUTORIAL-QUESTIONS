class HelloThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello");
        }
    }
}

class WelcomeThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Welcome");
        }
    }
}

public class HelloWelcomeThreads {
    public static void main(String[] args) {
        Thread t1 = new HelloThread();
        Thread t2 = new WelcomeThread();
        t1.start();
        t2.start();
    }
}
