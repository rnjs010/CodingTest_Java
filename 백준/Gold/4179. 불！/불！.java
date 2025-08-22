import java.io.*;
import java.util.*;

public class Main {
  static final int[] dx = {-1, 1, 0, 0};
  static final int[] dy = {0, 0, -1, 1};
  static int time = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    Character[][] map = new Character[r][c];
    int[][] fire = new int[r][c];
    int[][] ji = new int[r][c];

    Queue<int[]> fireQueue = new LinkedList<>();
    Queue<int[]> jiQueue = new LinkedList<>();
    for (int i = 0; i < r; i++) {
      String line = br.readLine();
      for (int j = 0; j < c; j++) {
        map[i][j] = line.charAt(j);
        fire[i][j] = -1;
        ji[i][j] = -1;
        if (map[i][j] == 'F') {
          fireQueue.offer(new int[]{i, j});
          fire[i][j] = 0;
        } else if (map[i][j] == 'J') {
          jiQueue.offer(new int[]{i, j});
          ji[i][j] = 0;
        }
      }
    }


    while (!fireQueue.isEmpty()) {
      int[] pos = fireQueue.poll();
      for (int d = 0; d < 4; d++) {
        int nx = pos[0] + dx[d];
        int ny = pos[1] + dy[d];
        if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] == '.' && fire[nx][ny] == -1) {
          fire[nx][ny] = fire[pos[0]][pos[1]] + 1;
          fireQueue.offer(new int[]{nx, ny});
        }
      }
    }

    while (!jiQueue.isEmpty()) {
      int[] pos = jiQueue.poll();
      for (int d = 0; d < 4; d++) {
        int nx = pos[0] + dx[d];
        int ny = pos[1] + dy[d];
        if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
          time = ji[pos[0]][pos[1]] + 1;
          System.out.println(time);
          return;
        }
        if (map[nx][ny] == '.' && ji[nx][ny] == -1 && (fire[nx][ny] == -1 || fire[nx][ny] > ji[pos[0]][pos[1]] + 1)) {
            ji[nx][ny] = ji[pos[0]][pos[1]] + 1;
            jiQueue.offer(new int[]{nx, ny});
        }
      }
    }

    System.out.println("IMPOSSIBLE");
  }

}