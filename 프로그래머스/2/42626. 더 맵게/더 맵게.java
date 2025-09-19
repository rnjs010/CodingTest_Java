import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.offer(i);
        }

        boolean check = true;
        while (true) {
            if (pq.peek() >= K) break;
            if (pq.size() < 2) {
                check = false;
                break;
            }
            answer++;
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a + b * 2);
        }
        
        if (!check) answer = -1;
        
        return answer;
    }
}