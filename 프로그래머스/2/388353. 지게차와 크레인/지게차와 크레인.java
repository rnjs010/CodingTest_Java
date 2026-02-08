import java.util.*;

class Solution {
    int n, m;
    boolean[][] visit;
    char[][] map;
    int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    
    public int solution(String[] storage, String[] requests) {            
        n = storage.length;
        m = storage[0].length();
        visit = new boolean[n + 2][m + 2];
        map = new char[n + 2][m + 2];
        
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(map[i], 'a');
            Arrays.fill(visit[i], true);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i + 1][j + 1] = storage[i].charAt(j);
                visit[i + 1][j + 1] = false;
            }
        }
        
        for (String req: requests) {
            char target = req.charAt(0);
            
            if (req.length() == 2) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (map[i][j] == target) {
                            visit[i][j] = true;
                        }
                    }
                }
            } else {
                bfs(target);
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(!visit[i][j]) answer++;
            }
        }
        return answer;
    }
    
    private void bfs(char target) {
        boolean[][] seen = new boolean[n + 2][m + 2];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {0, 0});
        seen[0][0] = true;
        
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (0 > nx || (n + 2) <= nx || 0 > ny || (m + 2) <= ny) continue;
                if (seen[nx][ny]) continue;
                
                seen[nx][ny] = true;
                if (visit[nx][ny]) {
                    dq.offer(new int[] {nx, ny});
                } else if (map[nx][ny] == target) {
                    visit[nx][ny] = true;
                }
            }
        }
    }
}