import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE / 2;
    static int V, E;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = INF;

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[V + 1][V + 1];

        for (int i = 1; i <= V; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            dist[u][v] = w;

            // 동일한 간선이 여러 개인 경우
            // dist[u][v] = Math.min(dist[u][v], w);
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            answer = Math.min(answer, dist[i][i]);
        }

        System.out.println(answer == INF ? -1 : answer);
    }
}