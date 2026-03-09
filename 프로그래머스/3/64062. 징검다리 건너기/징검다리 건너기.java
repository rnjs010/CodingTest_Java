import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        // 앞 -> 최대값의 인덱스, 뒤 -> 작은값의 인덱스
        Deque<Integer> dq = new ArrayDeque<>();
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < stones.length; i++) {
            // 윈도우 벗어난 인덱스 제거
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            
            // 현재 값보다 작은 값 뒤에서 제거
            while (!dq.isEmpty() && stones[dq.peekLast()] <= stones[i]) {
                dq.pollLast();
            }
            
            dq.addLast(i);
            
            // 윈도우 완성         
            if (i >= k - 1) {
                answer = Math.min(answer, stones[dq.peekFirst()]);
            }
        }
        
        return answer;
    }
}