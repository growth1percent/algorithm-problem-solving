import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] A = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] S, int[] E) {
                if (S[1] == E[1]) {
                    return S[0] - E[0];
                }
                return S[1] - E[1];
            }
        });
        int count = 0;
        int end = 0;

        for (int i = 0; i < N; i++) {
            if (A[i][0] >= end) {
                end = A[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
