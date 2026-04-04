import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());

        int start = 0;
        int end = 0;

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if (A[i] > start) {
                start = A[i];
            }
            end = end + A[i];
        }

        while (start <= end) {
            int m = start + (end - start) / 2;
            int count = 0;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                if (sum + A[i] > m) {
                    count++;
                    sum = 0;
                }
                sum = sum + A[i];
            }

            if (sum != 0) {
                count++;
            }
            if (count > M) {
                start = m + 1;
            } else {
                end = m - 1;
            }
        }

        System.out.println(start);
    }
}