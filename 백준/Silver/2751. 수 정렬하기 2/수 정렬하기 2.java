import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        int offset = -min;
        int[] count = new int[max - min + 1];

        for (int i = 0; i < N; i++) {
            count[arr[i] + offset]++;
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                bw.write((i - offset) + "\n");
                count[i]--;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}