import java.util.Scanner;
public class WordSplitter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sentence = sc.nextLine();
        String[] words = sentence.split(" ");
        for(String word : words) {
            System.out.println(word);
        }
    }
}
