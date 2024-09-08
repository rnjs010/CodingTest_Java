import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board, ans;
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = 0;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            tc++;

            board = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(ans[i], Integer.MAX_VALUE);
            }
            bfs(0, 0);
            System.out.println("Problem" + " " + tc + ":" + " " + ans[N-1][N-1]);
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        ans[x][y] = board[x][y];
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k], ny = cur[1] + dy[k];
                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (ans[nx][ny] > board[nx][ny] + ans[cur[0]][cur[1]]) {
                        ans[nx][ny] = board[nx][ny] + ans[cur[0]][cur[1]];
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}