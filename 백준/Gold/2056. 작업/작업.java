import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] dp, time_table;
    static int[] inDegree;
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        time_table = new int[N + 1];
        inDegree = new int[N + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            time_table[i] = time;
            int num = Integer.parseInt(st.nextToken());

            if (num == 0) continue;

            for (int j = 0; j < num; j++) {
                int v = Integer.parseInt(st.nextToken());

                graph.get(v).add(i); inDegree[i]++;
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

        int max = 0;

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}