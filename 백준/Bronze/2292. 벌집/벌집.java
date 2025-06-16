import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int n = 1;
        int idx = 1;

        if (N == 1) {
            System.out.println(1);
        } else {
            while (n < N) {
                n = n + idx * 6;
                idx++;
            }
            System.out.println(idx);
        }
    }
}