import java.io.*;
import java.util.*;

class Solution {
    static int N, board[][], sx, sy, ans;
    static boolean[] visit;
    static int[] dx = {1, 1, -1, -1}, dy = {1, -1, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            
            board = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            ans = -1;
            for (int i = 0; i < N-2; i++) {
                for (int j = 1; j < N-1; j++) {
                    visit = new boolean[101];
                    visit[board[i][j]] = true;
                    sx = i; sy = j;
                    tour(sx, sy, -1, -1, 1, 0);
                }
            }
            
            sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(ans);
            System.out.println(sb.toString());
        }
    }
    
    public static void tour(int x, int y, int px, int py, int cnt, int dir) {
        for (int d = dir; d < 4; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (nx == px && ny == py) continue;
            if (nx == sx && ny == sy) {
                ans = Math.max(ans, cnt);
                return;
            }
            int num = board[nx][ny];
            if (visit[num]) continue;
            visit[num] = true;
            tour(nx, ny, x, y, cnt + 1, d);
            visit[num] = false;
        }
    }
}