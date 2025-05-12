import java.util.*;

public class Main {
    static int m,n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] ground;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int count = 0;
            m = sc.nextInt();
            n = sc.nextInt();
            int pNum = sc.nextInt();

            ground = new int[n][m];
            visited = new boolean[n][m];

            int startX = sc.nextInt();
            int startY = sc.nextInt();

            ground[startY][startX] = 1;

            for (int j = 1; j < pNum; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                ground[y][x] = 1;
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (ground[j][k] == 1 && !visited[j][k]) {
                        dfs(j, k);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void dfs(int startY, int startX) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{startY, startX});

        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            int y = pos[0];
            int x = pos[1];

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (ground[ny][nx] == 1 && !visited[ny][nx]) {
                        stack.push(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }
}