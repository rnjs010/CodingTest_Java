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
            mArr[i / 5].put(minerals[i], mArr[i / 5].getOrDefault(minerals[i], 0) + 1);
        }
        
        List<String> priority = List.of("diamond", "iron", "stone");
        Arrays.sort(mArr, (a, b) -> {
            for (String key: priority) {
                int cmp = Integer.compare(b.getOrDefault(key, 0), a.getOrDefault(key, 0));
                if (cmp != 0) return cmp;
            }
            return 0;
        });
        
        int answer = 0;
        for (int i = 0; i < picks[0]; i++) {
            answer += mArr[i].getOrDefault("diamond", 0) + mArr[i].getOrDefault("iron", 0) + mArr[i].getOrDefault("stone", 0);
        }
        
        for (int i = picks[0]; i < picks[0] + picks[1]; i++) {
            answer += (mArr[i].getOrDefault("diamond", 0) * 5) + mArr[i].getOrDefault("iron", 0) + mArr[i].getOrDefault("stone", 0);
        }
        
        for (int i = picks[0] + picks[1]; i < can; i++) {
            answer += (mArr[i].getOrDefault("diamond", 0) * 25) + (mArr[i].getOrDefault("iron", 0) * 5) + mArr[i].getOrDefault("stone", 0);
        }
        
        return answer;
    }
}