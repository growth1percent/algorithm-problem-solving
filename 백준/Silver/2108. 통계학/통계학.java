import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        int[] count = new int[8001];

        int sum = 0;
        int max = 0;
        int max_num = Integer.MIN_VALUE;
        int min_num = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            sum += num;

            max_num = Math.max(max_num, num);
            min_num = Math.min(min_num, num);

            count[num + 4000]++;
        }

        long mean = Math.round((double) sum / N);
        bw.write(mean + "\n");

        int idx = 0;
        int mid = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                max = Math.max(max, count[i]);
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                idx += count[i];

                if (idx >= (N + 1) / 2) {
                    mid = i - 4000;
                    break;
                }
            }
        }

        bw.write(mid + "\n");

        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                list.add(i - 4000);
            }
        }

        if (list.size() > 1) {
            bw.write(list.get(1) + "\n");
        } else {
            bw.write(list.get(0) + "\n");
        }

        bw.write(max_num - min_num + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}