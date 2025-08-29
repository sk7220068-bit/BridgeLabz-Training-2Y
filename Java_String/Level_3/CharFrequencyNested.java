import java.util.Scanner;

public class CharFrequencyNested {
    public static String[] frequency(String s) {
        char[] arr = s.toCharArray();
        int[] freq = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') continue;
            freq[i] = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    freq[i]++;
                    arr[j] = '0';
                }
            }
        }
        String[] result = new String[arr.length];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '0') {
                result[idx++] = arr[i] + " : " + freq[i];
            }
        }
        String[] finalArr = new String[idx];
        for (int i = 0; i < idx; i++) finalArr[i] = result[i];
        return finalArr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.nextLine();
        String[] res = frequency(s);
        for (String str : res) System.out.println(str);
        sc.close();
    }
}
