import java.util.Scanner;
public class DivisibleBy3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int div = sc.nextInt();
        if(div % 3 == 0) {
            System.out.println("Number is divisible by 3");
        } else {
            System.out.println("Not divisible");
        }
    }
}
