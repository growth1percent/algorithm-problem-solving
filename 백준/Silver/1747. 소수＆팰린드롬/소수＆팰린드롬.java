import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] isPrime = new boolean[10_000_001];

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= isPrime.length - 1; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= isPrime.length - 1; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int result = 0;

        for (int i = N; i <= isPrime.length - 1; i++) {
            if (isPrime[i] && isPalindrome(i)) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }

    static boolean isPalindrome(int num) {
        char[] c = String.valueOf(num).toCharArray();

        int start = 0;
        int end = c.length - 1;

        while (start <= end) {
            if (c[start] != c[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
