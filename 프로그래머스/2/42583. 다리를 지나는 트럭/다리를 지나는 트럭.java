import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Deque<Integer> dq = new ArrayDeque<>();
        int idx = 0, sum = 0;
        while (true) {
            if (dq.isEmpty()) {
                dq.offerLast(truck_weights[idx]);
                answer += 1;
                sum += truck_weights[idx];
            } else if (dq.size() < bridge_length) {
                if (sum + truck_weights[idx+1] > weight) {
                    dq.offerLast(0);
                    answer += 1;
                } else {
                    idx++;
                    dq.offerLast(truck_weights[idx]);
                    answer += 1;
                    sum += truck_weights[idx];
                }
            } else if (dq.size() == bridge_length) {
                sum -= dq.pollFirst();
            }
            
            if (idx == truck_weights.length - 1) break;
        }
        
        answer += bridge_length;
        return answer;
    }
}