import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static class Star {
        double x;
        double y;

        Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Edge implements Comparable<Edge> {
        int from, to;
        double weight;

        Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Double.compare(this.weight, other.weight);
        }
    }
    static int n;
    static int[] parent;
    static List<Edge> edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        edges = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        List<Star> stars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            stars.add(new Star(x, y));
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) continue;
                Star star_from = stars.get(i);
                Star star_to = stars.get(j);

                double x = star_to.x - star_from.x;
                double y = star_to.y - star_from.y;

                double weight = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

                edges.add(new Edge(i, j, weight));
            }
        }

        Collections.sort(edges);

        double sum = 0;
        for (Edge e : edges) {
            if (find(e.from) != find(e.to)) {
                union(e.from, e.to);
                sum += e.weight;
            }
        }

        System.out.printf("%.2f\n", sum);
    }
    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot != bRoot) {
            parent[bRoot] = aRoot;
        }
    }
}