import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, K, M, P;
    static int[] order, count;
    static int[] inDegree;
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

            order = new int[M + 1];
            count = new int[M + 1];
            inDegree = new int[M + 1];
            graph = new ArrayList<>();

            for (int i = 0; i <= M; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph.get(u).add(v); inDegree[v]++;
            }

            Deque<Integer> queue = new ArrayDeque<>();

            for (int i = 1; i <= M; i++) {
                if (inDegree[i] == 0) {
                    queue.addLast(i);
                    order[i] = 1;
                }
            }

            while (!queue.isEmpty()) {
                int current = queue.pollFirst();

                for (int next : graph.get(current)) {
                    inDegree[next]--;

                    if (order[next] < order[current]) {
                        order[next] = order[current];
                        count[next] = 1;
                    } else if (order[next] == order[current]) {
                        count[next]++;
                    }

                    if (inDegree[next] == 0) {
                        if (count[next] >= 2) {
                            order[next]++;
                        }
                        queue.addLast(next);
                    }
                }
            }

            System.out.print(K + " " + order[M]);
            System.out.println();
        }
    }
}