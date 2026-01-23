import java.util.*;

class Solution {
    int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    int n, m;
    char[][] map;
    boolean[][] visit;
    
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        visit = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && map[i][j] != 'X') {
                    System.out.println(i + " " + j + " 값" + map[i][j]);
                    arr.add(bfs(i, j));
                }
            }
        }
        
        int len = arr.size();
        if (len == 0) return new int[] {-1};
        
        Collections.sort(arr);
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
    
    public int bfs(int x, int y) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {x, y});
        visit[x][y] = true;
        int cnt = map[x][y] - '0';
        
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (0 > nx || nx >= n || 0 > ny || ny >= m) continue;
                if (visit[nx][ny] || map[nx][ny] == 'X') continue;
                cnt += map[nx][ny] - '0';
                dq.offer(new int[] {nx, ny});
                visit[nx][ny] = true;
                System.out.println(nx + " " + ny + " " + cnt);
            }
        }
        
        return cnt;
    }
}