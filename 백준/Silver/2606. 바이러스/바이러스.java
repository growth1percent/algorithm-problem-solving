import java.util.*;

public class Main {
    static boolean[] visited;
    static List<Integer>[] graph;
    static int answer = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int edgeNum = sc.nextInt();

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= edgeNum; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        dfs(1);

        System.out.print(answer);
    }

    static void dfs(int node) {
        visited[node] = true;
        answer++;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}