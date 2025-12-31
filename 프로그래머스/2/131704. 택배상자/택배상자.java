import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Deque<Integer> dq = new ArrayDeque<>();
        int cur = 0;
        for (int i: order) {
            if (!dq.isEmpty() && dq.peekFirst() == i) {
                dq.pollFirst();
                answer++;
                continue;
            }
            
            if (cur > i) break;
            while (cur <= i) {
                cur++;
                if (cur == i) {
                    answer++;
                    break;
                }
                dq.offerFirst(cur);
            }
        }
        
        return answer;
    }
}