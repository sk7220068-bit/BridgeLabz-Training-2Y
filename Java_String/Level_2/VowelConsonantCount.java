import java.util.*;

public class VowelConsonantCount {
    static String checkChar(char c) {
        if (c >= 'A' && c <= 'Z') c = (char)(c + 32);
        if (c >= 'a' && c <= 'z') {
            if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return "Vowel";
            return "Consonant";
        }
        return "Not a Letter";
    }

    static int[] countVC(String str) {
        int v = 0, c = 0;
        for (int i = 0; i < str.length(); i++) {
            String res = checkChar(str.charAt(i));
            if (res.equals("Vowel")) v++;
            else if (res.equals("Consonant")) c++;
        }
        return new int[]{v,c};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] result = countVC(str);
        System.out.println("Vowels: " + result[0] + " Consonants: " + result[1]);
        sc.close();
    }
}
