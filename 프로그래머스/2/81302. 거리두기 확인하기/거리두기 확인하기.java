import java.util.*;

class Solution {
    char[][] map;
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int t = 0; t < 5; t++) {
            map = new char[5][5];
            List<int[]> people = new ArrayList<>();
            
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    map[i][j] = places[t][i].charAt(j);
                    if (map[i][j] == 'P') {
                        people.add(new int[]{i, j});
                    }
                }
            }
            
            boolean ok = true;
            for (int p = 0; p < people.size() - 1; p++) {
                for (int p2 = p + 1; p2 < people.size(); p2++) {
                    if (!check(people.get(p), people.get(p2))) {
                        ok = false;
                        break;
                    }
                }
                if (!ok) break;
            }
            
            answer[t] = ok ? 1 : 0;
        }
        
        return answer;
    }
    
    public boolean check(int[] p1, int[] p2) {
        int dist = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
        if (dist > 2) return true;
        if (dist == 1) return false;
        if (p1[0] == p2[0]) {
            int midY = (p1[1] + p2[1]) / 2;
            return map[p1[0]][midY] == 'X';
        }
        if (p1[1] == p2[1]) {
            int midX = (p1[0] + p2[0]) / 2;
            return map[midX][p1[1]] == 'X';
        }
        if (map[p1[0]][p2[1]] == 'X' && map[p2[0]][p1[1]] == 'X') return true;
        return false;
    }
}