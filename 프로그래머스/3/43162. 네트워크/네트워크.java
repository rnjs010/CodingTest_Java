class Solution {
    boolean[] visit;
    
    public int solution(int n, int[][] computers) {
        visit = new boolean[n];
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                answer++;
                dfs(i, computers);
            }
        }
        return answer;
    }
    
    private void dfs(int x, int[][] map) {
        visit[x] = true;
        for (int i = 0; i < map.length; i++) {
            if (map[x][i] == 1 && !visit[i]) {
                dfs(i, map);
            }
        }
        return;
    }
}