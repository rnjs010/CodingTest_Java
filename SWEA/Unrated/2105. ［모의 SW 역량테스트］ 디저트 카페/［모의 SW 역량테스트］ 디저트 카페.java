import java.io.*;
import java.util.*;

class Solution {
    static int N, map[][], res, startX, startY;
    static boolean isAte[];
    static int[] dx = {1, 1, -1, -1}, dy = {1, -1, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            res = -1;
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            for (int i = 0; i < N - 2; i++) {
                for (int j = 1; j < N - 1; j++) {
                    isAte = new boolean[101];
                    isAte[map[i][j]] = true;
                    startX = i;
                    startY = j;

                    go(i, j, -1, -1, 0, 0);
                }
            }
            
            System.out.println("#" + tc + " " + res);
        }

    }
    
    private static void go(int x, int y, int prevX, int prevY, int cnt, int sd) {
        for (int d = sd; d < 4; d++) {
            int xx = x + dx[d];
            int yy = y+ dy[d];
          
            if(xx < 0 || yy < 0 || xx >= N || yy >= N) continue;
            if(xx == prevX && yy == prevY) continue;
            if(xx == startX && yy == startY) {
                res = Math.max(res, cnt + 1);
                return;
            }

            if(isAte[map[xx][yy]]) continue;
            isAte[map[xx][yy]] = true;
            go(xx, yy, x, y, cnt + 1, d);
            isAte[map[xx][yy]] = false;
        }

    }
}