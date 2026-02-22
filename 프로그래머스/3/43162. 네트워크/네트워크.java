class Solution {
    int n;
    int[][] computers;
    boolean[] visit;
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        visit = new boolean[n];
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 && !visit[i]) {
                    answer++;
                    dfs(i, j);
                }
            }
        }
        return answer;
    }
    
    private void dfs(int x, int y) {
        visit[x] = true;
        for (int i = 0; i < n; i++) {
            if (computers[x][i] == 1 && !visit[i]) {
                dfs(i, x);
            }
        }
        return;
    }
}