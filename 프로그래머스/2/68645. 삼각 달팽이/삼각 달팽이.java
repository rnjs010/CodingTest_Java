class Solution {
    public int[] solution(int n) {        
        int[][] arr = new int[n][n];
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        
        int x = 0, y = 0, dir = 0;
        int num = 1;
        
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                arr[x][y] = num++;
                if (j == i - 1) break;
                x += dx[dir];
                y += dy[dir];
            }
            dir = (dir + 1) % 3;
            x += dx[dir];
            y += dy[dir];
        }
        
        int[] answer = new int[n * (n + 1) / 2];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = arr[i][j];
            }
        }
        
        return answer;
    }
}