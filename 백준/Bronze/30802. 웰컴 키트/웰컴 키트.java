import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, T, P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int t_bundle = 0;

        String[] s = br.readLine().split(" ");

        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        for (int i = 0; i < s.length; i++) {
            int target = Integer.parseInt(s[i]);
            while (true) {
                if (target == 0) {
                    break;
                }

                t_bundle++;
                if (target <= T) {
                    break;
                } else {
                    target -= T;
                }
            }
        }

        int p_bundle = N / P;
        int p_mod = N % P;

        System.out.println(t_bundle);
        System.out.println(p_bundle + " " + p_mod);
    }
}