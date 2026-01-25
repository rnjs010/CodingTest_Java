import java.util.*;

class Solution {
    int[][] map;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = num++;
            }
        }
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i]);
        }
        
        return answer;
    }
    
    public int rotate(int[] q) {
        Deque<Integer> dq = new ArrayDeque<>();
        int x1 = q[0] - 1, y1 = q[1] - 1;
        int x2 = q[2] - 1, y2 = q[3] - 1;
        int minVal = Integer.MAX_VALUE;
        
        for (int i = y1; i < y2; i++) {
            dq.offer(map[x1][i]);
            minVal = Math.min(minVal, map[x1][i]);
        }
        
        for (int i = x1; i < x2; i++) {
            dq.offer(map[i][y2]);
            minVal = Math.min(minVal, map[i][y2]);
        }
        
        for (int i = y2; i > y1; i--) {
            dq.offer(map[x2][i]);
            minVal = Math.min(minVal, map[x2][i]);
        }
        
        for (int i = x2; i > x1; i--) {
            dq.offer(map[i][y1]);
            minVal = Math.min(minVal, map[i][y1]);
        }
        
        dq.offerFirst(dq.pollLast());
        
        for (int i = y1; i < y2; i++) {
            map[x1][i] = dq.pollFirst();
        }
        
        for (int i = x1; i < x2; i++) {
            map[i][y2] = dq.pollFirst();
        }
        
        for (int i = y2; i > y1; i--) {
            map[x2][i] = dq.pollFirst();
        }
        
        for (int i = x2; i > x1; i--) {
            map[i][y1] = dq.pollFirst();
        }
        
        return minVal;
    }
}