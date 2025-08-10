import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        long[] trees = new long[N];
        long start = 0;
        long end = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            long height = Integer.parseInt(st.nextToken());
            end = Math.max(height, end);
            trees[i] = height;
        }

        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (trees[i] >= mid) {
                    sum += trees[i] - mid;
                }
            }

            if (sum >= M) {
                start = mid + 1;
                result = Math.max(result, mid);
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}