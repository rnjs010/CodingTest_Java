import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        
        for (int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            pq.offer(-1*enemy[i]);
            answer = i + 1;
            if (n < 0) {
                if (k != 0) {
                    k -= 1;
                    n -= pq.poll();
                } else {
                    answer -= 1;
                    break;
                }
            }
        }
        
        return answer;
    }
}