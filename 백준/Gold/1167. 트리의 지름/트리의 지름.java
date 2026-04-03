import java.util.*;
import java.io.*;

public class Main {
    static int[] distance;
    static boolean[] visited;
    static List<Edge>[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int V = Integer.parseInt(br.readLine());

        A = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while(true) {
                int E = Integer.parseInt(st.nextToken());
                if (E == -1)
                    break;
                int dist = Integer.parseInt(st.nextToken());

                A[node].add(new Edge(E, dist));
            }
        }

        distance = new int[V + 1];
        visited = new boolean[V + 1];
        BFS(1);
        int max_idx = 1;
        for (int i = 2; i <= V; i++) {
            if (distance[max_idx] < distance[i]) {
                max_idx = i;
            }
        }
        distance = new int[V + 1];
        visited = new boolean[V + 1];
        BFS(max_idx);

        Arrays.sort(distance);

        System.out.println(distance[V]);
    }

    static void BFS(int node) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now = queue.pollFirst();
            for (Edge e : A[now]) {
                if (!visited[e.e]) {
                    distance[e.e] = distance[now] + e.dist;
                    queue.addLast(e.e);
                    visited[e.e] = true;
                }
            }
        }
    }
}

class Edge {
    int e;
    int dist;

    Edge(int e, int dist) {
        this.e = e;
        this.dist = dist;
    }
}