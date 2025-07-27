class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int d = 0, x = 0, y = 0;
        answer[0][0] = 1;
        int num = 2;
        while (true) {
            if (num > n*n) break;
            int nx = x + dx[d % 4];
            int ny = y + dy[d % 4];
            if (0 <= nx && nx < n && 0 <= ny && ny < n && answer[nx][ny] == 0) {
                answer[nx][ny] = num;
                x = nx;
                y = ny;
                num += 1;
            } else {
                d += 1;
            }
        }
        
        return answer;
    }
}