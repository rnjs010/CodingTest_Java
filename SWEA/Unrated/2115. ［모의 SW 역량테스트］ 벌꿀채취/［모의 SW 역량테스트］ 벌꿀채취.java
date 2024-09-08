import java.io.*;
import java.util.*;

class Solution {
    static int N, M, C, max_money;
    static int[][] board, memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            board = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            memo = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N-M; j++) {
                    max_money = 0;
                    dfs(0, 0, 0, i, j);
                    memo[i][j] = max_money;
                }
            }

            int ans = 0;
            for (int i1 = 0; i1 < N; i1++) {
                for (int j1 = 0; j1 <= N-M; j1++) {
                    for (int i2 = 0; i2 < N; i2++) {
                        int s = (i1 == i2) ? j1 + M : 0;
                        for (int j2 = s; j2 <= N-M; j2++) {
                            ans = Math.max(ans, memo[i1][j1] + memo[i2][j2]);
                        }
                    }
                }
            }

            System.out.println("#" + t + " " + ans);
        }
    }

    public static void dfs(int m, int sum, int money, int i, int j) {
        if (sum > C) return;
        if (m == M) {
            max_money = Math.max(max_money, money);
            return;
        }
        dfs(m + 1, sum + board[i][j + m], money + (int) Math.pow(board[i][j + m], 2), i, j);
        dfs(m + 1, sum, money, i, j);
    }
}