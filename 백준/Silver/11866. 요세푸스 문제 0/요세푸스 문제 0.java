import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for (int i = 1; i <= N; i++) {
            queue.addLast(i);
        }

        while (!queue.isEmpty()) {
            int idx = 1;

            while (idx != K) {
                int current = queue.pollFirst();
                queue.addLast(current);
                idx++;
            }

            int remove = queue.pollFirst();
            if (!queue.isEmpty()) {
                sb.append(remove + ", ");
            } else {
                sb.append(remove + ">");
            }
        }

        System.out.println(sb);
    }
}