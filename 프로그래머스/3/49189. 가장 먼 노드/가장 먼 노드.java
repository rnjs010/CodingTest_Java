// 레벨 BFS → 마지막 level size = answer
import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] e: edge) {
            int a = e[0], b = e[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        Queue<Integer> dq = new ArrayDeque<>();
        boolean[] visit = new boolean[n + 1];
        dq.offer(1);
        visit[1] = true;
        
        int answer = 0;
        while (!dq.isEmpty()) {
            int size = dq.size();
            answer = size;
            
            for (int i = 0; i < size; i++) {
                int cur = dq.poll();
                for (int next: graph[cur]) {
                if (!visit[next]) {
                    visit[next] = true;
                    dq.offer(next);
                    }
                }
            }
        }
        
        return answer;
    }
    
    
}