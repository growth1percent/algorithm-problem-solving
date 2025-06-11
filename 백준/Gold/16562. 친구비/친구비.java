import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] rank;
    static int[] price;
    static int N, M, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        rank = new int[N + 1];
        price = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            union(v, w);
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= N; i++) {
            set.add(find(i));
        }

        int sum = 0;

        for (int root : set) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                if (find(i) == root) {
                    min = Math.min(min, price[i]);
                }
            }
            sum += min;
        }

        System.out.println(sum <= k ? sum : "Oh no");
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

        if (rank[aRoot] < rank[bRoot]) {
            parent[aRoot] = bRoot;
        } else {
            parent[bRoot] = aRoot;
            if (rank[aRoot] == rank[bRoot]) {
                rank[aRoot]++;
            }
        }
    }
}