import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        int answer = 0;
        int last = -1 * Integer.MAX_VALUE;
        for (int[] t: targets) {
            if (t[0] >= last) {
                answer++;
                last = t[1];
            }
        }
        
        return answer;
    }
}