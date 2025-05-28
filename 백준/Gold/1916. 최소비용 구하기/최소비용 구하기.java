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

    static int N, M;
    static List<List<Node>> graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            dist[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(dist[end]);
    }

    static void dijkstra(int start) {
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
    }
}