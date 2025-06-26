import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int num = 1;
        int idx = 0;

        while (idx < n) {
            if (stack.isEmpty() || stack.peek() < array[idx]) {
                stack.push(num++);
                sb.append("+\n");
            } else if (stack.peek() == array[idx]) {
                stack.pop();
                sb.append("-\n");
                idx++;
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb);
    }
}