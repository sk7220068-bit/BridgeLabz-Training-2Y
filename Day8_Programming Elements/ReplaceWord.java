import java.util.Scanner;

public class ReplaceWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        System.out.print("Word to replace: ");
        String oldWord = sc.nextLine();
        System.out.print("New word: ");
        String newWord = sc.nextLine();

        String result = sentence.replaceAll("\\b" + oldWord + "\\b", newWord);
        System.out.println("Modified Sentence: " + result);
        sc.close();
    }
}
