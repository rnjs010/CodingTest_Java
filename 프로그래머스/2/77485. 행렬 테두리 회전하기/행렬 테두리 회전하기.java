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
        int x1 = q[0] - 1, y1 = q[1] - 1;
        int x2 = q[2] - 1, y2 = q[3] - 1;
        int temp = map[x1][y1];
        int min = temp;

        // 왼쪽
        for (int i = x1; i < x2; i++) {
            map[i][y1] = map[i + 1][y1];
            min = Math.min(min, map[i][y1]);
        }

        // 아래
        for (int j = y1; j < y2; j++) {
            map[x2][j] = map[x2][j + 1];
            min = Math.min(min, map[x2][j]);
        }

        // 오른쪽
        for (int i = x2; i > x1; i--) {
            map[i][y2] = map[i - 1][y2];
            min = Math.min(min, map[i][y2]);
        }

        // 위
        for (int j = y2; j > y1 + 1; j--) {
            map[x1][j] = map[x1][j - 1];
            min = Math.min(min, map[x1][j]);
        }

        map[x1][y1 + 1] = temp;

        
        return min;
    }
}