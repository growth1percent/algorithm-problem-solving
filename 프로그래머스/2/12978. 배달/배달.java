import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int index;
        int cost;
        
        Node (int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
    
    static List<List<Node>> graph;
    static final int INF = Integer.MAX_VALUE;
    static int[] dist;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        graph = new ArrayList<>();
        dist = new int[N + 1];
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            dist[i] = INF;
        }
        
        for (int i = 0; i < road.length; i++) {
            int u = road[i][0];
            int v = road[i][1];
            int w = road[i][2];
            
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }
        
        dijkstra(1);

        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            
            if (current.cost > dist[current.index]) continue;
            
            for (Node neighbor : graph.get(current.index)) {
                int newCost = current.cost + neighbor.cost;
                
                if (newCost < dist[neighbor.index]) {
                    pq.offer(new Node(neighbor.index, newCost));
                    dist[neighbor.index] = newCost;
                }
            }
        }
    }
}