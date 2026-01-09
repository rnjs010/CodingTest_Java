import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int w: weights) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        
        for (long cnt : map.values()) {
            if (cnt >= 2) {
                answer += cnt * (cnt - 1) / 2;
            }
        }
        
        for (int k: map.keySet()) {
            long cnt = map.get(k);
            
            // 2 : 3
            if (k * 3 % 2 == 0) {
                int target = k * 3 / 2;
                if (map.containsKey(target)) {
                    answer += cnt * map.get(target);
                }
            }

            // 2 : 4 (즉 1 : 2)
            int target2 = k * 2;
            if (map.containsKey(target2)) {
                answer += cnt * map.get(target2);
            }

            // 3 : 4
            if (k * 4 % 3 == 0) {
                int target = k * 4 / 3;
                if (map.containsKey(target)) {
                    answer += cnt * map.get(target);
                }
            }
        }
        return answer;
    }
}