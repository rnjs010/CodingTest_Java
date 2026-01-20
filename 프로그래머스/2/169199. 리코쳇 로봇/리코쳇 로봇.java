import java.util.*;

class Solution {
    int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    char[][] map;
    int n, m;
    int RX, RY, GX, GY;
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'R') {
                    RX = i; RY = j;
                } else if (map[i][j] == 'G') {
                    GX = i; GY = j;
                }
            }
        }
        
        int answer = bfs();
        return answer;
    }
    
    public int bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        int[][] visit = new int[n][m];
        
        dq.offer(new int[] {RX, RY});
        visit[RX][RY] = 1;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            if (cur[0] == GX && cur[1] == GY) return visit[GX][GY] - 1;
            
            for (int d = 0; d < 4; d++) {
                int nx = cur[0], ny = cur[1];
                while (true) {
                    int cx = nx + dx[d];
                    int cy = ny + dy[d];
                    if (0 > cx || n <= cx || 0 > cy || m <= cy) break;
                    if (map[cx][cy] == 'D') break;
                    nx += dx[d];
                    ny += dy[d];
                }
                
                if (visit[nx][ny] == 0) {
                    visit[nx][ny] = visit[cur[0]][cur[1]] + 1;
                    dq.offer(new int[] {nx, ny});
                }
            }
        }
        return -1;
    }
}