import java.util.*;

class Solution {
    public long solution(int n, int[] works) {        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int w: works) {
            pq.add(w);
        }
        
        for (int i = 0; i < n; i++) {
            pq.add(pq.poll() - 1);
        }
        
        long answer = 0;
        if (pq.peek() <= 0) return 0;
        while(!pq.isEmpty()) {
            answer += (long) Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}