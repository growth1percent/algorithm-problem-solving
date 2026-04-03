import java.util.*;
import java.io.*;

public class Main {
    static int[] A;
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        A = new int[N];
        count = 0;

        backtracking(0);

        System.out.println(count);
    }
    static void backtracking(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            A[row] = i;
            if (check(row)) {
                backtracking(row + 1);
            }
        }
    }

    static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            if (A[row] == A[i]) // 열 기준
                return false;
            if (Math.abs(row - i) == Math.abs(A[row] - A[i])) // 대각선 기준
                return false;
        }

        return true;
    }
}