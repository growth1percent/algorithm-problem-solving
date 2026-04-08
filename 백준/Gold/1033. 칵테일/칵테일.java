import java.util.*;
import java.io.*;

public class Main {
    static List<cNode>[] graph;
    static boolean[] visited;
    static long[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N];
        visited = new boolean[N];
        D = new long[N];

        long lcm = 1;

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            graph[a].add(new cNode(b, p, q));
            graph[b].add(new cNode(a, q, p));

            lcm *= (p * q / gcd(p, q));
        }

        D[0] = lcm;

        DFS(0);

        long mgcd = D[0];

        for (int i = 1; i < N; i++) {
            mgcd = gcd(mgcd, D[i]);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(D[i] / mgcd + " ");
        }
    }
    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    static void DFS(int node) {
        visited[node] = true;

        for (cNode c : graph[node]) {
            int next = c.b;
            int p = c.p;
            int q = c.q;
            if (!visited[next]) {
                D[next] = D[node] * q / p;
                DFS(next);
            }
        }
    }
}

class cNode {
    int b;
    int p;
    int q;

    cNode(int b, int p, int q) {
        this.b = b;
        this.p = p;
        this.q = q;
    }
}
