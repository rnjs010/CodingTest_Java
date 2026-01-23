import java.util.*;

class Solution {
    int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    int n, m;
    boolean[][] visit;

    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        visit = new boolean[n][m];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && maps[i].charAt(j) != 'X') {
                    list.add(bfs(i, j, maps));
                }
            }
        }

        if (list.isEmpty()) return new int[]{-1};

        Collections.sort(list);
        return list.stream().mapToInt(i -> i).toArray();
    }

    int bfs(int x, int y, String[] maps) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;

        int sum = maps[x].charAt(y) - '0';

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visit[nx][ny] || maps[nx].charAt(ny) == 'X') continue;

                visit[nx][ny] = true;
                sum += maps[nx].charAt(ny) - '0';
                q.offer(new int[]{nx, ny});
            }
        }
        return sum;
    }
}
