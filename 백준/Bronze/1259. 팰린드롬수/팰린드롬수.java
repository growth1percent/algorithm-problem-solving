import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s.equals("0")) return;

            String[] array = s.split("");
            int left = 0;
            int right = s.length() - 1;

            boolean isRight = true;
            while (left < right) {
                if (!array[left].equals(array[right])) {
                    isRight = false;
                    break;
                }
                left++;
                right--;
            }

            if (isRight) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}