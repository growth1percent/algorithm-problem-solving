import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] array = new String[15];

        for (int i = 1; i <= 15; i++) {
            if (i % 15 == 0) {
                array[i - 1] = "FizzBuzz";
            } else if (i % 3 == 0) {
                array[i - 1] = "Fizz";
            } else if (i % 5 == 0) {
                array[i - 1] = "Buzz";
            } else {
                array[i - 1] = String.valueOf(i);
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target_idx = 0;
        int target = 0;

        for (int i = 0; i < 3; i++) {
            String s = br.readLine();
            if (isNumeric(s)) {
                target = Integer.parseInt(s) + 3 - i;
                target_idx = target % 15;
                break;
            }
        }

        if (target_idx == 0) {
            if (!isNumeric(array[14])) {
                System.out.println(array[14]);
            } else {
                System.out.println(target);
            }
        } else {
            if (!isNumeric(array[target_idx - 1])) {
                System.out.println(array[target_idx - 1]);
            } else {
                System.out.println(target);
            }
        }
    }

    static boolean isNumeric(String s) {
        if (s == null || s.isEmpty()) return false;

        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
}