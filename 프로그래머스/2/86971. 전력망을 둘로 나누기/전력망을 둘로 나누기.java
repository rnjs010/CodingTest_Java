import java.util.*;

class Solution {
    List<Integer>[] graph;
    int answer, n;
    
    public int solution(int n, int[][] wires) {
        this.n = n;
        answer = Integer.MAX_VALUE;
        
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] w: wires) {
            graph[w[0]].add(w[1]);
            graph[w[1]].add(w[0]);
        }
        
        dfs(1, 0);
        
        return answer;
    }
    
    int dfs(int cur, int parent) {
        int size = 1;
        
        for (int next: graph[cur]) {
            if (next == parent) continue;
            int childSize = dfs(next, cur);
            
            answer = Math.min(answer, Math.abs(n - 2 * childSize));
            
            size += childSize;
        }
        
        return size;
    }
}