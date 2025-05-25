import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        visited = new boolean[n + 1];
        result = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        bfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(result[i]);
        }
    }

    static void bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.pollFirst();
            List<Integer> neighbors = graph.get(node);

            for (int next : neighbors) {
                if (!visited[next]) {
                    queue.addLast(next);
                    result[next] = node;
                    visited[next] = true;
                }
            }
        }
    }
}