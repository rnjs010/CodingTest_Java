import java.io.*;
import java.util.*;

class Solution {
    public static int N, W, H, ans;
    public static int[][] map, copy;
    public static int[] nums;
    public static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            copy = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = copy[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            nums = new int[N];
            ans = Integer.MAX_VALUE;

            perm(0);
            System.out.println("#" + tc + " " + ans);
        }
    }

    public static void perm(int cnt) {
        if (cnt == N) {
            shoot(nums);
            count();
            reset();
            return;
        }

        for (int i = 0; i < W; i++) {
            nums[cnt] = i;
            perm(cnt + 1);
        }
    }

    public static void shoot(int[] nums) {
        int x = 0, y = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < H; j++) {
                if (map[j][nums[i]] != 0) {
                    x = j;
                    y = nums[i];
                    break;
                }
            }
            bfs(x, y);
            down();
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {x, y, map[x][y]});
        map[x][y] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pow = cur[2];
            for (int i = 1; i < pow; i++) {
                for (int d = 0; d < 4; d++) {
                    int nx = cur[0] + dx[d] * i;
                    int ny = cur[1] + dy[d] * i;
                    if (0 <= nx && nx < H && 0 <= ny && ny < W && map[nx][ny] != 0) {
                        q.add(new int[] {nx, ny, map[nx][ny]});
                        map[nx][ny] = 0;
                    }
                }
            }
        }
    }

    public static void down() {
        for (int i = 0; i < W; i++) {
            Stack<Integer> s = new Stack<>();
            for (int j = 0; j < H; j++) {
                if (map[j][i] != 0) {
                    s.add(map[j][i]);
                }
            }

            for (int j = H-1; j >= 0; j--) {
                if (s.isEmpty()) map[j][i] = 0;
                else map[j][i] = s.pop();
            }
        }
    }

    public static void count() {
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] != 0) {
                    cnt++;
                }
            }
        }
        ans = Math.min(ans, cnt);
    }

    public static void reset() {
        for (int i = 0; i < H; i++){
            for (int j = 0; j < W; j++) {
                map[i][j] = copy[i][j];
            }
        }
    }
}