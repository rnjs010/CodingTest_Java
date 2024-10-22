import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N+1][N+1];
        int[][] dist2 = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            dist[i][i] = 1;
            dist2[i][i] = 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = 1;
            dist2[b][a] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][k] == 1 && dist[k][j] == 1) {
                        dist[i][j] = 1;
                    }
                    if (dist2[i][k] == 1 && dist2[k][j] == 1) {
                        dist2[i][j] = 1;
                    }
                }
            }
        }

        int cnt = 0;
        boolean chk;
        for (int i = 1; i <= N; i++) {
            chk = true;
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] == 0 && dist2[i][j] == 0) {
                    chk = false;
                    break;
                }
            }
            if (chk) cnt++;

        }

        System.out.println(cnt);
    }
}