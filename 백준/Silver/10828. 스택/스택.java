import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            if (s[0].equals("push")) {
                int target = Integer.parseInt(s[1]);
                stack.push(target);
            } else if (s[0].equals("top")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.peek());
                } else {
                    System.out.println(-1);
                }
            } else if (s[0].equals("size")) {
                System.out.println(stack.size());
            } else if (s[0].equals("empty")) {
                if (stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (s[0].equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
            } else {
                System.out.println("wrong");
            }
        }
    }
}