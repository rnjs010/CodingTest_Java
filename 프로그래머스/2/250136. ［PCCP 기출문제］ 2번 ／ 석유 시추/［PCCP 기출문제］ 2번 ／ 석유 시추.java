import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] visit;
    static int n, m;
    static Map<Integer, Integer> map = new HashMap<>();
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        visit = new int[n][m];
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] == 0 && land[i][j] == 1) {
                    bfs(i, j, num, land);
                    num++;
                } 
            }
        }
        
        int ans = 0;
        for (int j = 0; j < m; j++) {
            int total = 0;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (visit[i][j] != 0) set.add(visit[i][j]);
            }
            for (int s : set) {
                total += map.get(s);
            }
            ans = Math.max(ans, total);
        }
        
        return ans;
    }
    
    
    static void bfs(int x, int y, int num, int[][] land) {
        Deque<int[]> q = new ArrayDeque<>();
        int[] pos = new int[]{x, y};
        
        visit[x][y] = num;
        q.offerLast(pos);
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (land[nx][ny] == 0 || visit[nx][ny] != 0) continue;
                visit[nx][ny] = num;
                q.offerLast(new int[]{nx, ny});
                cnt++;
            }
        }
        
        map.put(num, cnt);
    }
}