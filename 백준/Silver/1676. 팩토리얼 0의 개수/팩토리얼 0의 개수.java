import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 5; i <= N; i *= 5) {
            count += N / i;
        }

        System.out.println(count);
    }
}