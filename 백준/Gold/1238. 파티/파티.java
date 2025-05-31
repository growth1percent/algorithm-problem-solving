import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int index;
        int cost;

        Node (int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static List<List<Node>> graph, graph_inv;
    static int[] dist, dist_inv;
    static final int INF = Integer.MAX_VALUE;
    static int N, M, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        graph_inv = new ArrayList<>();
        dist = new int[N + 1];
        dist_inv = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            graph_inv.add(new ArrayList<>());
            dist[i] = INF;
            dist_inv[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
            graph_inv.get(v).add(new Node(u, w));
        }

        dijkstra(X, graph, dist);
        dijkstra(X, graph_inv, dist_inv);

       int[] sum_dist = new int[N + 1];
       int max = 0;

       for (int i = 0; i <= N; i++) {
           sum_dist[i] = dist[i] + dist_inv[i];
           max = Math.max(max, sum_dist[i]);
       }
       
        System.out.println(max);
    }

    static void dijkstra(int start, List<List<Node>> graph, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.cost > dist[current.index]) continue;

            for (Node neighbor : graph.get(current.index)) {
                int newCost = dist[current.index] + neighbor.cost;
                if (newCost < dist[neighbor.index]) {
                    pq.offer(new Node(neighbor.index, newCost));
                    dist[neighbor.index] = newCost;
                }
            }
        }
    }
}