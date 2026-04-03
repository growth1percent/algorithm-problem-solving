import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int[] paper;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new int[10][10];
        paper = new int[] {0, 5, 5, 5, 5, 5};

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0, 0);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    static void backtracking(int xy, int useCnt) {
        if (xy == 100) {
            result = Math.min(result, useCnt);
            return;
        }

        int x = xy % 10;
        int y = xy / 10;

        if (result <= useCnt) return;

        if (map[y][x] == 1) {
            for (int i = 5; i > 0; i--) {
                if (paper[i] > 0 && check(x, y, i)) {
                    paper[i]--;
                    fill(x, y, i, 0);
                    backtracking(xy + 1, useCnt + 1);
                    fill(x, y, i, 1);
                    paper[i]++;
                }
            }
        } else {
            backtracking(xy + 1, useCnt);
        }
    }

    static boolean check(int x, int y, int size) {
        if (y + size > 10 || x + size > 10) return false;
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (map[i][j] != 1) return false;
            }
        }

        return true;
    }

    static void fill(int x, int y, int size, int binary) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                map[i][j] = binary;
            }
        }
    }
}