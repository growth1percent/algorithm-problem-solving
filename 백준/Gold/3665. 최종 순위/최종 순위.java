import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static List<List<Integer>> graph;
    static int[] inDegree;
    static int[] rank_table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for (int t = 0; t < test; t++) {
            n = Integer.parseInt(br.readLine());
            graph = new ArrayList<>();
            rank_table = new int[n + 1];
            inDegree = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            String[] rank = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                int r = Integer.parseInt(rank[i - 1]);
                rank_table[i] = r;
            }

            for (int i = 1; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    graph.get(rank_table[i]).add(rank_table[j]);
                    inDegree[rank_table[j]]++;
                }
            }

            int num = Integer.parseInt(br.readLine());

            for (int i = 0; i < num; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                if (graph.get(u).contains(v)) {
                    graph.get(u).remove(Integer.valueOf(v));
                    inDegree[v]--;
                    graph.get(v).add(u);
                    inDegree[u]++;
                } else {
                    graph.get(v).remove(Integer.valueOf(u));
                    inDegree[u]--;
                    graph.get(u).add(v);
                    inDegree[v]++;
                }
            }

            Deque<Integer> queue = new ArrayDeque<>();
            List<Integer> result = new ArrayList<>();
            boolean cycle = false;
            boolean certain = true;

            for (int i = 1; i <= n; i++) {
                if (inDegree[i] == 0) {
                    queue.addLast(i);
                }
            }

            while (!queue.isEmpty()) {
                if (queue.size() > 1) {
                    certain = false;
                    break;
                }

                int current = queue.pollFirst();
                result.add(current);

                for (int next : graph.get(current)) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) {
                        queue.addLast(next);
                    }
                }
            }

            if (!certain) {
                System.out.println("?");
            } else if (result.size() < n) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int value : result) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        }
    }
}