import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Set<Character> set;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        set = new HashSet<>();

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = s.charAt(j);
            }
        }

        set.add(graph[0][0]);
        dfs(0, 0, 1);
        System.out.println(max);
    }

    static void dfs(int row, int col, int dist) {
        max = Math.max(max, dist);

        for (int d = 0; d < 4; d++) {
            int nRow = row + dy[d];
            int nCol = col + dx[d];

            if (nRow >= 0 && nRow < R && nCol >= 0 && nCol < C) {
                char nextChar = graph[nRow][nCol];
                if (!set.contains(nextChar)) {
                    set.add(nextChar);
                    dfs(nRow, nCol, dist + 1);
                    set.remove(nextChar);
                }
            }
        }
    }
}