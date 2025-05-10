import java.util.*;

public class Main {
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] result;
    static boolean[][] visited;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        int startX = -1, startY = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void bfs(int startX, int startY) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{startX, startY, 0});
        visited = new boolean[n][m];
        visited[startX][startY] = true;
        result = new int[n][m];
        // 초기값을 -1로 설정
        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], -1);
        }
        result[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] pos = queue.pollFirst();
            int x = pos[0];
            int y = pos[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        result[nx][ny] = result[x][y] + 1;
                        queue.addLast(new int[]{nx, ny});
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    result[i][j] = 0;
                }
            }
        }
    }
}