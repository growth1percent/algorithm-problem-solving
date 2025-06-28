import java.io.*;
import java.util.*;

public class Main {
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        set = new HashSet<>();
        Set<Integer> set_all = new HashSet<>();

        int test_num = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 20; i++) {
            set_all.add(i);
        }

        for (int t = 0; t < test_num; t++) {
            String[] s = br.readLine().split(" ");

            if (s[0].equals("add")) {
                add(Integer.parseInt(s[1]));
            } else if (s[0].equals("remove")) {
                remove(Integer.parseInt(s[1]));
            } else if (s[0].equals("check")) {
                int result = check(Integer.parseInt(s[1]));
                bw.write(result + "\n");
            } else if (s[0].equals("toggle")) {
                toggle(Integer.parseInt(s[1]));
            } else if (s[0].equals("all")) {
                set.clear();
                set.addAll(set_all);
            } else if (s[0].equals("empty")) {
                set = new HashSet<>();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void add(int num) {
        set.add(num);
    }
    static void remove(int num) {
        set.remove(num);
    }
    static int check(int num) {
        if (set.contains(num)) {
            return 1;
        } else {
            return 0;
        }
    }
    static void toggle(int num) {
        if (set.contains(num)) {
            set.remove(num);
        } else {
            set.add(num);
        }
    }
}