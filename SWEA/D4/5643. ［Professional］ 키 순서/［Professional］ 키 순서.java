import java.io.*;
import java.util.*;

class Solution {
    static int N, M, tall, small, ans;
    static int[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            graph = new int[N+1][N+1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a][b] = 1;
            }

            ans = 0;
            for (int i = 1; i <= N; i++) {
                tall = 0; small = 0;
                tall_cnt(i, new boolean[N+1]);
                small_cnt(i, new boolean[N+1]);
                if (tall + small == N-1) ans++;
            }

            System.out.println("#" + t + " " + ans);
        }
    }

    public static void tall_cnt(int n, boolean[] visit) {
        visit[n] = true;
        for (int i = 1; i <= N; i++) {
            if (!visit[i] && graph[n][i] == 1) {
                tall_cnt(i, visit);
                tall++;
            }
        }
    }

    public static void small_cnt(int n, boolean[] visit) {
        visit[n] = true;
        for (int i = 1; i <= N; i++) {
            if (!visit[i] && graph[i][n] == 1) {
                small_cnt(i, visit);
                small++;
            }
        }
    }
}