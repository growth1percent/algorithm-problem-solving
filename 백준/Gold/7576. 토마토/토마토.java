import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] box;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        box = new int[n][m];
        boolean isUnriped = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    isUnriped = true;
                }
            }
        }

        if (isUnriped == false) {
            System.out.println(0);
            return;
        }

        System.out.println(bfs(m, n));
    }

    static int bfs(int m, int n) {
        Deque<int[]> queue = new ArrayDeque<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 1) {
                    queue.addLast(new int[]{i, j, 0});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.pollFirst();
            int y = pos[0];
            int x = pos[1];
            int days = pos[2];
            result = Math.max(days, result);

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (box[ny][nx] == 0) {
                        queue.addLast(new int[]{ny, nx, days + 1});
                        box[ny][nx] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    return -1;
                }
            }
        }

        return result;
    }
}