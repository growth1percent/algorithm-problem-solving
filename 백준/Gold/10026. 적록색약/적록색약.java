import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] visited;
    static int[][] graph;
    static Map<String, Integer> map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        map = new HashMap<>();

        map.put("R", 0);
        map.put("G", 1);
        map.put("B", 2);

        for (int i = 0; i < N; i++) {
            String[] array = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                String s = array[j];
                int num = map.get(s);
                graph[i][j] = num;
            }
        }

        int areaNum = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, graph[i][j]);
                    areaNum++;
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1) {
                    graph[i][j] = 0;
                }
            }
        }
        int gbAreaNum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, graph[i][j]);
                    gbAreaNum++;
                }
            }
        }

        System.out.print(areaNum + " " + gbAreaNum);

    }
    static void dfs(int startX, int startY, int color) {
        visited[startX][startY] = true;

        for (int i = 0; i < 4; i++) {
            int nx = startX + dx[i];
            int ny = startY + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!visited[nx][ny] && graph[nx][ny] == color) {
                    dfs(nx, ny, color);
                }
            }
        }
    }
}