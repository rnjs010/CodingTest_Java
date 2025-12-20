import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        String s1 = str1.toLowerCase();
        String s2 = str2.toLowerCase();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for (int i = 0; i < s1.length() - 1; i++) {
            char c1 = s1.charAt(i);
            char c2 = s1.charAt(i + 1);
            if (c1 >= 'a' && c1 <= 'z' && c2 >= 'a' && c2 <= 'z') {
                String pair = "" + c1 + c2;
                map1.put(pair, map1.getOrDefault(pair, 0) + 1);
            }
        }
        
        for (int i = 0; i < s2.length() - 1; i++) {
            char c1 = s2.charAt(i);
            char c2 = s2.charAt(i + 1);

            if (c1 >= 'a' && c1 <= 'z' && c2 >= 'a' && c2 <= 'z') {
                String pair = "" + c1 + c2;
                map2.put(pair, map2.getOrDefault(pair, 0) + 1);
            }
        }
        
        int inter = 0, union = 0;
        for (String k: map1.keySet()) {
            if (map2.containsKey(k)) {
                inter += Math.min(map1.get(k), map2.get(k));
            }
        }
        
        Set<String> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        for (String k : keys) {
            union += Math.max(map1.getOrDefault(k, 0), map2.getOrDefault(k, 0));
        }
        
        if (union == 0) return 65536;
        answer = (int)((double) inter / union * 65536);
        
        return answer;
    }
}