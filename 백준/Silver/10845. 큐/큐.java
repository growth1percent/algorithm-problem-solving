import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            if (s[0].equals("push")) {
                int target = Integer.parseInt(s[1]);
                queue.addLast(target);
            } else if (s[0].equals("front")) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.getFirst());
                } else {
                    System.out.println(-1);
                }
            } else if (s[0].equals("back")) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.getLast());
                } else {
                    System.out.println(-1);
                }
            } else if (s[0].equals("size")) {
                System.out.println(queue.size());
            } else if (s[0].equals("empty")) {
                if (queue.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (s[0].equals("pop")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.pollFirst());
                }
            } else {
                System.out.println("wrong");
            }
        }
    }
}