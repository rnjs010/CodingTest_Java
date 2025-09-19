import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // parti를 map에 추가하고 -> comp를 빼고 -> 확인
        Map<String, Integer> p = new HashMap<>();
        for (String name: participant) {
            if (p.containsKey(name)) {
                p.put(name, p.get(name) + 1);
            } else {
                p.put(name, 1);
            }
        }

        for (String name: completion) {
            if (p.get(name) == 1) {
                p.remove(name);
            } else {
                p.put(name, p.get(name) - 1);
            }
        }
        
        Set<String> key = p.keySet();
        for (String k: key) {
            answer = k;
        }
        
        return answer;
    }
}