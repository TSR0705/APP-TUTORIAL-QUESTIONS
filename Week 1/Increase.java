import java.util.Scanner;
public class Increase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int x = sc.nextInt();
        System.out.println("Initial value: " + x);
        System.out.println("Post increment x++ = " + x++);
        System.out.println("After Post increment: " + x);
        System.out.println("Pre increment ++x = " + (++x));
        System.out.println("Value after pre-increment: " + x);
    }
}
