import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE / 2; // Integer.MAX_VALUE 사용하면 overflow 위험 존재
    static int n, m;
    static int[][] dist;
    static int[][] next;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n + 1][n + 1];
        next = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            Arrays.fill(next[i], -1);
            dist[i][i] = 0;

        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (dist[u][v] > w) {
                dist[u][v] = w;
                next[u][v] = v;
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];

                        if (next[i][k] != -1) {
                            next[i][j] = next[i][k];
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print((dist[i][j] == INF ? 0 : dist[i][j]) + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || dist[i][j] == INF) {
                    System.out.println(0);
                } else {
                    List<Integer> path = getPath(i, j);
                    System.out.print(path.size() + " ");
                    for (int city : path) {
                        System.out.print(city + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    static List<Integer> getPath(int start, int end) {
        List<Integer> path = new ArrayList<>();
        if (next[start][end] == -1) {
            return path;
        }

        int at = start;
        while (at != end) {
            path.add(at);

            if (next[at][end] == -1) {
                return new ArrayList<>();
            }

            at = next[at][end];
        }
        path.add(at);

        return path;
    }
}