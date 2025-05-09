import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int answer = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int edgeNum = sc.nextInt();

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= edgeNum; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        dfsIterative(1);

        System.out.print(answer);
    }

    static void dfsIterative(int start) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];

        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                visited[node] = true;
                answer++;

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
}