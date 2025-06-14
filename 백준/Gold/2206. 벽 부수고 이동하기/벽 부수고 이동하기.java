import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M][2];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] array = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(array[j]);
            }
        }

        int dist = bfs(0, 0);

        if (dist == -1) {
            System.out.println(-1);
            return;
        }
        System.out.println(dist);
    }
    static int bfs(int startY, int startX) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[] {startY, startX, 0, 1});
        visited[startY][startX][0] = true;

        while (!queue.isEmpty()) {
            int[] target = queue.pollFirst();
            int y = target[0];
            int x = target[1];
            int isBreak = target[2];
            int dist = target[3];

            if (y == N - 1 && x == M - 1) {
                return dist;
            }

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (map[ny][nx] == 0 && !visited[ny][nx][isBreak]) {
                        visited[ny][nx][isBreak] = true;
                        queue.addLast(new int[] {ny, nx, isBreak, dist + 1});
                    } else if (isBreak == 0 && map[ny][nx] == 1 && !visited[ny][nx][1]) {
                        visited[ny][nx][1] = true;
                        queue.addLast(new int[] {ny, nx, 1, dist + 1});
                    }
                }
            }
        }

        return -1;
    }
}