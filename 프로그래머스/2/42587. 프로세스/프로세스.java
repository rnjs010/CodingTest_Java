import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> pq = new PriorityQueue<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i : priorities) {
            pq.offer(-i);
            dq.offerLast(-i);
        }
        
        int idx = location, cnt = 0;
        while(!dq.isEmpty()) {
            int a = dq.pollFirst();
            if (a > pq.peek()) {
                dq.offerLast(a);
                idx = (idx != 0) ? idx - 1 : dq.size() - 1;
            } else {
                pq.poll();
                cnt++;
                if (idx == 0) break;
                idx -=1;
            }
        }
        
        return cnt;
    }
}