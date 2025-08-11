import java.io.*;
import java.util.*;

public class Main {
    static int N, M, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int[][] ground = new int[N][M];
        int max_h = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                ground[i][j] = num;
                max_h = Math.max(num, max_h);
            }
        }

        int height = 0;
        int time = Integer.MAX_VALUE;

        for (int h = 0; h <= 256; h++) {
            int sum_added = 0;
            int sum_deleted = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (ground[i][j] > h) {
                        sum_deleted += ground[i][j] - h;
                    } else {
                        sum_added += h - ground[i][j];
                    }
                }
            }

            if ((B + sum_deleted) < sum_added) {
                continue;
            }

            int sum_time = sum_deleted * 2 + sum_added;

            if (sum_time <= time) {
                time = sum_time;
                height = Math.max(height, h);
            }

        }

        System.out.print(time + " " + height);
    }
}