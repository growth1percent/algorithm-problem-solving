import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> area;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int areaSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int target_x = Integer.parseInt(st.nextToken());
            int target_y = Integer.parseInt(st.nextToken());

            for (int j = y; j < target_y; j++) {
                for (int k = x; k < target_x; k++) {
                    map[j][k] = 1;
                }
            }
        }

        area = new ArrayList<>();

        int areaNum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    dfs(i, j);
                    areaNum++;
                    area.add(areaSize);
                    areaSize = 0;
                }
            }
        }

        Collections.sort(area);

        System.out.println(areaNum);

        for (int value : area) {
            System.out.print(value + " ");
        }
    }
    static void dfs(int startY, int startX) {
        visited[startY][startX] = true;
        areaSize++;

        for (int i = 0; i < 4; i++) {
            int ny = startY + dy[i];
            int nx = startX + dx[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (!visited[ny][nx] && map[ny][nx] == 0) {
                    dfs(ny, nx);
                }
            }
        }
    }
}