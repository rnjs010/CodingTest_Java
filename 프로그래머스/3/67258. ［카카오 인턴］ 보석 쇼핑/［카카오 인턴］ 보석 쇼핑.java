import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> kind = new HashSet<>(Arrays.asList(gems));
        int len = kind.size();
        
        Map<String, Integer> pick = new HashMap<>();
        int l = 0;
        int minVal = Integer.MAX_VALUE;
        int[] answer = new int[2];
        for (int r = 0; r < gems.length; r++) {
            pick.put(gems[r], pick.getOrDefault(gems[r], 0) + 1);
            while (pick.size() == len) {
                if (r - l < minVal) {
                    minVal = r - l;
                    answer[0] = l + 1;
                    answer[1] = r + 1;
                }
                String g = gems[l];
                pick.put(g, pick.get(g) - 1);
                if (pick.get(g) == 0) pick.remove(g);
                l++;
            }
        }
        
        return answer;
    }
}