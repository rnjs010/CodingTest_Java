import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int can = picks[0] + picks[1] + picks[2];
        int maxM = Math.min(minerals.length, can * 5);
        
        int[][] mArr = new int[can][3];
        for (int i = 0; i < maxM; i++) {
            int idx = i / 5;
            switch(minerals[i]) {
                case "diamond": mArr[idx][0]++; break;
                case "iron": mArr[idx][1]++; break;
                case "stone": mArr[idx][2]++; break;
            }
        }

        Arrays.sort(mArr, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            if (a[1] != b[1]) return b[1] - a[1];
            return b[2] - a[2];
        });
        
        int[][] map = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        
        int answer = 0;
        int groupIdx = 0;
        for (int tool = 0; tool < 3; tool++) {
            for (int cnt = 0; cnt < picks[tool] && groupIdx < can; cnt++) {
                for (int i = 0; i < 3; i++) {
                    answer += mArr[groupIdx][i] * map[tool][i];
                }
                groupIdx++;
            }
        }
        return answer;
    }
}