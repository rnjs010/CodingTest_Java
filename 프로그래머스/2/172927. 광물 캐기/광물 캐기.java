import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int can = picks[0] + picks[1] + picks[2];
        
        Map<String, Integer>[] mArr = new HashMap[can];
        for (int i = 0; i < can; i++) {
            mArr[i] = new HashMap<>();
        }
        
        int maxM = Math.min(minerals.length, can * 5);
        for (int i = 0; i < maxM; i++) {
            int g = i / 5;
            mArr[g].put(minerals[i],
                mArr[g].getOrDefault(minerals[i], 0) + 1
            );
        }
        
        Arrays.sort(mArr, (a, b) -> {
            int d = b.getOrDefault("diamond", 0) - a.getOrDefault("diamond", 0);
            if (d != 0) return d;

            int i = b.getOrDefault("iron", 0) - a.getOrDefault("iron", 0);
            if (i != 0) return i;

            return b.getOrDefault("stone", 0) - a.getOrDefault("stone", 0);
        });
        
        int answer = 0;
        int idx = 0;
        for (int tool = 0; tool < 3; tool++) {
            for (int cnt = 0; cnt < picks[tool] && idx < can; cnt++) {
                Map<String, Integer> cur = mArr[idx];

                int dia = cur.getOrDefault("diamond", 0);
                int iron = cur.getOrDefault("iron", 0);
                int stone = cur.getOrDefault("stone", 0);

                if (tool == 0) {
                    answer += dia + iron + stone;
                } else if (tool == 1) {
                    answer += dia * 5 + iron + stone;
                } else {
                    answer += dia * 25 + iron * 5 + stone;
                }
                idx++;
            }
        }
        
        return answer;
    }
}