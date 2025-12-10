import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i: tangerine) {
            cnt.put(i, cnt.getOrDefault(i, 0) + 1);
        }
        
        List<Integer> cntList = new ArrayList<>(cnt.values());
        cntList.sort(Comparator.reverseOrder());
        
        int sum = 0;
        for (int i: cntList) {
            sum += i;
            answer++;
            if (sum >= k) break;
        }
            
        return answer;
    }
}