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

    static int N,E;
    static List<List<Node>> graph;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        int[] dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            dist[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] dist_1 = dijkstra(1);
        int[] dist_v1 = dijkstra(v1);
        int[] dist_v2 = dijkstra(v2);

        long dist_1_v1_v2 = (long) dist_1[v1] + dist_v1[v2] + dist_v2[N];
        long dist_1_v2_v1 = (long) dist_1[v2] + dist_v2[v1] + dist_v1[N];

        long result = Math.min(dist_1_v1_v2, dist_1_v2_v1);
        System.out.println(result >= INF ? -1 : result);
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            dist[i] = INF;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.cost > dist[current.index]) continue;

            for (Node neighbor : graph.get(current.index)) {
                int newCost = current.cost + neighbor.cost;

                if (newCost < dist[neighbor.index]) {
                    pq.offer(new Node(neighbor.index, newCost));
                    dist[neighbor.index] = newCost;
                }
            }
        }

        return dist;
    }
}