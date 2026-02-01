import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int t = 0; t < 5; t++) {
            char[][] map = new char[5][5];
            for (int i = 0; i < 5; i++) {
                map[i] = places[t][i].toCharArray();
            }

            boolean ok = true;

            for (int i = 0; i < 5 && ok; i++) {
                for (int j = 0; j < 5 && ok; j++) {
                    if (map[i][j] == 'P') {
                        if (!bfs(map, i, j)) {
                            ok = false;
                        }
                    }
                }
            }

            answer[t] = ok ? 1 : 0;
        }

        return answer;
    }

    boolean bfs(char[][] map, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];

        q.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];

            if (dist >= 2) continue;

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                int nd = dist + 1;

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 'X') continue;

                if (map[nx][ny] == 'P') return false;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, nd});
            }
        }
        return true;
    }
}