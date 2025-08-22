import java.io.*;
import java.util.*;

public class Main {
  static final int[] dx = {-1, 1, 0, 0};
  static final int[] dy = {0, 0, -1, 1};
  static int cnt = 0, maxVal = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] arr = new int[n][m];
    boolean[][] visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (arr[i][j] == 1 && !visited[i][j]) {
          cnt++;
          int area = 1;
          Queue<int[]> q = new LinkedList<>();
          q.offer(new int[]{i, j});
          visited[i][j] = true;

          while (!q.isEmpty()) {
            int[] pos = q.poll();
            for (int d = 0; d < 4; d++) {
              int nx = pos[0] + dx[d];
              int ny = pos[1] + dy[d];
              if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 1 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                area++;
              }
            }
          }
          maxVal = Math.max(maxVal, area);
        }
      }
    }

    System.out.print(cnt + "\n" + maxVal);
  }

}