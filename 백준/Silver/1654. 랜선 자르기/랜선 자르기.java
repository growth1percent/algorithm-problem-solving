import java.io.*;
import java.util.*;

public class Main {
    static int K, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        long[] cables = new long[K];

        long max = 0;
        for (int i = 0; i < K; i++) {
            cables[i] = Long.parseLong(br.readLine());
            if (cables[i] > max) max = cables[i];
        }

        long start = 1;
        long end = max;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;

            for (long cable : cables) {
                count += cable / mid;
            }

            if (count >= N) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}