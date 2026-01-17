import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int v, cost;
        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    
    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] graph;
    static int[] dist;
    
    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] r: road) {
            graph[r[0]].add(new Node(r[1], r[2]));
            graph[r[1]].add(new Node(r[0], r[2]));
        }
        
        dijkstra(1);
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }

        return answer;
    }
    
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.v]) continue;
            
            for (Node next: graph[cur.v]) {
                int newD = cur.cost + next.cost;
                if (dist[next.v] > newD) {
                    dist[next.v] = newD;
                    pq.offer(new Node(next.v, newD));
                }
            }            
        }
    }
}