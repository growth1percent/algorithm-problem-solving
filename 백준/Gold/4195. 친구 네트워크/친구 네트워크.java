import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] size;
    static int T, F;
    static Map<String, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            F = Integer.parseInt(br.readLine());
            parent = new int[F * 2];
            size = new int[F * 2];
            map = new HashMap<>();

            for (int i = 0; i < F * 2; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            int idx = 0;

            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!map.containsKey(a)) {
                    map.put(a, idx);
                    idx++;
                }

                if (!map.containsKey(b)) {
                    map.put(b, idx);
                    idx++;
                }

                int idx_a = map.get(a);
                int idx_b = map.get(b);

                union(idx_a, idx_b);

                System.out.println(size[find(idx_a)]);
            }
        }
    }

    static int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) return;

        parent[bRoot] = aRoot;
        size[aRoot] += size[bRoot];
    }
}