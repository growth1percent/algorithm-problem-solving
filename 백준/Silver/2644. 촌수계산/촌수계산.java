import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static boolean[] visited;
    static List<List<Integer>> graph;
    static int value = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        System.out.println(bfs(from, to));
    }
    static int bfs(int u, int v) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[] {u, 0});
        visited[u] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.pollFirst();
            int node = current[0];
            int value = current[1];

            if (node == v) return value;

            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    queue.addLast(new int[] {next, value + 1});
                    visited[next] = true;
                }
            }
        }

        return -1;
    }
}