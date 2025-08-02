import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i : arr) {
            if (dq.isEmpty()) {
                dq.offerLast(i);
            }
            else if (dq.peekLast() != i) {
                dq.offerLast(i);
            }
        }
        
        int len = dq.size();
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = dq.pollFirst();
        }

        return answer;
    }
}