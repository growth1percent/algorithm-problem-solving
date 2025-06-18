import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int k, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());

            int[][] array = new int[k + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                array[0][i] = i;
            }

            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    for (int k = j; k > 0; k--) {
                        array[i][j] += array[i-1][k];
                    }
                }
            }

            System.out.println(array[k][n]);
        }
    }
}