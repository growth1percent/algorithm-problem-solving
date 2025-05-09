import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int edgeNum = sc.nextInt();

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeNum; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        boolean[] visited = new boolean[n + 1];

        // 모든 정점에 대해 DFS 수행
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfsIterative(i, visited);
                answer++;
            }
        }

        System.out.print(answer);
    }
    static void dfsIterative(int start, boolean[] visited) {
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            visited[node] = true;

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