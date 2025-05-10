import java.util.*;

public class Main {
    static final int MAX = 100001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int target = sc.nextInt();

        System.out.print(bfs(start, target));
    }

    static int bfs(int start, int target) {
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[MAX];
        queue.addLast(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.pollFirst();
            int pos = current[0];
            int time = current[1];
            int[] positions = {pos - 1, pos + 1, pos * 2};

            if (pos == target) {
                return time;
            }

            for (int move : positions) {
                if (move >= 0 && move < MAX && !visited[move]) {
                    queue.addLast(new int[]{move, time + 1});
                    visited[move] = true;
                }
            }

        }
        return -1;
    }
}