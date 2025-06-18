import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] array = br.readLine().split("");
        int sum = 0;
        int idx = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].equals("*")) {
                idx = i;
                continue;
            }
            int n = Integer.parseInt(array[i]);

            if (i % 2 == 0) {
                sum += n;
            } else {
                sum += 3 * n;
            }
        }

        int m = Integer.parseInt(array[array.length - 1]);
        int weight = (idx % 2 == 0) ? 1 : 3;

        for (int i = 0; i <= 9; i++) {
            if ((sum + i * weight + m) % 10 == 0) {
                System.out.println(i);
                break;
            }
        }

    }
}