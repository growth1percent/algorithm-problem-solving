import java.util.*;

public class Main {
    static int n;
    static boolean[][] visited;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> houseCounts = new ArrayList<>();
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n][n];

        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.next(); // 한 줄 전체 입력 받기
            for (int j = 0; j < n; j++) {
                graph[i][j] = line.charAt(j) - '0'; // 각 문자 숫자로 변환
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    int houseCount = dfs(i, j);
                    houseCounts.add(houseCount);
                    answer++;
                }
            }
        }

        Collections.sort(houseCounts);
        System.out.println(answer);
        for (int count : houseCounts) {
            System.out.println(count);
        }
    }

    static int dfs(int startX, int startY) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{startX, startY});
        visited[startX][startY] = true;
        int houseCount = 1;

        while (!stack.isEmpty()) {
            int[] node = stack.pop();
            int x = node[0];
            int y = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!visited[nx][ny] && graph[nx][ny] == 1) {
                        stack.push(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        houseCount++;
                    }
                }
            }
        }

        return houseCount;
    }
}

