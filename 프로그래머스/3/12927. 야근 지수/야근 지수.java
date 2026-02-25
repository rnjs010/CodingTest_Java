import java.util.*;

class Solution {
    public long solution(int n, int[] works) {        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for (int w: works) {
            pq.add(w);
            sum += w;
        }
        
        if (sum <= n) return 0;
        
        for (int i = 0; i < n; i++) {
            int max = pq.poll();
            if (max == 0) {
                pq.add(0);
                break;
            }
            pq.add(max - 1);
        }
        
        long answer = 0;
        while(!pq.isEmpty()) {
            long x = pq.poll();
            answer += x * x;
        }
        
        return answer;
    }
}