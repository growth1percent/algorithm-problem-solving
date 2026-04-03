import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static boolean[] V;
    static int[] S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = new boolean[N + 1];
        S = new int[M];

        backtracking(0);
    }

    static void backtracking(int length) {
        if (length == M) {
            printArray();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!V[i]) {
                V[i] = true;
                S[length] = i;
                backtracking(length + 1);
                V[i] = false;
            }
        }
    }

    static void printArray() {
        for (int i = 0; i < M; i++) {
            System.out.print(S[i] + " ");
        }
        System.out.println();
    }
}