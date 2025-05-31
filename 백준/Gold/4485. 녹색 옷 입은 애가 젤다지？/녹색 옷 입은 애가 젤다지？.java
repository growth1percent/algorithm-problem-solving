import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        Node (int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int idx = 1;
        while (num != 0) {
            int[][] map = new int[num][num];
            int[][] dist = new int[num][num];

            for (int i = 0; i < num; i++) {
                String[] array = br.readLine().split(" ");
                for (int j = 0; j < array.length; j++) {
                    map[i][j] = Integer.parseInt(array[j]);
                    dist[i][j] = INF;
                }
            }

            dijkstra(map, dist);
            int result = dist[num - 1][num - 1];
            System.out.println("Problem " + idx + ": " + result);

            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            idx++;
        }
    }

    static void dijkstra(int[][] map, int[][] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, map[0][0]));
        dist[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.cost > dist[current.x][current.y]) continue;

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map.length) {
                    int newCost = dist[current.x][current.y] + map[nx][ny];
                    if (newCost < dist[nx][ny]) {
                        pq.offer(new Node(nx, ny, newCost));
                        dist[nx][ny] = newCost;
                    }
                }
            }
        }
    }
}