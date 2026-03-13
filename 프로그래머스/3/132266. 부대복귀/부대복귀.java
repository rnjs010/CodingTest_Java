import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] r: roads) {
            graph[r[0]].add(r[1]);
            graph[r[1]].add(r[0]);
        }
        
        int[] dist = new int[n + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        Arrays.fill(dist, -1);
        dq.offer(destination);
        dist[destination] = 0;
        
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            for (int next: graph[cur]) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    dq.offer(next);
                }
            }
        }
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        return answer;
    }
}