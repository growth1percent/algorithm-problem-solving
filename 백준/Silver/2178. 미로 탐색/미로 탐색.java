import java.util.*;

public class Main {
    static int n, m;
    static boolean[][] visited;
    static int[][] path;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n][m];
        path = new int[n][m];
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                path[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int startX, int startY) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{startX, startY});
        visited[startX][startY] = true;

        int[][] distance = new int[n][m];
        distance[startX][startY] = 1;

        while (!queue.isEmpty()) {
            int[] pos = queue.pollFirst();
            int x = pos[0];
            int y = pos[1];

            if (x == n - 1 && y == m - 1) {
                return distance[x][y];
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (path[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.addLast(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        distance[nx][ny] = distance[x][y] + 1;
                    }
                }
            }
        }
        return -1;
    }
}