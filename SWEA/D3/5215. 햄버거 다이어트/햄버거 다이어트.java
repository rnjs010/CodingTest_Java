import java.io.*;
import java.util.*;

class Solution {
    static int N, L;
    static int[][] li;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            li = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                li[i][0] = Integer.parseInt(st.nextToken());
                li[i][1] = Integer.parseInt(st.nextToken());
            }

            ans = 0;
            dfs(0, 0, 0);
            System.out.println("#" + t + " " + ans);
        }
    }

    public static void dfs(int idx, int cal, int like) {
        if (idx == N) {
            if (cal <= L) ans = Math.max(ans, like);
            return;
        }
        dfs(idx + 1, cal, like);
        dfs(idx + 1, cal + li[idx][1], like + li[idx][0]);
    }
}