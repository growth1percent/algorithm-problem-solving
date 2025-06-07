import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<List<Integer>> graph;
    static int[] inDegree;
    static int[] dp, time_table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        inDegree = new int[N + 1];
        dp = new int[N + 1];
        time_table = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            time_table[i] = time;

            while (true) {
                int u = Integer.parseInt(st.nextToken());
                if (u == -1) break;

                graph.get(u).add(i); inDegree[i]++;
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.addLast(i);
                dp[i] = time_table[i];
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.pollFirst();

            for (int next : graph.get(current)) {
                inDegree[next]--;
                dp[next] = Math.max(dp[next], dp[current] + time_table[next]);

                if (inDegree[next] == 0) {
                    queue.addLast(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(dp[i]);
        }
    }
}