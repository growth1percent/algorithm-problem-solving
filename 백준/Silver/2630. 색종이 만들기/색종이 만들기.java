import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] paper;
    static int white = 0, blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }
    static void divide(int x, int y, int size) {
        if (isSameColor(x, y, size)) {
            if (paper[x][y] == 0) white++;
            else blue++;
            return;
        }

        int newSize = size / 2;
        divide(x, y, newSize); // 1사분면
        divide(x, y + newSize, newSize); // 2사분면
        divide(x + newSize, y + newSize, newSize); // 3사분면
        divide(x + newSize, y, newSize); // 4사분면
    }
    static boolean isSameColor(int x, int y, int size) {
        int color = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}