import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        int num = sc.nextInt();
        String target = sc.next();
        String[] array = target.split("");

        for (int i = 0; i < num; i++) {
            sum += Integer.parseInt(array[i]);
        }

        System.out.print(sum);
    }
}

