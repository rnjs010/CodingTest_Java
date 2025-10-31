import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        if (map.size() < answer) {
            answer = map.size();
        }
        return answer;
    }
}