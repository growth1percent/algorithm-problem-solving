import java.util.*;

public class Main {
    static int len;
    static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            len = sc.nextInt();

            int start_x = sc.nextInt();
            int start_y = sc.nextInt();

            int target_x = sc.nextInt();
            int target_y = sc.nextInt();

            int[] start = {start_x, start_y};
            int[] target = {target_x, target_y};

            System.out.println(bfs(start, target));
        }
    }

    static int bfs(int[] start, int[] target) {
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[len][len];
        queue.addLast(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] pos = queue.pollFirst();
            int x = pos[0];
            int y = pos[1];
            int count = pos[2];

            if (x == target[0] && y == target[1]) {
                return count;
            }

            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < len && ny >= 0 && ny < len) {
                    if (!visited[nx][ny]) {
                        queue.addLast(new int[]{nx, ny, count + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return -1;
    }
}