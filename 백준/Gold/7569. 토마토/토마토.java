import java.util.*;

public class Main {
    static int m, n, h;
    static int[][][] box;
    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();
        box = new int[m][n][h];
        Deque<int[]> queue = new ArrayDeque<>();
        boolean hasUnripe = false;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    box[k][j][i] = sc.nextInt();
                    if (box[k][j][i] == 1) {
                        queue.addLast(new int[]{k, j, i, 0});
                    }
                    if (box[k][j][i] == 0) {
                        hasUnripe = true;
                    }
                }
            }
        }

        if (!hasUnripe) {
            System.out.println(0);
            return;
        }

        int result = bfs(queue);
        System.out.println(result);
    }

    static int bfs(Deque<int[]> queue) {
        int days = 0;

        while (!queue.isEmpty()) {
            int[] pos = queue.pollFirst();
            int x = pos[0];
            int y = pos[1];
            int z = pos[2];
            int day = pos[3];
            days = Math.max(days, day);

            for (int d = 0; d < 6; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                int nz = z + dz[d];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && nz >= 0 && nz < h) {
                    if (box[nx][ny][nz] == 0) {
                        queue.addLast(new int[]{nx, ny, nz, day + 1});
                        box[nx][ny][nz] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < h; k++) {
                    if (box[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }
        return days;
    }
}