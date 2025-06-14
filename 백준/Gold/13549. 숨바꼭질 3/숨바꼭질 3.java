import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MAX = 100001;
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }
    static int bfs(int start, int target) {
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[MAX];
        queue.addLast(new int[] {start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.pollFirst();
            int pos = current[0];
            int time = current[1];
            int[] positions_1 = {pos - 1, pos + 1};
            int position_0 = pos * 2;

            if (pos == target) {
                return time;
            }

            if (position_0 >= 0 && position_0 < MAX && !visited[position_0]) {
                queue.addFirst(new int[] {position_0, time});
                visited[position_0] = true;
            }
            
            for (int move : positions_1) {
                if (move >= 0 && move < MAX && !visited[move]) {
                    queue.addLast(new int[] {move, time + 1});
                    visited[move] = true;
                }
            }
        }
        return -1;
    }
}