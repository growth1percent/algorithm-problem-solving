import java.util.*;

public class Main {
    static int n, m;
    static int[][] graph;
    static int maxSafeArea = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        dfs(0);
        System.out.println(maxSafeArea);
    }

    static void dfs(int count) {
        if (count == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                    dfs(count + 1);
                    graph[i][j] = 0;
                }
            }
        }
    }

    static void spreadVirus() {
        int[][] temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            temp[i] = graph[i].clone();
        }

        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 2) {
                    queue.addLast(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.pollFirst();
            int x = pos[0];
            int y = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (temp[nx][ny] == 0) {
                        temp[nx][ny] = 2;
                        queue.addLast(new int[]{nx, ny});
                    }
                }
            }
        }

        countSafeArea(temp);
    }

    static void countSafeArea(int[][] temp) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j =0; j < m; j++) {
                if (temp[i][j] == 0) {
                    count++;
                }
            }
        }

        maxSafeArea = Math.max(maxSafeArea, count);
    }
}

