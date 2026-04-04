import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int k = sc.nextInt();
        int ans = 0;

        int start = 1;
        int end = k;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            int count = 0;

            for (int i = 1; i <= N; i++) {
                count += Math.min(middle / i, N);
            }

            if (count >= k) {
                ans = middle;
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        System.out.println(ans);
    }
}