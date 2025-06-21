import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] map;
    static int min = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                if (row.charAt(j) == 'W') {
                    map[i][j] = true; // W인 경우 true;
                }
            }
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                check(i, j);
            }
        }

        System.out.println(min);
    }
    static void check(int startX, int startY) {
        int endX = startX + 8;
        int endY = startY + 8;
        int color_b = 0;
        int color_w = 0;

        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                boolean current = map[i][j];
                boolean expected_w = ((i + j) % 2 == 0);
                boolean expected_b = !expected_w;

                if (current != expected_w) color_w++;
                if (current != expected_b) color_b++;
            }
        }

        min = Math.min(min, Math.min(color_w, color_b));
    }
}