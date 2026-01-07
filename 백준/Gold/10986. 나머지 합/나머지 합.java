import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long sum = 0;

        int[] count = new int[M];
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(st.nextToken());
            sum += num;

            int remainder = (int) (sum % M);
            count[remainder]++;
        }

        long result = count[0];

        for (int i = 0; i < M; i++) {
            if (count[i] > 1) {
                result += (long) count[i] * (count[i] - 1) / 2;
            }
        }

        System.out.println(result);
    }
}