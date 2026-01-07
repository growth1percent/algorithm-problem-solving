import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long sum = 0;

        long[] arr = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            arr[i] = sum;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int iIdx = Integer.parseInt(st.nextToken());
            int jIdx = Integer.parseInt(st.nextToken());

            long result = arr[jIdx] - arr[iIdx - 1];

            bw.write(result + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}