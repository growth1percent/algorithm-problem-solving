import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (true) {
            if (queue.size() == 1) break;

            queue.pollFirst();
            int n = queue.pollFirst();

            queue.add(n);
        }

        int result = queue.pollFirst();

        System.out.println(result);
    }
}