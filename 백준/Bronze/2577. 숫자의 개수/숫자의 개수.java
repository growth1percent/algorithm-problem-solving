import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int mul = a * b * c;
        String mul_str = String.valueOf(mul);
        String[] array = mul_str.split("");

        int[] times = new int[10];

        for (int i = 0; i < mul_str.length(); i++) {
            int num = Integer.parseInt(array[i]);
            times[num]++;
        }

        for (int i = 0; i <= 9; i++) {
            System.out.println(times[i]);
        }
    }
}