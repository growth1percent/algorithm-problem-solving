import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int gcd = gcd(N, M);
        int lcm = N * M / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }
    static int gcd(int a, int b) {
        int temp, n;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) {
            n = a % b;
            a = b;
            b = n;
        }

        return a;
    }
}