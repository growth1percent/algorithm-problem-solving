import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int num_result = a + b - c;

        String str_a = String.valueOf(a);
        String str_b = String.valueOf(b);

        String sum = str_a + str_b;
        int num_sum = Integer.parseInt(sum);
        int result = num_sum - c;

        System.out.println(num_result);
        System.out.println(result);
    }
}