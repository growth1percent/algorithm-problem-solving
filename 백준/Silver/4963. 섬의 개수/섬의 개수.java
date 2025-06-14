import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int w,h;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, 1, -1, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    int target = Integer.parseInt(st.nextToken());
                    map[i][j] = target;
                }
            }

            int areaNum = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        dfs(i,j);
                        areaNum++;
                    }
                }
            }

            System.out.println(areaNum);
        }
    }
    static void dfs(int startX, int startY) {
        visited[startX][startY] = true;

        for (int d = 0; d < 8; d++) {
            int nx = startX + dx[d];
            int ny = startY + dy[d];

            if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }
}