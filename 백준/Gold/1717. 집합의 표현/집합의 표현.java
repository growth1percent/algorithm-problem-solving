import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] rank;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (num == 1) {
                System.out.println(find(a) == find(b) ? "YES" : "NO");
            }

            if (num == 0) {
                union(a, b);
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