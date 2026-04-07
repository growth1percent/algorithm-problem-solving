import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long result = n;

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                result = result - result / i;
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        if (n > 1) {
            result = result - result / n;
        }

        System.out.println(result);
    }
}
