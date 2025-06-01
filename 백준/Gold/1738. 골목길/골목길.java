import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static class Edge {
        int from, to, cost;

        Edge (int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static List<Edge> edges;
    static int[] dist;
    static int n, m;
    static final int MIN_INF = Integer.MIN_VALUE;
    static int[] prev;
    static boolean[] visited;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        dist = new int[n + 1];
        Arrays.fill(dist, MIN_INF);
        prev = new int[n + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.add(new Edge(u, v, w));
            graph.get(u).add(v);
        }

        boolean hasCycle = bellmanFord(1);
        List<Integer> path = new ArrayList<>();

        if (dist[n] == MIN_INF) {
            System.out.println(-1);
            return;
        }

        if (hasCycle) {
            visited = new boolean[n + 1];
            for (Edge e : edges) {
                if (dist[e.from] != MIN_INF && dist[e.to] < dist[e.from] + e.cost) {
                    if (dfs(e.to)) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        for (int at = n; at != 0; at = prev[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        for (int p : path) {
            System.out.print(p + " ");
        }
    }

    static boolean bellmanFord(int start) {
        dist[start] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (Edge e : edges) {
                if (dist[e.from] != MIN_INF && dist[e.to] < dist[e.from] + e.cost) {
                    dist[e.to] = dist[e.from] + e.cost;
                    prev[e.to] = e.from;
                }
            }
        }

        for (Edge e : edges) {
            if (dist[e.from] != MIN_INF && dist[e.to] < dist[e.from] + e.cost) {
                return true;
            }
        }

        return false;
    }

    static boolean dfs(int node) {
        if (node == n) return true;
        visited[node] = true;

        for (int next : graph.get(node)) {
            if (!visited[next] && dfs(next)) {
                return true;
            }
        }
        return false;
    }
}