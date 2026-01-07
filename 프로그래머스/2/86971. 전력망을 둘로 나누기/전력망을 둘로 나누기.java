import java.util.*;

class Solution {
    List<Integer>[] graph;
    int cnt;
    
    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] w: wires) {
            graph[w[0]].add(w[1]);
            graph[w[1]].add(w[0]);
        }
        
        int answer = Integer.MAX_VALUE;
        
        for (int[] w: wires) {
            boolean[] visit = new boolean[n + 1];
            cnt = 0;
            
            dfs(w[0], visit, w[0], w[1]);
            answer = Math.min(answer, Math.abs(n - 2 * cnt));
        }
        
        return answer;
    }
    
    void dfs(int cur, boolean[] visit, int cutA, int cutB) {
        visit[cur] = true;
        cnt++;
        
        for (int next: graph[cur]) {
            if (visit[next]) continue;
            
            if ((cur == cutA && next == cutB) || (cur == cutB && next == cutA)) continue;
            
            dfs(next, visit, cutA, cutB);
        }
    }
}