import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            Map<String, Integer> clothes = new HashMap<>();
            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();

                clothes.put(type, clothes.getOrDefault(type, 0) + 1);
            }

            int result = 1;
            for (int count : clothes.values()) {
                result *= (count + 1);
            }

            System.out.println(result - 1);
        }
    }
}