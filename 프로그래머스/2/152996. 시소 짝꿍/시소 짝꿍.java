import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        Map<Integer, Long> map = new HashMap<>();
        for (int w : weights) {
            map.put(w, map.getOrDefault(w, 0L) + 1);
        }

        for (long cnt : map.values()) {
            if (cnt >= 2) {
                answer += cnt * (cnt - 1) / 2;
            }
        }

        for (int w : map.keySet()) {
            long cnt = map.get(w);

            // 2 : 3
            if (w * 3 % 2 == 0) {
                int target = w * 3 / 2;
                if (w < target && map.containsKey(target)) {
                    answer += cnt * map.get(target);
                }
            }

            // 2 : 4
            int target2 = w * 2;
            if (w < target2 && map.containsKey(target2)) {
                answer += cnt * map.get(target2);
            }

            // 3 : 4
            if (w * 4 % 3 == 0) {
                int target = w * 4 / 3;
                if (w < target && map.containsKey(target)) {
                    answer += cnt * map.get(target);
                }
            }
        }

        return answer;
    }
}
