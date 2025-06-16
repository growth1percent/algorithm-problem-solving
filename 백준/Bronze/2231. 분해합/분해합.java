import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int num = N;
        int digit = 0;

        while (num > 0) { num /= 10; digit++;}
        for (int i = Math.max(0, N - 9 * digit); i < N; i++) {
            String[] s = String.valueOf(i).split("");
            int target = i;
            for (String value : s) {
                target += Integer.parseInt(value);
            }

            if (target == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}