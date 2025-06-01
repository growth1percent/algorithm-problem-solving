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
    static final long INF = Integer.MAX_VALUE;
    static long[] dist;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        dist = new long[N + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(from, to, cost));
        }

        boolean hasCycle = bellmanFord(1);

        if (hasCycle) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    System.out.println(-1);
                } else {
                    System.out.println(dist[i]);
                }
            }
        }
    }

    static boolean bellmanFord(int start) {
        dist[start] = 0;
        for (int i = 0; i < N - 1; i++) {
            for (Edge e : edges) {
                if (dist[e.from] != INF && dist[e.to] > dist[e.from] + e.cost) {
                    dist[e.to] = dist[e.from] + e.cost;
                }
            }
        }

        for (Edge e : edges) {
            if (dist[e.from] != INF && dist[e.to] > dist[e.from] + e.cost) {
                return true;
            }
        }

        return false;
    }
}