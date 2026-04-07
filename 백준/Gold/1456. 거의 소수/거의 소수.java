import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        int limit = (int) Math.sqrt(B);
        boolean[] isPrime = new boolean[limit + 1];

        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;

        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                long temp = (long) i;

                while ((double) i <= (double) B / temp) {
                    temp = temp * i;
                    if (temp >= A) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
