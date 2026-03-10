import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] e: edge) {
            int a = e[0], b = e[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Deque<Integer> dq = new ArrayDeque<>();
        dist[1] = 0;
        dq.addLast(1);
        
        int val = 0;
        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();
            for (int next: graph[cur]) {
                if (dist[next] == Integer.MAX_VALUE) {
                    dist[next] = dist[cur] + 1;
                    val = Math.max(dist[next], val);
                    dq.addLast(next);
                }
            }
        }
        
        int answer = 0;
        for (int d: dist) {
            if (d == val) answer++;
        }
        
        return answer;
    }
    
    
}