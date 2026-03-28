class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] map = new boolean[n + 1][n + 1];
        for (int[] res: results) {
            map[res[0]][res[1]] = true;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][k] && map[k][j]) {
                        map[i][j] = true;
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int win = 0, lose = 0;
            for (int j = 1; j <= n; j++) {
                if (map[i][j]) win++;
                if (map[j][i]) lose++;
            }
            if (win + lose == (n - 1)) answer++;
        }
        
        return answer;
    }
}