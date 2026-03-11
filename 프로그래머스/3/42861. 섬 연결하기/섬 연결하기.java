import java.util.*;

class Solution {
    class Node implements Comparable<Node> {
        int v, c;
        Node(int v, int c) {
            this.v = v;
            this.c = c;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.c - o.c;
        }
    }
    
    public int solution(int n, int[][] costs) {
        List<Node>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] c: costs) {
            graph[c[0]].add(new Node(c[1], c[2]));
            graph[c[1]].add(new Node(c[0], c[2]));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[n];
        pq.offer(new Node(0, 0));
        int answer = 0;
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (visit[cur.v]) continue;
            visit[cur.v] = true;
            answer += cur.c;
            
            for (Node next: graph[cur.v]) {
                if (!visit[next.v]) {
                    pq.offer(new Node(next.v, next.c));
                }
            }
        }
        
        return answer;
    }
}