import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    public static void DFS(int num, int jarisu) {
        if (jarisu == N) {
            System.out.println(num);
        }

        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }

            if (isPrime(num * 10 + i)) {
                DFS(num * 10 + i, jarisu + 1);
            }
        }
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}