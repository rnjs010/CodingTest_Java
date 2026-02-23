import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (String str: operations) {
            int value = Integer.parseInt(str.substring(2));
            if (str.charAt(0) == 'I') {
                map.put(value, map.getOrDefault(value, 0) + 1);
                continue;
            } 
            
            if (map.isEmpty()) continue;
            if (value == 1) {
                delete(map, map.lastKey()); 
            } else {
                delete(map, map.firstKey());
            }
        }
        
        int[] answer = new int[2];
        if (!map.isEmpty()) {
            answer[0] = map.lastKey();
            answer[1] = map.firstKey();
        }
        return answer;
    }
    
    private void delete(TreeMap<Integer, Integer> map, int key) {
        int count = map.get(key);
        if (count == 1) {
            map.remove(key);
        } else {
            map.put(key, count - 1);
        }
    }
}