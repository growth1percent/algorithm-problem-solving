import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList[n + 1];
        int start = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        boolean[] visited1 = new boolean[n + 1];
        dfs(start, visited1);
        System.out.println();

        boolean[] visited2 = new boolean[n + 1];
        bfs(start, visited2);

    }

    static void dfs(int start, boolean[] visited) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");

                List<Integer> neighbors = graph[node];
                Collections.sort(neighbors, Collections.reverseOrder());

                for (int next : neighbors) {
                    if (!visited[next]) {
                        stack.push(next);
                    }
                }
            }
        }
    }

    static void bfs(int start, boolean[] visited) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.pollFirst();
            System.out.print(node + " ");

            List<Integer> neighbors = graph[node];
            Collections.sort(neighbors);

            for (int next : neighbors) {
                if (!visited[next]) {
                    queue.addLast(next);
                    visited[next] = true;
                }
            }
        }
    }
}