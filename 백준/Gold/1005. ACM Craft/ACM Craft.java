import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, N, K;
    static List<List<Integer>> graph;
    static int[] inDegree;
    static int[] time, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            inDegree = new int[N + 1];
            dp = new int[N + 1];
            time = new int[N + 1];

            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            String[] time_table = br.readLine().split(" ");
            for (int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(time_table[i - 1]);
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph.get(u).add(v); inDegree[v]++;
            }

            int target = Integer.parseInt(br.readLine());

            Deque<Integer> queue = new ArrayDeque<>();

            for (int i = 1; i <= N; i++) {
                if (inDegree[i] == 0) {
                    queue.addLast(i);
                    dp[i] = time[i];
                }
            }

            while (!queue.isEmpty()) {
                int current = queue.pollFirst();

                for (int next : graph.get(current)) {
                    inDegree[next]--;
                    dp[next] = Math.max(dp[next], dp[current] + time[next]);

                    if (inDegree[next] == 0) {
                        queue.addLast(next);
                    }
                }
            }

            System.out.println(dp[target]);
        }
    }
}