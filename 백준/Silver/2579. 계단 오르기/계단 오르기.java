import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[n + 1][2]; // [i][0] -> 2칸 건너 뛰었을 때, [i][1] -> 1칸 건너 뛰었을 때

        dp[1][1] = scores[1];

        if (n >= 2) {
            dp[2][0] = scores[2];
            dp[2][1] = dp[1][1] + scores[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + scores[i];
            dp[i][1] = dp[i - 1][0] + scores[i];
        }

        int result = Math.max(dp[n][0], dp[n][1]);

        System.out.println(result);
    }
}