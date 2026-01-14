import java.util.*;

class Solution {
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static char[][] map;
    static int n, m;
    static int SX, SY, LX, LY, EX, EY;
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = maps[i].charAt(j);
                if (map[i][j] == 'S') {
                    SX = i; SY = j;
                } else if (map[i][j] == 'L') {
                    LX = i; LY = j;
                } else if (map[i][j] == 'E') {
                    EX = i; EY = j;
                }
            }
        }
        
        int toL = bfs(SX, SY, LX, LY);
        int toE = bfs(LX, LY, EX, EY);
        if (toL == -1 || toE == -1) return -1;
        return toL + toE;
    }
    
    static int bfs(int sx, int sy, int ex, int ey) {
        Queue<int[]> dq = new ArrayDeque<>();
        int[][] time = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(time[i], -1);
        }
                
        dq.offer(new int[] {sx, sy});
        time[sx][sy] = 0;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            if (cur[0] == ex && cur[1] == ey) break;
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (map[nx][ny] == 'X') continue;
                if (time[nx][ny] != -1) continue;
                time[nx][ny] = time[cur[0]][cur[1]] + 1;
                dq.offer(new int[] {nx, ny});
            }
        }
        return time[ex][ey];
    }
}