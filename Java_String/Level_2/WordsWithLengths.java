import java.util.Scanner;

public class WordsWithLengths {
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }
    public static String[] splitWords(String str) {
        int len = getLength(str);
        int spaces = 0;
        for (int i = 0; i < len; i++) if (str.charAt(i) == ' ') spaces++;
        int[] indexes = new int[spaces + 2];
        int idx = 1;
        for (int i = 0; i < len; i++) if (str.charAt(i) == ' ') indexes[idx++] = i;
        indexes[0] = -1;
        indexes[indexes.length - 1] = len;
        String[] words = new String[spaces + 1];
        for (int i = 0; i < words.length; i++) {
            String w = "";
            for (int j = indexes[i] + 1; j < indexes[i + 1]; j++) w += str.charAt(j);
            words[i] = w;
        }
        return words;
    }
    public static String[][] getWordLengthTable(String[] words) {
        String[][] table = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            table[i][0] = words[i];
            table[i][1] = String.valueOf(getLength(words[i]));
        }
        return table;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = splitWords(text);
        String[][] table = getWordLengthTable(words);
        System.out.println("Word\tLength");
        for (String[] row : table) System.out.println(row[0] + "\t" + Integer.parseInt(row[1]));
    sc.close();
    }
}
