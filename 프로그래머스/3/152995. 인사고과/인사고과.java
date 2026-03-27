import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] target = scores[0];
        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        
        int maxSec = 0;
        int answer = 1;
        for (int[] s: scores) {
            if (s[1] < maxSec) continue;
            if (s[0] > target[0] && s[1] > target[1]) return -1;
            
            maxSec = Math.max(maxSec, s[1]);
            if (s[0] + s[1] > target[0] + target[1]) {
                answer++;
            }
        }
        
        return answer;
    }
}