import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        double sum = 0;
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            array[i] = n;
            max = Math.max(max, n);
        }

        double[] change = new double[N];

        for (int i = 0; i < N; i++) {
            change[i] = ((double) array[i] / max) * 100;
            sum += change[i];
        }

        double result = sum / N;

        System.out.println(result);
    }
}