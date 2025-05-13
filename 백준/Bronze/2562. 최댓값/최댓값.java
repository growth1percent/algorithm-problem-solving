import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int idx = 1;
        int max_idx = 0;

        while (sc.hasNextInt()) {
            int target = sc.nextInt();

            if (target > max) {
                max = target;
                max_idx = idx;
            }

            idx++;
        }

        System.out.println(max);
        System.out.print(max_idx);
    }
}

