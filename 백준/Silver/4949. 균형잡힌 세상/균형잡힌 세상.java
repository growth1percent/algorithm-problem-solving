import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Character> map = new HashMap<>();

        map.put(']', '[');
        map.put(')', '(');

        while (true) {
            Deque<Character> stack = new ArrayDeque<>();
            boolean isFalse = false;
            String s = br.readLine();
            if (s.equals(".")) break;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '[' || c == '(') {
                    stack.push(c);
                } else if (c == ']' || c == ')') {
                    if (!stack.isEmpty()) {
                        char target = stack.pop();
                        if (target != map.get(c)) {
                            System.out.println("no");
                            isFalse = true;
                            break;
                        }
                    } else {
                        System.out.println("no");
                        isFalse = true;
                        break;
                    }
                }
            }
            if (isFalse) continue;

            if (stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}