import java.util.Scanner;

public class CharFrequency {
    public static String[][] frequency(String s) {
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++) freq[s.charAt(i)]++;
        String[][] result = new String[s.length()][2];
        int idx = 0;
        boolean[] seen = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!seen[c]) {
                result[idx][0] = String.valueOf(c);
                result[idx][1] = String.valueOf(freq[c]);
                idx++;
                seen[c] = true;
            }
        }
        String[][] finalArr = new String[idx][2];
        for (int i = 0; i < idx; i++) finalArr[i] = result[i];
        return finalArr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.nextLine();
        String[][] f = frequency(s);
        for (String[] row : f) System.out.println(row[0] + " : " + row[1]);
        sc.close();
        
    }
}
