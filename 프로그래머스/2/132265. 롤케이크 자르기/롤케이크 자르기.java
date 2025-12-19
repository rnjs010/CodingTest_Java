import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> rMap = new HashMap<>();
        Map<Integer, Integer> lMap = new HashMap<>();
        for (int i: topping) {
            rMap.put(i, rMap.getOrDefault(i, 0) + 1); 
        }
        
        for (int i = 0; i < topping.length - 1; i++) {
            int key = topping[i];
            lMap.put(key, lMap.getOrDefault(key, 0) + 1);
            rMap.put(key, rMap.get(key) - 1);
            if (rMap.get(key) == 0) {
                rMap.remove(key);
            }

            if (lMap.size() == rMap.size()) answer++;
        }
        return answer;
    }
}