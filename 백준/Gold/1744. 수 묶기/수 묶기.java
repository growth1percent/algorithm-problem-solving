import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int zero = 0;
        int one = 0;

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();

            if (num > 1) {
                plusPq.add(num);
            } else if (num == 1) {
                one++;
            } else if (num == 0) {
                zero++;
            } else {
                minusPq.add(num);
            }
        }

        int sum = 0;

        while (plusPq.size() > 1) {
            int num1 = plusPq.remove();
            int num2 = plusPq.remove();

            sum += num1 * num2;
        }

        if (!plusPq.isEmpty()) {
            sum += plusPq.remove();
        }

        sum += one;

        while (minusPq.size() > 1) {
            int num1 = minusPq.remove();
            int num2 = minusPq.remove();

            sum += num1 * num2;
        }

        if (!minusPq.isEmpty()) {
            if (zero == 0) {
                sum += minusPq.remove();
            }
        }

        System.out.println(sum);
    }
}
