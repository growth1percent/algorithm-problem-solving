import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            arr[i] = num;
        }

        Arrays.sort(arr);

        int i_idx = 0;
        int j_idx = N - 1;
        int count = 0;

        while (i_idx < j_idx) {
            if (arr[i_idx] + arr[j_idx] == M) {
                count++;
                i_idx++;
                j_idx--;
            } else if (arr[i_idx] + arr[j_idx] > M) {
                j_idx--;
            } else {
                i_idx++;
            }
        }

        System.out.println(count);
    }
}