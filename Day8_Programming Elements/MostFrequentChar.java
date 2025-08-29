import java.util.Scanner;

public class MostFrequentChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        int[] freq = new int[256]; // ASCII
        for (char ch : str.toCharArray()) {
            freq[ch]++;
        }

        int max = 0;
        char mostFreq = ' ';
        for (char ch : str.toCharArray()) {
            if (freq[ch] > max) {
                max = freq[ch];
                mostFreq = ch;
            }
        }

        System.out.println("Most Frequent Character: " + mostFreq);
        sc.close();
    }
}
