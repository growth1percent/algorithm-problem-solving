import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] prefix_arr = new int[N + 1];
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            sum += n;
            prefix_arr[i] = sum;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int result = prefix_arr[end] - prefix_arr[start - 1];

            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}