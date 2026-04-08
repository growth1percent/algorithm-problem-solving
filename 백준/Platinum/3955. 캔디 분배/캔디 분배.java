import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long K = Integer.parseInt(st.nextToken());
            long C = Integer.parseInt(st.nextToken());

            long gcd = gcd(K, C);

            if (gcd != 1) {
                bw.write("IMPOSSIBLE" + "\n");
            } else {
                long[] ret = Execute(K, C);

                long y = ret[1];

                y = (y % K + K) % K;

                if (y == 0) y += K;

                while (C * y <= K) {
                    y += K;
                }

                if (y > 1000000000L) {
                    bw.write("IMPOSSIBLE\n");
                } else {
                    bw.write(y + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }

    static long[] Execute(long a, long b) {
        long[] ret = new long[2];
        if (b == 0) {
            ret[0] = 1; ret[1] = 0;
            return ret;
        }
        long q = a / b;
        long[] v = Execute(b, a % b);
        ret[0] = v[1];
        ret[1] = v[0] - v[1] * q;
        return ret;
    }

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}
