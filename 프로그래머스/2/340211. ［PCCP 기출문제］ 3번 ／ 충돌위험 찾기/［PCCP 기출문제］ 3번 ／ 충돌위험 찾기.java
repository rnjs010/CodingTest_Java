import java.util.*;

class Solution {
    static Deque<int[]>[] all;
    static int robot;
    
    public int solution(int[][] points, int[][] routes) {
        robot = routes.length;
        all = new ArrayDeque[robot];
        for (int i = 0; i < robot; i++) {
            all[i] = new ArrayDeque<>();
        }
        
        findRoute(points, routes);
        
        int answer = check();
        return answer;
    }
    
    static void findRoute(int[][] points, int[][] routes) {
        for (int i = 0; i < robot; i++) {
            int[] route = routes[i];
            int sX = points[route[0] - 1][0];
            int sY = points[route[0] - 1][1];
            all[i].offerLast(new int[]{sX, sY});
            
            for (int m = 1; m < route.length; m++) {
                int eX = points[route[m] - 1][0], eY = points[route[m] - 1][1];
                while (sX != eX) {
                    if (sX < eX) sX++;
                    else sX--;
                    all[i].offerLast(new int[]{sX, sY});
                }
                while (sY != eY) {
                    if (sY < eY) sY++;
                    else sY--;
                    all[i].offerLast(new int[]{sX, sY});
                }
            }
        }
    }
    
    static int check() {
        int cnt = 0;
        while (true) {
            int size = robot;
            int[][] map = new int[101][101];

            for (int i = 0; i < robot; i++) {
                if(all[i].isEmpty()) {
                    size--;
                    continue;
                }
                int[] cur = all[i].pollFirst();
                map[cur[0]][cur[1]]++;
            }
            
            if (size == 0) break;
            
            for (int i = 0; i < 101; i++) {
                for (int j = 0; j < 101; j++) {
                    if (map[i][j] > 1) cnt++;
                }
            }
        }
        return cnt;
    }
    
}