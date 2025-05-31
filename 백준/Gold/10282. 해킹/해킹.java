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

    static List<List<Node>> graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;
    static int infested;
    static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int test_num = Integer.parseInt(st.nextToken());

        for (int i = 0; i < test_num; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            dist = new int[n + 1];

            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
                dist[j] = INF;
            }

            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                graph.get(b).add(new Node(a, s));
            }

            dijkstra(c);
            System.out.println(infested + " " + time);
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        infested = 0;
        time = 0;

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

        for (int dis : dist) {
            if (dis != INF) {
                infested++;
                time = Math.max(time, dis);
            }
        }
    }
}