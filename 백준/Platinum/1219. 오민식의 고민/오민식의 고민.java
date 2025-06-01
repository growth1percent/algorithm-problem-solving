import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static class Edge {
        int from, to;
        long cost;

        Edge (int from, int to, long cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static List<Edge> edges;
    static long[] dist;
    static int N, start, end, M;
    static final long MIN_INF = Long.MIN_VALUE / 2;
    static int[] earn;
    static boolean[] visited;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new long[N];
        earn = new int[N];
        edges = new ArrayList<>();
        Arrays.fill(dist, MIN_INF);
        graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.add(new Edge(u, v, w));
            graph.get(u).add(v);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int m = Integer.parseInt(st.nextToken());
            earn[i] = m;
        }

        boolean hasCycle = bellmanFord(start);

        if (hasCycle) {
            for (Edge e : edges) {
                if (dist[e.from] != MIN_INF && dist[e.to] < dist[e.from] + earn[e.to] - e.cost) {
                    visited = new boolean[N];
                    if (dfs(e.to)) {
                        System.out.println("Gee");
                        return;
                    }
                }
            }
        }

        if (dist[end] == MIN_INF) {
            System.out.println("gg");
        } else {
            System.out.println(dist[end]);
        }

    }

    static boolean dfs(int node) {
        if (node == end) return true;
        visited[node] = true;

        for (int next : graph.get(node)) {
            if (!visited[next] && dfs(next)) {
                return true;
            }
        }

        return false;
    }

    static boolean bellmanFord(int start) {
        dist[start] = earn[start];

        for (int i = 0; i < N - 1; i++) {
            boolean updated = false;
            for (Edge e : edges) {
                if (dist[e.from] != MIN_INF && dist[e.to] < dist[e.from] + earn[e.to] - e.cost) {
                    dist[e.to] = dist[e.from] + earn[e.to] - e.cost;
                    updated = true;
                }
            }

            if (!updated) return false;
        }

        for (Edge e : edges) {
            if (dist[e.from] != MIN_INF && dist[e.to] < dist[e.from] + earn[e.to] - e.cost) {
                return true;
            }
        }

        return false;
    }
}