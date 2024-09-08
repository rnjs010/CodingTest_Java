import java.io.*;
import java.util.*;

class Solution {
    static int N, K, ans;
    static int[][] board, visit;
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int high = 0;
            board = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    high = Math.max(high, board[i][j]);
                }
            }

            ans = 0;
            visit = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == high) {
                        visit[i][j] = 1;
                        dfs(i, j, 1, 1);
                        visit[i][j] = 0;
                    }
                }
            }

            System.out.println("#" + t + " " + ans);
        }
    }

    public static void dfs(int x, int y, int cnt, int cut) {
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k], ny = y + dy[k];
            if (0 <= nx && nx < N && 0 <= ny && ny < N && visit[nx][ny] == 0) {
                if (board[nx][ny] < board[x][y]) {
                    visit[nx][ny] = 1;
                    dfs(nx, ny, cnt + 1, cut);
                    visit[nx][ny] = 0;
                }
                else if (cut == 1) {
                    for (int c = 1; c <= K; c++) {
                        if (board[nx][ny] - c < board[x][y]) {
                            board[nx][ny] -= c;
                            dfs(nx, ny, cnt + 1, 0);
                            board[nx][ny] += c;
                        }
                    }
                }
            }
        }

        ans = Math.max(ans, cnt);
    }
}