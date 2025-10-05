import java.util.*;

class Solution {
    static int[] dx = {1, 0, 0, -1}, dy = {0, -1, 1, 0};
    static char[] dir = {'d', 'l', 'r', 'u'};
    static int N, M, R, C, K;
    static String answer = "impossible";
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n; M = m; K = k;
        R = r - 1; C = c - 1;
        dfs(x - 1, y - 1, 0, new StringBuilder());
        return answer;
    }
    
    static void dfs(int x, int y, int depth, StringBuilder path) {
        if (!answer.equals("impossible")) return;
        
        int dist = Math.abs(x - R) + Math.abs(y - C);
        if (dist > K - depth) return;
        if ((K - depth - dist) % 2 != 0) return;
        
        if (depth == K) {
            if (x == R && y == C) answer = path.toString();
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            path.append(dir[i]);
            dfs(nx, ny, depth + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
        
    }
}