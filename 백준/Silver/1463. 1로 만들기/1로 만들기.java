import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{N , 0});
        int result = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.pollFirst();
            int num = current[0];
            int count = current[1];

            if (num == 1) {
                result = count;
                break;
            }

            if (num % 3 == 0) {
                queue.addLast(new int[] {num / 3, count + 1});
            }

            if (num % 2 == 0) {
                queue.addLast(new int[] {num / 2, count + 1});
            }

            queue.addLast(new int[] {num - 1, count + 1});
        }

        System.out.println(result);
    }
}