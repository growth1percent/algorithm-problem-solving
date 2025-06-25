import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[] rank = new int[31];

        int cut = (int) Math.round(n * 0.15);
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            rank[num]++;
            sum += num;
        }

        int removed = 0;

        for (int i = 1; i <= 30; i++) {
            while (rank[i] > 0 && removed < cut) {
                rank[i]--;
                sum -= i;
                removed++;
            }

            if (removed == cut) break;
        }

        removed = 0;

        for (int i = 30; i >= 1; i--) {
            while (rank[i] > 0 && removed < cut) {
                rank[i]--;
                sum -= i;
                removed++;
            }

            if (removed == cut) break;
        }

        int result = (int) Math.round((double) sum / (n - cut * 2));

        System.out.println(result);
    }
}