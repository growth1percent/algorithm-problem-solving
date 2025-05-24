import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int[] alpha = new int[26];

        for (int i = 0; i < 26; i++) {
            alpha[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (alpha[idx] == -1) {
                alpha[idx] = i;
            }
        }

        for (int value : alpha) {
            System.out.print(value + " ");
        }
    }
}