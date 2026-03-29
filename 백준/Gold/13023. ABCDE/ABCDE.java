import java.util.*;
import java.io.*;

public class Main {
    public static List<Integer>[] A;
    public static boolean[] visited;
    public static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 0; i < N; i++) {
            DFS(i, 1);
            if (result == 1) {
                break;
            }
        }

        System.out.println(result);
    }

    public static void DFS(int node, int depth) {
        if (result == 1) {
            return;
        }

        if (depth == 5) {
            result = 1;
            return;
        }

        visited[node] = true;

        for (int i : A[node]) {
            if (!visited[i]) {
                DFS(i, depth + 1);
            }
        }

        visited[node] = false;
    }
}