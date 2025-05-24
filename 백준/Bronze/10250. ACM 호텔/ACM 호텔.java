import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_num = sc.nextInt();

        for (int i = 0; i < test_num; i++) {
            int height = sc.nextInt();
            int width = sc.nextInt();
            int n = sc.nextInt();
            int result = 0;

            int y = n % height;
            int x = n / height + 1;

            if (y == 0) {
                y = height;
                x = n / height;
            }

            result = y * 100 + x;

            System.out.println(result);
        }
    }
}