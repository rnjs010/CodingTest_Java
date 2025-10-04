import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        Deque<int[]> dStk = new ArrayDeque<>();
        Deque<int[]> pStk = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deliveries[i] != 0) {
                dStk.offerLast(new int[] {i + 1, deliveries[i]});
            }
            if (pickups[i] != 0) {
                pStk.offerLast(new int[] {i + 1, pickups[i]});
            }
        }
        
        long ans = 0;
        while (!dStk.isEmpty() || !pStk.isEmpty()) {
            int[] d = new int[2]; 
            int[] p = new int[2];
            
            if (!dStk.isEmpty()) d = dStk.peekLast();
            if (!pStk.isEmpty()) p = pStk.peekLast();
            ans += 2 * Math.max(d[0], p[0]);
            
            int canD = cap;
            while (!dStk.isEmpty()) {
                d = dStk.pollLast();
                if (canD == d[1]) {
                    break;
                } else if (canD > d[1]) {
                    canD -= d[1];
                } else if (canD < d[1]) {
                    dStk.offerLast(new int[] {d[0], d[1] - canD});
                    break;
                }
            }
            
            int canP = cap;
            while (!pStk.isEmpty()) {
                p = pStk.pollLast();
                if (canP == p[1]) {
                    break;
                } else if (canP > p[1]) {
                    canP -= p[1];
                } else if (canP < p[1]) {
                    pStk.offerLast(new int[] {p[0], p[1] - canP});
                    break;
                }
            }

        }

        return ans;
    }
}